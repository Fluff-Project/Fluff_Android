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
import kr.market.fluff.data.home.*
import kr.market.fluff.ui.MainActivity
import kr.market.fluff.ui.fragment.home.home_detail.HomeNewActivity
import kr.market.fluff.ui.fragment.home.home_detail.HomeRecentActivity
import kr.market.fluff.ui.fragment.home.home_detail.HomeRecommendActivity
import kr.market.fluff.ui.fragment.home.recycler_auction.HomeAuctionAdapter
import kr.market.fluff.ui.fragment.home.recycler_common.HomeNewAdapter
import kr.market.fluff.ui.fragment.home.recycler_common.HomeRecentAdapter
import kr.market.fluff.ui.fragment.home.recycler_common.HomeRecommendAdapter
import kr.market.fluff.ui.fragment.home.recycler_keyword.HomeKeywordAdapter
import kr.market.fluff.ui.fragment.home.recycler_plub.HomePlubAdapter
import kr.market.fluff.ui.fragment.home.viewpager.ViewPagerAdapter
import kr.market.fluff.ui.recommendStyle.RecommendStyleActivity
import kr.market.fluff.ui.util.item_decorator.HorizontalItemDecorator
import kr.market.fluff.ui.util.item_decorator.VerticalItemDecorator

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

    /*lateinit var rv_home_keyword : RecyclerView
    lateinit var keywordAdapter: HomeKeywordAdapter
    lateinit var keyword_datas : List<HomeKeywordData>*/
    lateinit var rv_home_auction : RecyclerView
    lateinit var auctionAdapter: HomeAuctionAdapter
    lateinit var auction_data : List<HomeAuctionData>

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

        makeNewRecycler(view)
        makeRecentRecycler(view)
        makeRecommendRecycler(view)
        makePlubRecycler(view)
        makeOctionRecycler(view)
        makeHomeViewPager(view)
        changeView()
        // makeKeywordRecycler(view)


    }

    fun changeView()
    {
        img_home_newicon.setOnClickListener {
            val intent = Intent(context, HomeNewActivity::class.java)
            intent.putExtra("new_keyword",tv_home_new_keyword.text.toString())
            startActivity(intent)
        }
        img_home_auctionicon.setOnClickListener {(activity as MainActivity).replaceFragment(2)}

        img_home_plubicon.setOnClickListener {
            val intent = Intent(context, RecommendStyleActivity::class.java)
            startActivity(intent)
        }

        img_home_recenticon.setOnClickListener {
            val intent = Intent(context, HomeRecentActivity::class.java)
            intent.putExtra("recent_keyword",tv_home_recent_keyword.text.toString())
            startActivity(intent)
        }
        img_home_recommendicon.setOnClickListener {
            val intent = Intent(context, HomeRecommendActivity::class.java)
            intent.putExtra("recommend_keyword",tv_home_recommend_keyword.text.toString())
            startActivity(intent)
        }
    }


    fun makeHomeViewPager(view : View)
    {
        val dotsIndicator= view.findViewById<DotsIndicator>(kr.market.fluff.R.id.dots_indicator)
        val viewPager = view.findViewById<ViewPager>(kr.market.fluff.R.id.vp_home_viewpager)
        val adapter = ViewPagerAdapter(childFragmentManager,5)
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
        rv_home_new = view.findViewById(kr.market.fluff.R.id.rv_home_new)
        newAdapter =
            HomeNewAdapter(new_datas)
        rv_home_new.apply {
            layoutManager = LinearLayoutManager(context,LinearLayoutManager.HORIZONTAL,false)
            adapter = newAdapter
            addItemDecoration(HorizontalItemDecorator(24))
        }
//        val snapHelper = LinearSnapHelper()
//        snapHelper.attachToRecyclerView(rv_home_new)
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
        rv_home_recent = view.findViewById(kr.market.fluff.R.id.rv_home_recent)
        recentAdapter =
            HomeRecentAdapter(
                recent_datas
            )
        rv_home_recent.apply {
            layoutManager = LinearLayoutManager(context,LinearLayoutManager.HORIZONTAL,false)
            adapter = recentAdapter
            addItemDecoration(HorizontalItemDecorator(24))
        }
//        val snapHelper = LinearSnapHelper()
//        snapHelper.attachToRecyclerView(rv_home_recent)
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
        recommendAdapter = HomeRecommendAdapter(recommend_datas)
        rv_home_recommend.apply {
            layoutManager = LinearLayoutManager(context,LinearLayoutManager.HORIZONTAL,false)
            adapter = recommendAdapter
            addItemDecoration(HorizontalItemDecorator(24))
        }
//        val snapHelper = LinearSnapHelper()
//        snapHelper.attachToRecyclerView(rv_home_recommend)
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
        rv_home_plub = view.findViewById(kr.market.fluff.R.id.rv_home_plub)
        plubAdapter = HomePlubAdapter(plub_datas)
        rv_home_plub.apply {
            layoutManager = LinearLayoutManager(context,LinearLayoutManager.HORIZONTAL,false)
            adapter = plubAdapter
            addItemDecoration(HorizontalItemDecorator(24))
        }
//        val snapHelper = LinearSnapHelper()
//        snapHelper.attachToRecyclerView(rv_home_plub)
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
        rv_home_auction.apply {
            layoutManager = LinearLayoutManager(context,LinearLayoutManager.HORIZONTAL,false)
            adapter = auctionAdapter
            addItemDecoration(HorizontalItemDecorator(24))
        }
//        val snapHelper = LinearSnapHelper()
//        snapHelper.attachToRecyclerView(rv_home_auction)
    }

}
