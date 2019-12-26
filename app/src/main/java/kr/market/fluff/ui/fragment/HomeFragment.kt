package kr.market.fluff.ui.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TableLayout
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager.widget.ViewPager
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayout.OnTabSelectedListener
import com.tbuonomo.viewpagerdotsindicator.DotsIndicator
import com.tbuonomo.viewpagerdotsindicator.WormDotsIndicator
import kotlinx.android.synthetic.main.fragment_home.*
import kr.market.fluff.R
import kr.market.fluff.data.*
import kr.market.fluff.ui.cart.goodslist.HorizontalItemDecorator
import kr.market.fluff.ui.fragment.Home.home_recycler.recycler_common.HomeNewAdapter
import kr.market.fluff.ui.fragment.Home.home_recycler.recycler_common.HomeRecentAdapter
import kr.market.fluff.ui.fragment.Home.home_recycler.recycler_common.HomeRecommendAdapter
import kr.market.fluff.ui.fragment.Home.home_recycler.recycler_keyword.HomeKeywordAdapter
import kr.market.fluff.ui.fragment.Home.home_recycler.recycler_auction.HomeAuctionAdapter
import kr.market.fluff.ui.fragment.Home.home_recycler.recycler_plub.HomePlubAdapter
import kr.market.fluff.ui.fragment.viewpager.ViewPagerAdapter

class HomeFragment : Fragment() {
    lateinit var rv_home_new : RecyclerView
    lateinit var newAdapter: HomeNewAdapter
    lateinit var new_datas : List<HomeNewData>

    lateinit var rv_home_recent : RecyclerView
    lateinit var recentAdapter: HomeRecentAdapter
    lateinit var recent_datas : List<HomeRecentData>

    lateinit var rv_home_recommend : RecyclerView
    lateinit var recommendAdapter: HomeRecommendAdapter
    lateinit var recommend_datas : List<HomeRecommendData>

    lateinit var rv_home_plub : RecyclerView
    lateinit var plubAdapter: HomePlubAdapter
    lateinit var plub_datas : List<HomePlubData>

    lateinit var rv_home_keyword : RecyclerView
    lateinit var keywordAdapter: HomeKeywordAdapter
    lateinit var keyword_datas : List<HomeKeywordData>

    lateinit var rv_home_auction : RecyclerView
    lateinit var auctionAdapter: HomeAuctionAdapter
    lateinit var auction_data : List<HomeAuctionData>

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_home, container, false)

        // Inflate the layout for this fragment
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        makeNewRecycler(view)
        makeRecentRecycler(view)
        makeRecommendRecycler(view)
        makePlubRecycler(view)
        makeKeywordRecycler(view)
        makeOctionRecycler(view)
        makeHomeViewPager(view)
    }
    fun makeHomeViewPager(view : View)
    {
        val dotsIndicator= view.findViewById<DotsIndicator>(R.id.dots_indicator)
        val viewPager = view.findViewById<ViewPager>(R.id.vp_home_viewpager)
        val adapter = ViewPagerAdapter(childFragmentManager,3)
        viewPager.adapter = adapter
        dotsIndicator.setViewPager(viewPager)
        vp_home_viewpager.adapter = adapter
        vp_home_viewpager.offscreenPageLimit=2


    }

    fun makeNewRecycler(view : View)
    {
        new_datas = listOf(
            HomeNewData("https://previews.123rf.com/images/margolana/margolana1511/margolana151100248/48654416-%EA%B0%9C%EC%B2%B4-%EC%95%84%EC%9D%B4%EC%BD%98%EC%9D%98-%EA%B2%A8%EC%9A%B8-%EC%98%B7-%EA%B7%B8%EB%A3%B9%EC%9D%80-%ED%8C%A8%EC%85%98-%EC%9A%94%EC%86%8C-%EB%82%A8%EC%9E%90-%EC%9D%98%EB%A5%98-%EC%84%B8%ED%8A%B8.jpg",
            "옷1","가격1"),
            HomeNewData("https://previews.123rf.com/images/margolana/margolana1511/margolana151100248/48654416-%EA%B0%9C%EC%B2%B4-%EC%95%84%EC%9D%B4%EC%BD%98%EC%9D%98-%EA%B2%A8%EC%9A%B8-%EC%98%B7-%EA%B7%B8%EB%A3%B9%EC%9D%80-%ED%8C%A8%EC%85%98-%EC%9A%94%EC%86%8C-%EB%82%A8%EC%9E%90-%EC%9D%98%EB%A5%98-%EC%84%B8%ED%8A%B8.jpg",
            "옷2","가격2"),
            HomeNewData("https://previews.123rf.com/images/margolana/margolana1511/margolana151100248/48654416-%EA%B0%9C%EC%B2%B4-%EC%95%84%EC%9D%B4%EC%BD%98%EC%9D%98-%EA%B2%A8%EC%9A%B8-%EC%98%B7-%EA%B7%B8%EB%A3%B9%EC%9D%80-%ED%8C%A8%EC%85%98-%EC%9A%94%EC%86%8C-%EB%82%A8%EC%9E%90-%EC%9D%98%EB%A5%98-%EC%84%B8%ED%8A%B8.jpg",
            "옷3","가격3")
        )
        rv_home_new = view.findViewById(R.id.rv_home_new)
        newAdapter =
            HomeNewAdapter(new_datas)
        rv_home_new.layoutManager = LinearLayoutManager(context,LinearLayoutManager.HORIZONTAL,false)
        rv_home_new.adapter = newAdapter
        rv_home_new.addItemDecoration(HorizontalItemDecorator(24))
        newAdapter.notifyDataSetChanged()
    }

    fun makeRecentRecycler(view : View)
    {
            recent_datas = listOf(
            HomeRecentData("https://previews.123rf.com/images/margolana/margolana1511/margolana151100248/48654416-%EA%B0%9C%EC%B2%B4-%EC%95%84%EC%9D%B4%EC%BD%98%EC%9D%98-%EA%B2%A8%EC%9A%B8-%EC%98%B7-%EA%B7%B8%EB%A3%B9%EC%9D%80-%ED%8C%A8%EC%85%98-%EC%9A%94%EC%86%8C-%EB%82%A8%EC%9E%90-%EC%9D%98%EB%A5%98-%EC%84%B8%ED%8A%B8.jpg",
                "옷1","가격1"),
            HomeRecentData("https://previews.123rf.com/images/margolana/margolana1511/margolana151100248/48654416-%EA%B0%9C%EC%B2%B4-%EC%95%84%EC%9D%B4%EC%BD%98%EC%9D%98-%EA%B2%A8%EC%9A%B8-%EC%98%B7-%EA%B7%B8%EB%A3%B9%EC%9D%80-%ED%8C%A8%EC%85%98-%EC%9A%94%EC%86%8C-%EB%82%A8%EC%9E%90-%EC%9D%98%EB%A5%98-%EC%84%B8%ED%8A%B8.jpg",
                "옷2","가격2"),
            HomeRecentData("https://previews.123rf.com/images/margolana/margolana1511/margolana151100248/48654416-%EA%B0%9C%EC%B2%B4-%EC%95%84%EC%9D%B4%EC%BD%98%EC%9D%98-%EA%B2%A8%EC%9A%B8-%EC%98%B7-%EA%B7%B8%EB%A3%B9%EC%9D%80-%ED%8C%A8%EC%85%98-%EC%9A%94%EC%86%8C-%EB%82%A8%EC%9E%90-%EC%9D%98%EB%A5%98-%EC%84%B8%ED%8A%B8.jpg",
                "옷3","가격3")
        )
        rv_home_recent = view.findViewById(R.id.rv_home_recent)
        recentAdapter =
            HomeRecentAdapter(
                recent_datas
            )
        rv_home_recent.layoutManager = LinearLayoutManager(context,LinearLayoutManager.HORIZONTAL,false)
        rv_home_recent.adapter = recentAdapter
        rv_home_recent.addItemDecoration(HorizontalItemDecorator(24))
        recentAdapter.notifyDataSetChanged()
    }

    fun makeRecommendRecycler(view : View)
    {
        recommend_datas = listOf(
            HomeRecommendData("https://previews.123rf.com/images/margolana/margolana1511/margolana151100248/48654416-%EA%B0%9C%EC%B2%B4-%EC%95%84%EC%9D%B4%EC%BD%98%EC%9D%98-%EA%B2%A8%EC%9A%B8-%EC%98%B7-%EA%B7%B8%EB%A3%B9%EC%9D%80-%ED%8C%A8%EC%85%98-%EC%9A%94%EC%86%8C-%EB%82%A8%EC%9E%90-%EC%9D%98%EB%A5%98-%EC%84%B8%ED%8A%B8.jpg",
                "옷1","가격1"),
            HomeRecommendData("https://previews.123rf.com/images/margolana/margolana1511/margolana151100248/48654416-%EA%B0%9C%EC%B2%B4-%EC%95%84%EC%9D%B4%EC%BD%98%EC%9D%98-%EA%B2%A8%EC%9A%B8-%EC%98%B7-%EA%B7%B8%EB%A3%B9%EC%9D%80-%ED%8C%A8%EC%85%98-%EC%9A%94%EC%86%8C-%EB%82%A8%EC%9E%90-%EC%9D%98%EB%A5%98-%EC%84%B8%ED%8A%B8.jpg",
                "옷2","가격2"),
            HomeRecommendData("https://previews.123rf.com/images/margolana/margolana1511/margolana151100248/48654416-%EA%B0%9C%EC%B2%B4-%EC%95%84%EC%9D%B4%EC%BD%98%EC%9D%98-%EA%B2%A8%EC%9A%B8-%EC%98%B7-%EA%B7%B8%EB%A3%B9%EC%9D%80-%ED%8C%A8%EC%85%98-%EC%9A%94%EC%86%8C-%EB%82%A8%EC%9E%90-%EC%9D%98%EB%A5%98-%EC%84%B8%ED%8A%B8.jpg",
                "옷3","가격3")
        )
        rv_home_recommend = view.findViewById(R.id.rv_home_recommend)
        recommendAdapter =
            HomeRecommendAdapter(
                recommend_datas
            )
        rv_home_recommend.layoutManager = LinearLayoutManager(context,LinearLayoutManager.HORIZONTAL,false)
        rv_home_recommend.adapter = recommendAdapter
        rv_home_recommend.addItemDecoration(HorizontalItemDecorator(24))
        recommendAdapter.notifyDataSetChanged()
    }

    fun makePlubRecycler(view : View)
    {
        plub_datas = listOf(
            HomePlubData("https://previews.123rf.com/images/margolana/margolana1511/margolana151100248/48654416-%EA%B0%9C%EC%B2%B4-%EC%95%84%EC%9D%B4%EC%BD%98%EC%9D%98-%EA%B2%A8%EC%9A%B8-%EC%98%B7-%EA%B7%B8%EB%A3%B9%EC%9D%80-%ED%8C%A8%EC%85%98-%EC%9A%94%EC%86%8C-%EB%82%A8%EC%9E%90-%EC%9D%98%EB%A5%98-%EC%84%B8%ED%8A%B8.jpg",
                "셀러1","해쉬테그1","해쉬테그2","팔로우"),
            HomePlubData("https://previews.123rf.com/images/margolana/margolana1511/margolana151100248/48654416-%EA%B0%9C%EC%B2%B4-%EC%95%84%EC%9D%B4%EC%BD%98%EC%9D%98-%EA%B2%A8%EC%9A%B8-%EC%98%B7-%EA%B7%B8%EB%A3%B9%EC%9D%80-%ED%8C%A8%EC%85%98-%EC%9A%94%EC%86%8C-%EB%82%A8%EC%9E%90-%EC%9D%98%EB%A5%98-%EC%84%B8%ED%8A%B8.jpg",
                "셀러2","해쉬테그1","해쉬테그2","팔로우"),
            HomePlubData("https://previews.123rf.com/images/margolana/margolana1511/margolana151100248/48654416-%EA%B0%9C%EC%B2%B4-%EC%95%84%EC%9D%B4%EC%BD%98%EC%9D%98-%EA%B2%A8%EC%9A%B8-%EC%98%B7-%EA%B7%B8%EB%A3%B9%EC%9D%80-%ED%8C%A8%EC%85%98-%EC%9A%94%EC%86%8C-%EB%82%A8%EC%9E%90-%EC%9D%98%EB%A5%98-%EC%84%B8%ED%8A%B8.jpg",
                "셀러3","해쉬테그1","해쉬테그2","팔로우")
        )
        rv_home_plub = view.findViewById(R.id.rv_home_plub)
        plubAdapter = HomePlubAdapter(plub_datas)
        rv_home_plub.layoutManager = LinearLayoutManager(context,LinearLayoutManager.HORIZONTAL,false)
        rv_home_plub.adapter = plubAdapter
        rv_home_plub.addItemDecoration(HorizontalItemDecorator(24))
        plubAdapter.notifyDataSetChanged()
    }

    fun makeKeywordRecycler(view : View)
    {
        keyword_datas = listOf(
            HomeKeywordData("#스카프",R.drawable.img_keyword),
            HomeKeywordData("#데님",R.drawable.img_keyword),
            HomeKeywordData("#중절모",R.drawable.img_keyword)


        )
        rv_home_keyword = view.findViewById(R.id.rv_home_keyword)
        keywordAdapter = HomeKeywordAdapter(keyword_datas)
        rv_home_keyword.layoutManager = LinearLayoutManager(context,LinearLayoutManager.VERTICAL,false)
        rv_home_keyword.adapter = keywordAdapter
        keywordAdapter.notifyDataSetChanged()
    }

    fun makeOctionRecycler(view: View)
    {
        auction_data = listOf(
            HomeAuctionData("https://previews.123rf.com/images/margolana/margolana1511/margolana151100248/48654416-%EA%B0%9C%EC%B2%B4-%EC%95%84%EC%9D%B4%EC%BD%98%EC%9D%98-%EA%B2%A8%EC%9A%B8-%EC%98%B7-%EA%B7%B8%EB%A3%B9%EC%9D%80-%ED%8C%A8%EC%85%98-%EC%9A%94%EC%86%8C-%EB%82%A8%EC%9E%90-%EC%9D%98%EB%A5%98-%EC%84%B8%ED%8A%B8.jpg",
            "곧 경매 종료","원피스"),
            HomeAuctionData("https://previews.123rf.com/images/margolana/margolana1511/margolana151100248/48654416-%EA%B0%9C%EC%B2%B4-%EC%95%84%EC%9D%B4%EC%BD%98%EC%9D%98-%EA%B2%A8%EC%9A%B8-%EC%98%B7-%EA%B7%B8%EB%A3%B9%EC%9D%80-%ED%8C%A8%EC%85%98-%EC%9A%94%EC%86%8C-%EB%82%A8%EC%9E%90-%EC%9D%98%EB%A5%98-%EC%84%B8%ED%8A%B8.jpg",
                "종료까지 2시간","코트"),
            HomeAuctionData("https://previews.123rf.com/images/margolana/margolana1511/margolana151100248/48654416-%EA%B0%9C%EC%B2%B4-%EC%95%84%EC%9D%B4%EC%BD%98%EC%9D%98-%EA%B2%A8%EC%9A%B8-%EC%98%B7-%EA%B7%B8%EB%A3%B9%EC%9D%80-%ED%8C%A8%EC%85%98-%EC%9A%94%EC%86%8C-%EB%82%A8%EC%9E%90-%EC%9D%98%EB%A5%98-%EC%84%B8%ED%8A%B8.jpg",
                "종료까지 4시간 ","자켓")
        )
        rv_home_auction = view.findViewById(R.id.rv_home_auction)
        auctionAdapter = HomeAuctionAdapter(auction_data)
        rv_home_auction.layoutManager = LinearLayoutManager(context,LinearLayoutManager.HORIZONTAL,false)
        rv_home_auction.adapter = auctionAdapter
        auctionAdapter.notifyDataSetChanged()
    }

}
