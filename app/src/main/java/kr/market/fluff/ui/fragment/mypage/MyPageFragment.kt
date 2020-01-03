package kr.market.fluff.ui.fragment.mypage

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.LinearSnapHelper
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.activity_my_info_update.*
import kotlinx.android.synthetic.main.fragment_my_page.*
import kr.market.fluff.R
import kr.market.fluff.data.App
import kr.market.fluff.data.mypage.MyPageRecentSawGoods
import kr.market.fluff.ui.MainActivity
import kr.market.fluff.ui.fragment.mypage.applySeller.ApplySellerActivity
import kr.market.fluff.ui.fragment.mypage.applySeller.SellerEditActivity
import kr.market.fluff.ui.fragment.mypage.cart.CartActivity
import kr.market.fluff.ui.fragment.mypage.favorite.FavoriteActivity
import kr.market.fluff.ui.fragment.mypage.transfer.ConfirmTransferActivity
import kr.market.fluff.ui.fragment.mypage.update.MyInfoUpdateActivity
import kr.market.fluff.ui.util.item_decorator.HorizontalItemDecorator
import kr.market.fluff.ui.util.item_decorator.VerticalItemDecorator


class MyPageFragment(private val activity : Activity) : Fragment() {
    lateinit var recentSawAdapter: RecentSawAdapter
    lateinit var rv_mypage_recent_goods : RecyclerView
    lateinit var recent_goods_datas : ArrayList<MyPageRecentSawGoods>
    var REQ_CODE = 1
    val pf = App.prefs

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_my_page, container, false)
    }
    private fun setRecycler(view : View){
        tv_mypage_user_name.text = App.prefs.local_nick_name
        tv_mypage_user_email.text = App.prefs.local_login_id
        recent_goods_datas = ArrayList()
        rv_mypage_recent_goods = view.findViewById(R.id.rv_mypage_recent_goods)
        recentSawAdapter = RecentSawAdapter(view.context)
        addItems()
        recentSawAdapter.data = recent_goods_datas

        rv_mypage_recent_goods.apply {
            layoutManager = LinearLayoutManager(context,LinearLayoutManager.HORIZONTAL,false)
            adapter = recentSawAdapter
            addItemDecoration(HorizontalItemDecorator(24))
        }
    }
    private fun init(){

        tv_mypage_user_name.text = pf.local_nick_name!!
        ll_my_cart.setOnClickListener{startActivity(Intent(this.context,CartActivity::class.java))}
        ll_my_favorite.setOnClickListener{
            val intent = Intent(this.context,
                FavoriteActivity::class.java)
            startActivity(intent)
        }
        rl_confirm_transfer.setOnClickListener{
            val intent = Intent(this.context,
                ConfirmTransferActivity::class.java)
            startActivity(intent)
        }
        rl_my_logout.setOnClickListener{
            val logoutDialog = LogoutDialog(activity,view!!.context)
            logoutDialog.show()
        }
        rl_myInfo_update.setOnClickListener {
            val intent = Intent(this.context, MyInfoUpdateActivity::class.java)
            intent.putExtra("myInfo_email",tv_mypage_user_email.text.toString())
            startActivityForResult(intent,REQ_CODE)
        }
    }

    private fun setCreateStore(){
        btn_mypage_create_store.setOnClickListener {
            var intent = Intent(context,SellerEditActivity::class.java)
            startActivity(intent)
        }
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setRecycler(view)
        init()
        setCreateStore()
    }
    private fun addItems(){
        recent_goods_datas.add(
            MyPageRecentSawGoods("https://cdn.pixabay.com/photo/2015/09/02/12/28/fashion-918446__340.jpg")
        )
        recent_goods_datas.add(
            MyPageRecentSawGoods("https://cdn.pixabay.com/photo/2016/04/19/13/39/store-1338629__340.jpg")
        )
        recent_goods_datas.add(
            MyPageRecentSawGoods("https://cdn.pixabay.com/photo/2016/04/08/18/46/shopping-mall-1316787__340.jpg")
        )
        recent_goods_datas.add(
            MyPageRecentSawGoods("https://cdn.pixabay.com/photo/2015/11/07/11/25/vest-1031127__340.jpg")
        )
    }
}
