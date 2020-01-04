package kr.market.fluff.ui.fragment

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager.widget.ViewPager
import com.tbuonomo.viewpagerdotsindicator.DotsIndicator
import kotlinx.android.synthetic.main.fragment_home.*
import kr.market.fluff.R
import kr.market.fluff.data.App
import kr.market.fluff.data.home.*
import kr.market.fluff.network.RequestInterface
import kr.market.fluff.network.RequestToServer
import kr.market.fluff.network.safeEnqueue
import kr.market.fluff.ui.MainActivity
import kr.market.fluff.ui.fragment.home.home_detail.HomeNewActivity
import kr.market.fluff.ui.fragment.home.home_detail.HomePlubActivity
import kr.market.fluff.ui.fragment.home.home_detail.HomeRecentActivity
import kr.market.fluff.ui.fragment.home.home_detail.HomeRecommendActivity
import kr.market.fluff.ui.fragment.home.recycler_auction.HomeAuctionAdapter
import kr.market.fluff.ui.fragment.home.recycler_common.HomeNewAdapter
import kr.market.fluff.ui.fragment.home.recycler_common.HomeRecentAdapter
import kr.market.fluff.ui.fragment.home.recycler_common.HomeRecommendAdapter
import kr.market.fluff.ui.fragment.home.recycler_plub.HomePlubAdapter
import kr.market.fluff.ui.fragment.home.viewpager.ViewPagerAdapter
import kr.market.fluff.ui.recommendStyle.RecommendStyleActivity
import kr.market.fluff.ui.util.item_decorator.HorizontalItemDecorator
import kr.market.fluff.ui.util.sendToast
import java.time.LocalDate

class HomeFragment : Fragment() {
    lateinit var rv_home_new: RecyclerView
    lateinit var newAdapter: HomeNewAdapter

    lateinit var rv_home_recent: RecyclerView
    lateinit var recentAdapter: HomeRecentAdapter

    lateinit var rv_home_recommend: RecyclerView
    lateinit var recommendAdapter: HomeRecommendAdapter

    lateinit var rv_home_plub: RecyclerView
    lateinit var plubAdapter: HomePlubAdapter

    lateinit var rv_home_auction: RecyclerView
    lateinit var auctionAdapter: HomeAuctionAdapter

    var auction_datas = ArrayList<RequestInterface.AuctionItemData>()

    val requestToServer = RequestToServer

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(kr.market.fluff.R.layout.fragment_home, container, false)

        // Inflate the layout for this fragment
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        init()

        makeNewRecycler(view)
        makeRecentRecycler(view)
        makeRecommendRecycler(view)
        makePlubRecycler(view)
        makeOctionRecycler(view)
        makeHomeViewPager(view)
        changeView()
        // makeKeywordRecycler(view)


    }

    fun init() {
        tv_home_recent_keyword.text = "니트"
        tv_home_recentsubtitle_keyword.text = tv_home_recent_keyword.text

        val date: LocalDate = LocalDate.now()
        var date_value: Int = date.dayOfWeek.value

        when (date_value) {
            1 -> tv_home_recommend_keyword.text = "월요일"
            2 -> tv_home_recommend_keyword.text = "화요일"
            3 -> tv_home_recommend_keyword.text = "수요일"
            4 -> tv_home_recommend_keyword.text = "목요일"
            5 -> tv_home_recommend_keyword.text = "금요일"
            6 -> tv_home_recommend_keyword.text = "토요일"
            7 -> tv_home_recommend_keyword.text = "일요일"
        }

        // makeHomeRecycler()
    }

    fun changeView() {
        img_home_newicon.setOnClickListener {
            val intent = Intent(context, HomeNewActivity::class.java)
            intent.putExtra("new_keyword", tv_home_new_keyword.text.toString())
            startActivity(intent)
        }
        img_home_auctionicon.setOnClickListener { (activity as MainActivity).replaceFragment(2) }

        img_home_plubicon.setOnClickListener {
            val intent = Intent(context, HomePlubActivity::class.java)
            startActivity(intent)
        }

        img_home_recenticon.setOnClickListener {
            val intent = Intent(context, HomeRecentActivity::class.java)
            intent.putExtra("recent_keyword", tv_home_recent_keyword.text.toString())
            startActivity(intent)
        }
        img_home_recommendicon.setOnClickListener {
            val intent = Intent(context, HomeRecommendActivity::class.java)
            intent.putExtra("recommend_keyword", tv_home_recommend_keyword.text.toString())
            startActivity(intent)
        }
    }


    fun makeHomeViewPager(view : View)
    {
        val dotsIndicator= view.findViewById<DotsIndicator>(R.id.dots_indicator)
        val viewPager = view.findViewById<ViewPager>(R.id.vp_home_viewpager)
        val adapter = ViewPagerAdapter(childFragmentManager,4)
        viewPager.adapter = adapter
        dotsIndicator.setViewPager(viewPager)
        vp_home_viewpager.adapter = adapter
        vp_home_viewpager.offscreenPageLimit = 2

    }

    //오늘 입고되었어요!
    fun makeNewRecycler(view: View) {
        rv_home_new = view.findViewById(kr.market.fluff.R.id.rv_home_new)

        requestToServer.service.request_home_Newest("application/json", App.prefs.local_login_token!!,"newest",7)
            .safeEnqueue(
                onSuccess = {
                    newAdapter = HomeNewAdapter(it)
                    newAdapter.notifyDataSetChanged()
                    rv_home_new.apply {
                        layoutManager = LinearLayoutManager(context,LinearLayoutManager.HORIZONTAL,false)
                        adapter = newAdapter
                        addItemDecoration(HorizontalItemDecorator(24))
                    }
                },
                onFail = { _, _ ->
                    sendToast("서버 응답이 없습니다.")
                })

    }

    //당신을 위한 무스탕 추천
    fun makeRecentRecycler(view: View) {
        rv_home_recent = view.findViewById(kr.market.fluff.R.id.rv_home_recent)

        requestToServer.service.request_home_Category(
            "application/json",
            App.prefs.local_login_token!!,
            "knit",
            7
        )
            .safeEnqueue(
                onSuccess = {
                    recentAdapter = HomeRecentAdapter(it)
                    recentAdapter.notifyDataSetChanged()
                    rv_home_recent.apply {
                        layoutManager =
                            LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
                        adapter = recentAdapter
                        addItemDecoration(HorizontalItemDecorator(24))
                    }
                },
                onFail = { _, _ ->
                    sendToast("서버 응답이 없습니다")
                })
    }

    //요일별 추천
    fun makeRecommendRecycler(view: View) {
        rv_home_recommend = view.findViewById(kr.market.fluff.R.id.rv_home_recommend)

        requestToServer.service.request_home_Thumbnail(
            "application/json",
            App.prefs.local_login_token!!,
            7
        )
            .safeEnqueue(
                onSuccess = {
                    recommendAdapter = HomeRecommendAdapter(it)
                    recommendAdapter.notifyDataSetChanged()
                    rv_home_recommend.apply {
                        layoutManager =
                            LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
                        adapter = recommendAdapter
                        addItemDecoration(HorizontalItemDecorator(24))
                    }
                },
                onFail = { _, _ ->
                    sendToast("서버 응답이 없습니다")
                })
    }

    //Plub 추천
    fun makePlubRecycler(view: View) {
        rv_home_plub = view.findViewById(kr.market.fluff.R.id.rv_home_plub)

        requestToServer.service.requestRecommendSeller(
            "application/json",
            App.prefs.local_login_token!!,
            5
        )
            .safeEnqueue(
                onSuccess = {
                    plubAdapter = HomePlubAdapter(it)
                    plubAdapter.notifyDataSetChanged()
                    rv_home_plub.apply {
                        layoutManager =
                            LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
                        adapter = plubAdapter
                        addItemDecoration(HorizontalItemDecorator(24))
                    }

                },
                onFail = { _, _ ->
                }
            )
    }

    fun loadAuctionData(){
        RequestToServer.service.requestAuctionLIst("application/json",App.prefs.local_login_token!!).safeEnqueue(
            onSuccess = {
                auction_datas = it
                auctionAdapter.data = auction_datas
                auctionAdapter.notifyDataSetChanged()
            }
        )
    }
    fun makeOctionRecycler(view: View) {
        loadAuctionData()
//        auction_data = listOf(
//            HomeAuctionData(
//                R.drawable.auction_1,
//                "곧 경매 종료", "Yves Saint Laurent 원피스"
//            ),
//            HomeAuctionData(
//                R.drawable.auction_2,
//                "종료까지 2시간", "MaxMara 만다린 자켓"
//            ),
//            HomeAuctionData(
//                R.drawable.auction_3,
//                "종료까지 4시간 ", "샤네루 1990’s 트위드 재킷"
//            )
//        )
        rv_home_auction = view.findViewById(R.id.rv_home_auction)
        auctionAdapter = HomeAuctionAdapter(auction_datas)
        rv_home_auction.apply {
            layoutManager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
            adapter = auctionAdapter
            addItemDecoration(HorizontalItemDecorator(24))
        }
    }
}


/*
    fun makeKeywordRecycler(view : View)
    {
        keyword_datas = listOf(
            HomeKeywordData("#스카프",R.drawable.img_keyword),
            HomeKeywordData("#데님",R.drawable.img_keyword),
            HomeKeywordData("#중절모",R.drawable.img_keyword)
        )
        rv_home_keyword = view.findViewById(R.id.rv_home_keyword)
        keywordAdapter = HomeKeywordAdapter(keyword_datas)

        rv_home_keyword.apply {
            layoutManager = LinearLayoutManager(context,LinearLayoutManager.VERTICAL,false)
            adapter = keywordAdapter
            addItemDecoration(VerticalItemDecorator(24))
        }
//        val snapHelper = LinearSnapHelper()
//        snapHelper.attachToRecyclerView(rv_home_keyword)
    }
    */





