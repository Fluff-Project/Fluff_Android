package kr.market.fluff.ui.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kr.market.fluff.R
import kr.market.fluff.data.*
import kr.market.fluff.ui.fragment.Home.HomeRecycler.RecyclerCommon.HomeNewAdapter
import kr.market.fluff.ui.fragment.Home.HomeRecycler.RecyclerCommon.HomeRecentAdapter
import kr.market.fluff.ui.fragment.Home.HomeRecycler.RecyclerCommon.HomeRecommendAdapter
import kr.market.fluff.ui.fragment.Home.HomeRecycler.RecyclerKeyword.HomeKeywordAdapter
import kr.market.fluff.ui.fragment.Home.HomeRecycler.RecyclerOction.HomeOctionAdapter
import kr.market.fluff.ui.fragment.Home.HomeRecycler.RecyclerPlub.HomePlubAdapter

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

    lateinit var rv_home_oction : RecyclerView
    lateinit var octionAdapter: HomeOctionAdapter
    lateinit var oction_datas : List<HomeOctionData>

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_home, container, false)
        makeNewRecycler(view)
        makeRecentRecycler(view)
        makeRecommendRecycler(view)
        makePlubRecycler(view)
        makeKeywordRecycler(view)
        makeOctionRecycler(view)

        // Inflate the layout for this fragment
        return view
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
        recommendAdapter.notifyDataSetChanged()
    }

    fun makePlubRecycler(view : View)
    {
        plub_datas = listOf(
            HomePlubData("https://previews.123rf.com/images/margolana/margolana1511/margolana151100248/48654416-%EA%B0%9C%EC%B2%B4-%EC%95%84%EC%9D%B4%EC%BD%98%EC%9D%98-%EA%B2%A8%EC%9A%B8-%EC%98%B7-%EA%B7%B8%EB%A3%B9%EC%9D%80-%ED%8C%A8%EC%85%98-%EC%9A%94%EC%86%8C-%EB%82%A8%EC%9E%90-%EC%9D%98%EB%A5%98-%EC%84%B8%ED%8A%B8.jpg",
                "셀러1","해쉬테그1","팔로우"),
            HomePlubData("https://previews.123rf.com/images/margolana/margolana1511/margolana151100248/48654416-%EA%B0%9C%EC%B2%B4-%EC%95%84%EC%9D%B4%EC%BD%98%EC%9D%98-%EA%B2%A8%EC%9A%B8-%EC%98%B7-%EA%B7%B8%EB%A3%B9%EC%9D%80-%ED%8C%A8%EC%85%98-%EC%9A%94%EC%86%8C-%EB%82%A8%EC%9E%90-%EC%9D%98%EB%A5%98-%EC%84%B8%ED%8A%B8.jpg",
                "셀러2","해쉬테그2","팔로우"),
            HomePlubData("https://previews.123rf.com/images/margolana/margolana1511/margolana151100248/48654416-%EA%B0%9C%EC%B2%B4-%EC%95%84%EC%9D%B4%EC%BD%98%EC%9D%98-%EA%B2%A8%EC%9A%B8-%EC%98%B7-%EA%B7%B8%EB%A3%B9%EC%9D%80-%ED%8C%A8%EC%85%98-%EC%9A%94%EC%86%8C-%EB%82%A8%EC%9E%90-%EC%9D%98%EB%A5%98-%EC%84%B8%ED%8A%B8.jpg",
                "셀러3","해쉬테그3","팔로우")
        )
        rv_home_plub = view.findViewById(R.id.rv_home_plub)
        plubAdapter = HomePlubAdapter(plub_datas)
        rv_home_plub.layoutManager = LinearLayoutManager(context,LinearLayoutManager.HORIZONTAL,false)
        rv_home_plub.adapter = plubAdapter
        plubAdapter.notifyDataSetChanged()
    }

    fun makeKeywordRecycler(view : View)
    {
        keyword_datas = listOf(
            HomeKeywordData("#스카프","http://www.mediasr.co.kr/news/photo/201710/37992_4621_0311.png"),
            HomeKeywordData("#데님","http://www.mediasr.co.kr/news/photo/201710/37992_4621_0311.png"),
            HomeKeywordData("#중절모","http://www.mediasr.co.kr/news/photo/201710/37992_4621_0311.png")


        )
        rv_home_keyword = view.findViewById(R.id.rv_home_keyword)
        keywordAdapter = HomeKeywordAdapter(keyword_datas)
        rv_home_keyword.layoutManager = LinearLayoutManager(context,LinearLayoutManager.VERTICAL,false)
        rv_home_keyword.adapter = keywordAdapter
        keywordAdapter.notifyDataSetChanged()
    }

    fun makeOctionRecycler(view: View)
    {
        oction_datas = listOf(
            HomeOctionData("https://previews.123rf.com/images/margolana/margolana1511/margolana151100248/48654416-%EA%B0%9C%EC%B2%B4-%EC%95%84%EC%9D%B4%EC%BD%98%EC%9D%98-%EA%B2%A8%EC%9A%B8-%EC%98%B7-%EA%B7%B8%EB%A3%B9%EC%9D%80-%ED%8C%A8%EC%85%98-%EC%9A%94%EC%86%8C-%EB%82%A8%EC%9E%90-%EC%9D%98%EB%A5%98-%EC%84%B8%ED%8A%B8.jpg",
            "곧 경매 종료","원피스"),
            HomeOctionData("https://previews.123rf.com/images/margolana/margolana1511/margolana151100248/48654416-%EA%B0%9C%EC%B2%B4-%EC%95%84%EC%9D%B4%EC%BD%98%EC%9D%98-%EA%B2%A8%EC%9A%B8-%EC%98%B7-%EA%B7%B8%EB%A3%B9%EC%9D%80-%ED%8C%A8%EC%85%98-%EC%9A%94%EC%86%8C-%EB%82%A8%EC%9E%90-%EC%9D%98%EB%A5%98-%EC%84%B8%ED%8A%B8.jpg",
                "종료까지 2시간","코트"),
            HomeOctionData("https://previews.123rf.com/images/margolana/margolana1511/margolana151100248/48654416-%EA%B0%9C%EC%B2%B4-%EC%95%84%EC%9D%B4%EC%BD%98%EC%9D%98-%EA%B2%A8%EC%9A%B8-%EC%98%B7-%EA%B7%B8%EB%A3%B9%EC%9D%80-%ED%8C%A8%EC%85%98-%EC%9A%94%EC%86%8C-%EB%82%A8%EC%9E%90-%EC%9D%98%EB%A5%98-%EC%84%B8%ED%8A%B8.jpg",
                "종료까지 4시간 ","자켓")
        )
        rv_home_oction = view.findViewById(R.id.rv_home_oction)
        octionAdapter = HomeOctionAdapter(oction_datas)
        rv_home_oction.layoutManager = LinearLayoutManager(context,LinearLayoutManager.HORIZONTAL,false)
        rv_home_oction.adapter = octionAdapter
        octionAdapter.notifyDataSetChanged()
    }

}
