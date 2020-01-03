package kr.market.fluff.ui.fragment.magazine

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.viewpager.widget.ViewPager
import kr.market.fluff.R
import kr.market.fluff.data.MagazineData
import kr.market.fluff.network.RequestToServer
import kr.market.fluff.network.safeEnqueue
import kr.market.fluff.data.App
import kr.market.fluff.ui.util.sendToast
import java.lang.Exception


class MagazineFragment : Fragment() {

    lateinit var adapter : MagazinePagerAdapter
    lateinit var vp_magazine : ViewPager
    var magazine_datas = ArrayList<MagazineData>()
    var requestToServer : RequestToServer = RequestToServer
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_magazine, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        vp_magazine = view.findViewById(R.id.vp_magazine)
        adapter = MagazinePagerAdapter(this.activity!!,view.context)


        Log.d("hj","토큰값 : ${App.prefs.local_login_token}")
        requestToServer.service.request_magazine(
            "application/json",
            App.prefs.local_login_token!!).
            safeEnqueue(
            onSuccess = {
                val img_datas = it
                magazine_datas.add(MagazineData(
                    img_magazine = img_datas.get(0).imgUrl,
                    txt_magazine_title = "광장시장 구제상가에서 가을 옷 득템하기",
                    txt_detail_magazine_contents_title = "구제 옷의 매력이라면 뭐니 뭐니 해도 득템하는 재미다.\n" +
                            "앗, 이것은 내가 찾다 포기한 무늬의 스커트!\n" +
                            "“사장님, 이 스커트 얼마예요?” “만원.”\n" +
                            "“블라우스는?” “같이 하면 만 오천원.”\n" +
                            "저렴하게 가을 옷 득템하고 빈대떡까지 사 먹을 수 있는\n" +
                            "광장시장 구제상가에 들렀다.\n" +
                            "망설이다 내려놓은 원피스가 아른거려 내일 또 가야 할 것 같은 그곳….\n" ,
                    txt_magazine_date = "2019.12.17",
                    txt_detail_magazine_contents = "01 말 한마디에 빈대떡 값이 생긴다\n" +
                            "현금을 챙길 것. 정찰제가 아니므로 당연히 흥정이 가능하다. (원빈도 아닌데) “얼마면 되겠냐”는 질문을 많이 하므로, 어느 정도 시세를 파악하고 가거나 나만의 기준을 정해두고(겨울코트는 4만원을 넘기지 않겠다!) 가는 것이 좋다.\n" +
                            " \n" +
                            "“저 구제시장 자주 와요, 또 올게요” “멀리서 왔어요, 차비만 빼주세요” 하는 기본 멘트만해도 가격이 내려가니 도전!\n" +
                            " \n" +
                            "02 필요한 아이템 미리 생각해두기\n" +
                            "품목이 워낙 다양하므로, 득템하고 싶은 아이템을 미리 생각해 놓고 가자. 원하는 것이 있는지 빨리 파악하고 다음 가게로 넘어갈 수 있다. 가게마다 스타일과 콘셉트가 다르므로, 취향에 맞는 곳은 호수를 기억해두었다가 다시 찾으면 편하다.\n" +
                            " \n" +
                            "03 매의 눈으로 보물 찾아내기\n" +
                            "옷들이 다닥다닥 겹쳐서 걸려 있으므로 그 속에서 원하는 스타일을 찾아내려면 매의 눈은 필수다. 패턴이 특이한 원피스, 희소성 있는 해외 빈티지, 거의 새 제품에 가까운 것들도 있으니 보물찾기 하듯 뒤져보자.\n" +
                            " \n" +
                            "04 옷 상태 꼼꼼히 확인하기\n" +
                            "구제 의류는 사용감이 있어 얼룩이나 올 풀림 등의 손상이 있을 수 있다. 사기 전에 잘 확인하자. 상가 조명이 어두운 편이므로 요리조리 들춰 보며 확인하는 것은 필수. 세탁하면 없어지는 얼룩도 많으니 지워지는 얼룩인지, 어떻게 지우는지 미리 물어볼 것.\n" +
                            " \n" +
                            "05 초심자라면 친구와 함께 가자\n" +
                            "둘이면 아무래도 구경하기도, 흥정하기도 편하다. 여자 옷만큼 남자 옷도 많고, 상태 좋은 해외 브랜드 옷도 온라인 중고가보다 저렴하게 구매할 수 있으니 참고. 호객 행위도 심하지 않은 편이다. 맛있는 것도 먹고 쇼핑도 하며 한나절 놀기 좋은 코스!\n" +
                            "위치 \n" +
                            "광장시장 2층 / 종로 방향에서 온다면, 종로4가 사거리에서 광장시장 서문 바로 옆에 있는 계단을 오르면 된다. (전광판에 ‘폭탄세일’이 번쩍번쩍거려 찾기 쉽다.) 시장 안에선 만남의 광장 근처에 ‘수입구제 입구’ 팻말이 군데군데 붙어 있으니 참고.\n" +
                            " \n" +
                            "시간 \n" +
                            "월~토 10:00-19:00, 일 11:00-19:00 / 점심시간 직후인 1시부터가 사람이 많지도 적지도 않아 쇼핑하기 딱 좋다. 5시 이후론 하나둘 문 닫는 분위기이므로 그 전에 가는 것이 좋다.\n",
                    img_detail_magazine_contents = "https://img1.daumcdn.net/thumb/R1280x0/?scode=mtistory2&fname=https%3A%2F%2Fk.kakaocdn.net%2Fdn%2FRZZXj%2FbtqAQlJqztz%2FTe1Zd0IwyRvnSXP6Wk9KC1%2Fimg.png",
                    txt_detail_magazine_contents_product_title = "가을에 어울리는 빈티지 룩을 득템할 수 있는 매장",
                    txt_detail_magazine_product_contents = "광장시장 구제상가에는 평소 빈티지, 레트로 스타일을 좋아하는 사람이라면 눈에 쏙쏙 들어올 만한 상품들이 제법 있다. 패턴 있는 원피스나 복고풍 블라우스, 다양한 디자인과 재질의 스커트를 비롯해 청재킷, 야상, 코트 등의 가을·겨울 아우터도 저렴한 가격에 득템할 수 있다. "))



                magazine_datas.add(
                    MagazineData(
                    img_magazine = img_datas.get(1).imgUrl,
                    txt_magazine_title = "광장시장 구제상가에서\n 가을 옷 득템하기",
                    txt_detail_magazine_contents_title = "구제 옷의 매력이라면 \n뭐니 뭐니 해도 득템하는 재미다.\n" +
                            "앗, 이것은 내가 찾다 포기한 무늬의 스커트!\n" +
                            "“사장님, 이 스커트 얼마예요?”\n “만원.”\n" +
                            "“블라우스는?”\n “같이 하면 만 오천원.”\n" +
                            "저렴하게 가을 옷 득템하고 \n빈대떡까지 사 먹을 수 있는\n" +
                            "광장시장 구제상가에 들렀다.\n" +
                            "망설이다 내려놓은 원피스가 아른거려 \n내일 또 가야 할 것 같은 그곳….\n" ,
                    txt_magazine_date = "2019.12.17",
                    txt_detail_magazine_contents = "01 말 한마디에 빈대떡 값이 생긴다\n" +
                            "현금을 챙길 것. \n정찰제가 아니므로 당연히 흥정이 가능하다. \n(원빈도 아닌데) \n\n“얼마면 되겠냐”는 질문을 많이 하므로, \n어느 정도 시세를 파악하고 가거나 \n나만의 기준을 정해두고\n 가는 것이 좋다.\n(겨울코트는 4만원을 넘기지 않겠다!)\n" +
                            " \n" +
                            "“저 구제시장 자주 와요, 또 올게요”\n “멀리서 왔어요, 차비만 빼주세요”\n 하는 기본 멘트만해도 가격이 내려가니 도전!\n" +
                            " \n" +
                            "02 필요한 아이템 미리 생각해두기\n" +
                            "품목이 워낙 다양하므로,\n 득템하고 싶은 아이템을 미리 생각해 놓고 가자.\n 원하는 것이 있는지 빨리 파악하고 \n다음 가게로 넘어갈 수 있다. \n가게마다 스타일과 콘셉트가 다르므로, \n취향에 맞는 곳은 호수를 기억해두었다가 \n다시 찾으면 편하다.\n" +
                            " \n" +
                            "03 매의 눈으로 보물 찾아내기\n" +
                            "옷들이 다닥다닥 겹쳐서 걸려 있으므로 \n그 속에서 원하는 스타일을 찾아내려면 \n매의 눈은 필수다. \n\n패턴이 특이한 원피스, \n희소성 있는 해외 빈티지, \n거의 새 제품에 가까운 것들도 있으니\n 보물찾기 하듯 뒤져보자.\n" +
                            " \n" +
                            "04 옷 상태 꼼꼼히 확인하기\n" +
                            "구제 의류는 사용감이 있어 \n얼룩이나 올 풀림 등의 손상이 있을 수 있다. \n사기 전에 잘 확인하자. \n상가 조명이 어두운 편이므로 \n요리조리 들춰 보며 확인하는 것은 필수.\n 세탁하면 없어지는 얼룩도 많으니 \n지워지는 얼룩인지, 어떻게 지우는지 미리 물어볼 것.\n" +
                            " \n" +
                            "05 초심자라면 친구와 함께 가자\n" +
                            "둘이면 아무래도 구경하기도, 흥정하기도 편하다.\n 여자 옷만큼 남자 옷도 많고, \n상태 좋은 해외 브랜드 옷도 \n온라인 중고가보다 저렴하게 구매할 수 있으니 참고. \n호객 행위도 심하지 않은 편이다.\n 맛있는 것도 먹고 쇼핑도 하며 \n한나절 놀기 좋은 코스!\n" +
                            "위치 \n" +
                            "광장시장 2층 /\n 종로 방향에서 온다면,\n 종로4가 사거리에서 광장시장 서문 바로 옆에 있는 계단을 오르면 된다. \n(전광판에 ‘폭탄세일’이 번쩍번쩍거려 찾기 쉽다.)\n\n 시장 안에선 만남의 광장 근처에 \n‘수입구제 입구’ 팻말이 군데군데 붙어 있으니 참고.\n" +
                            " \n" +
                            "시간 \n" +
                            "월~토 10:00-19:00, \n일 11:00-19:00 \n/ 점심시간 직후인 1시부터가 사람이 많지도 적지도 않아 쇼핑하기 딱 좋다. \n5시 이후론 하나둘 문 닫는 분위기이므로 \n그 전에 가는 것이 좋다.\n",
                    img_detail_magazine_contents = "https://img1.daumcdn.net/thumb/R1280x0/?scode=mtistory2&fname=https%3A%2F%2Fk.kakaocdn.net%2Fdn%2FRZZXj%2FbtqAQlJqztz%2FTe1Zd0IwyRvnSXP6Wk9KC1%2Fimg.png",
                    txt_detail_magazine_contents_product_title = "가을에 어울리는 빈티지 룩을 득템할 수 있는 매장",
                    txt_detail_magazine_product_contents = "광장시장 구제상가에는 평소 빈티지, 레트로 스타일을 좋아하는 사람이라면 눈에 쏙쏙 들어올 만한 상품들이 제법 있다.\n\n 패턴 있는 원피스나 복고풍 블라우스, 다양한 디자인과 재질의 스커트를 비롯해 청재킷, 야상, 코트 등의 가을·겨울 아우터도 저렴한 가격에 득템할 수 있다. "))




                magazine_datas.add(MagazineData(
                    img_magazine = img_datas.get(2).imgUrl,
                    txt_magazine_title = "광장시장 구제상가에서 가을 옷 득템하기",
                    txt_detail_magazine_contents_title = "구제 옷의 매력이라면 뭐니 뭐니 해도 득템하는 재미다.\n" +
                            "앗, 이것은 내가 찾다 포기한 무늬의 스커트!\n" +
                            "“사장님, 이 스커트 얼마예요?” “만원.”\n" +
                            "“블라우스는?” “같이 하면 만 오천원.”\n" +
                            "저렴하게 가을 옷 득템하고 빈대떡까지 사 먹을 수 있는\n" +
                            "광장시장 구제상가에 들렀다.\n" +
                            "망설이다 내려놓은 원피스가 아른거려 내일 또 가야 할 것 같은 그곳….\n" ,
                    txt_magazine_date = "2019.12.17",
                    txt_detail_magazine_contents = "01 말 한마디에 빈대떡 값이 생긴다\n" +
                            "현금을 챙길 것. 정찰제가 아니므로 당연히 흥정이 가능하다. (원빈도 아닌데) “얼마면 되겠냐”는 질문을 많이 하므로, 어느 정도 시세를 파악하고 가거나 나만의 기준을 정해두고(겨울코트는 4만원을 넘기지 않겠다!) 가는 것이 좋다.\n" +
                            " \n" +
                            "“저 구제시장 자주 와요, 또 올게요” “멀리서 왔어요, 차비만 빼주세요” 하는 기본 멘트만해도 가격이 내려가니 도전!\n" +
                            " \n" +
                            "02 필요한 아이템 미리 생각해두기\n" +
                            "품목이 워낙 다양하므로, 득템하고 싶은 아이템을 미리 생각해 놓고 가자. 원하는 것이 있는지 빨리 파악하고 다음 가게로 넘어갈 수 있다. 가게마다 스타일과 콘셉트가 다르므로, 취향에 맞는 곳은 호수를 기억해두었다가 다시 찾으면 편하다.\n" +
                            " \n" +
                            "03 매의 눈으로 보물 찾아내기\n" +
                            "옷들이 다닥다닥 겹쳐서 걸려 있으므로 그 속에서 원하는 스타일을 찾아내려면 매의 눈은 필수다. 패턴이 특이한 원피스, 희소성 있는 해외 빈티지, 거의 새 제품에 가까운 것들도 있으니 보물찾기 하듯 뒤져보자.\n" +
                            " \n" +
                            "04 옷 상태 꼼꼼히 확인하기\n" +
                            "구제 의류는 사용감이 있어 얼룩이나 올 풀림 등의 손상이 있을 수 있다. 사기 전에 잘 확인하자. 상가 조명이 어두운 편이므로 요리조리 들춰 보며 확인하는 것은 필수. 세탁하면 없어지는 얼룩도 많으니 지워지는 얼룩인지, 어떻게 지우는지 미리 물어볼 것.\n" +
                            " \n" +
                            "05 초심자라면 친구와 함께 가자\n" +
                            "둘이면 아무래도 구경하기도, 흥정하기도 편하다. 여자 옷만큼 남자 옷도 많고, 상태 좋은 해외 브랜드 옷도 온라인 중고가보다 저렴하게 구매할 수 있으니 참고. 호객 행위도 심하지 않은 편이다. 맛있는 것도 먹고 쇼핑도 하며 한나절 놀기 좋은 코스!\n" +
                            "위치 \n" +
                            "광장시장 2층 / 종로 방향에서 온다면, 종로4가 사거리에서 광장시장 서문 바로 옆에 있는 계단을 오르면 된다. (전광판에 ‘폭탄세일’이 번쩍번쩍거려 찾기 쉽다.) 시장 안에선 만남의 광장 근처에 ‘수입구제 입구’ 팻말이 군데군데 붙어 있으니 참고.\n" +
                            " \n" +
                            "시간 \n" +
                            "월~토 10:00-19:00, 일 11:00-19:00 / 점심시간 직후인 1시부터가 사람이 많지도 적지도 않아 쇼핑하기 딱 좋다. 5시 이후론 하나둘 문 닫는 분위기이므로 그 전에 가는 것이 좋다.\n",
                    img_detail_magazine_contents = "https://img1.daumcdn.net/thumb/R1280x0/?scode=mtistory2&fname=https%3A%2F%2Fk.kakaocdn.net%2Fdn%2FRZZXj%2FbtqAQlJqztz%2FTe1Zd0IwyRvnSXP6Wk9KC1%2Fimg.png",
                    txt_detail_magazine_contents_product_title = "가을에 어울리는 빈티지 룩을 득템할 수 있는 매장",
                    txt_detail_magazine_product_contents = "광장시장 구제상가에는 평소 빈티지, 레트로 스타일을 좋아하는 사람이라면 눈에 쏙쏙 들어올 만한 상품들이 제법 있다. 패턴 있는 원피스나 복고풍 블라우스, 다양한 디자인과 재질의 스커트를 비롯해 청재킷, 야상, 코트 등의 가을·겨울 아우터도 저렴한 가격에 득템할 수 있다. "))





                magazine_datas.add(MagazineData(
                    img_magazine = img_datas.get(3).imgUrl,
                    txt_magazine_title = "광장시장 구제상가에서 가을 옷 득템하기",
                    txt_detail_magazine_contents_title = "구제 옷의 매력이라면 뭐니 뭐니 해도 득템하는 재미다.\n" +
                            "앗, 이것은 내가 찾다 포기한 무늬의 스커트!\n" +
                            "“사장님, 이 스커트 얼마예요?” “만원.”\n" +
                            "“블라우스는?” “같이 하면 만 오천원.”\n" +
                            "저렴하게 가을 옷 득템하고 빈대떡까지 사 먹을 수 있는\n" +
                            "광장시장 구제상가에 들렀다.\n" +
                            "망설이다 내려놓은 원피스가 아른거려 내일 또 가야 할 것 같은 그곳….\n" ,
                    txt_magazine_date = "2019.12.17",
                    txt_detail_magazine_contents = "01 말 한마디에 빈대떡 값이 생긴다\n" +
                            "현금을 챙길 것. 정찰제가 아니므로 당연히 흥정이 가능하다. (원빈도 아닌데) “얼마면 되겠냐”는 질문을 많이 하므로, 어느 정도 시세를 파악하고 가거나 나만의 기준을 정해두고(겨울코트는 4만원을 넘기지 않겠다!) 가는 것이 좋다.\n" +
                            " \n" +
                            "“저 구제시장 자주 와요, 또 올게요” “멀리서 왔어요, 차비만 빼주세요” 하는 기본 멘트만해도 가격이 내려가니 도전!\n" +
                            " \n" +
                            "02 필요한 아이템 미리 생각해두기\n" +
                            "품목이 워낙 다양하므로, 득템하고 싶은 아이템을 미리 생각해 놓고 가자. 원하는 것이 있는지 빨리 파악하고 다음 가게로 넘어갈 수 있다. 가게마다 스타일과 콘셉트가 다르므로, 취향에 맞는 곳은 호수를 기억해두었다가 다시 찾으면 편하다.\n" +
                            " \n" +
                            "03 매의 눈으로 보물 찾아내기\n" +
                            "옷들이 다닥다닥 겹쳐서 걸려 있으므로 그 속에서 원하는 스타일을 찾아내려면 매의 눈은 필수다. 패턴이 특이한 원피스, 희소성 있는 해외 빈티지, 거의 새 제품에 가까운 것들도 있으니 보물찾기 하듯 뒤져보자.\n" +
                            " \n" +
                            "04 옷 상태 꼼꼼히 확인하기\n" +
                            "구제 의류는 사용감이 있어 얼룩이나 올 풀림 등의 손상이 있을 수 있다. 사기 전에 잘 확인하자. 상가 조명이 어두운 편이므로 요리조리 들춰 보며 확인하는 것은 필수. 세탁하면 없어지는 얼룩도 많으니 지워지는 얼룩인지, 어떻게 지우는지 미리 물어볼 것.\n" +
                            " \n" +
                            "05 초심자라면 친구와 함께 가자\n" +
                            "둘이면 아무래도 구경하기도, 흥정하기도 편하다. 여자 옷만큼 남자 옷도 많고, 상태 좋은 해외 브랜드 옷도 온라인 중고가보다 저렴하게 구매할 수 있으니 참고. 호객 행위도 심하지 않은 편이다. 맛있는 것도 먹고 쇼핑도 하며 한나절 놀기 좋은 코스!\n" +
                            "위치 \n" +
                            "광장시장 2층 / 종로 방향에서 온다면, 종로4가 사거리에서 광장시장 서문 바로 옆에 있는 계단을 오르면 된다. (전광판에 ‘폭탄세일’이 번쩍번쩍거려 찾기 쉽다.) 시장 안에선 만남의 광장 근처에 ‘수입구제 입구’ 팻말이 군데군데 붙어 있으니 참고.\n" +
                            " \n" +
                            "시간 \n" +
                            "월~토 10:00-19:00, 일 11:00-19:00 / 점심시간 직후인 1시부터가 사람이 많지도 적지도 않아 쇼핑하기 딱 좋다. 5시 이후론 하나둘 문 닫는 분위기이므로 그 전에 가는 것이 좋다.\n",
                    img_detail_magazine_contents = "https://img1.daumcdn.net/thumb/R1280x0/?scode=mtistory2&fname=https%3A%2F%2Fk.kakaocdn.net%2Fdn%2FRZZXj%2FbtqAQlJqztz%2FTe1Zd0IwyRvnSXP6Wk9KC1%2Fimg.png",
                    txt_detail_magazine_contents_product_title = "가을에 어울리는 빈티지 룩을 득템할 수 있는 매장",
                    txt_detail_magazine_product_contents = "광장시장 구제상가에는 평소 빈티지, 레트로 스타일을 좋아하는 사람이라면 눈에 쏙쏙 들어올 만한 상품들이 제법 있다. 패턴 있는 원피스나 복고풍 블라우스, 다양한 디자인과 재질의 스커트를 비롯해 청재킷, 야상, 코트 등의 가을·겨울 아우터도 저렴한 가격에 득템할 수 있다. "))




                magazine_datas.add(
                    MagazineData(
                    img_magazine = img_datas.get(4).imgUrl,
                    txt_magazine_title = "나만 알고 싶은 SNS 빈티지 숍",
                    txt_detail_magazine_contents_title = "세상에 오직 하나! 선착순 1등만이 소유할 수 있다고?\n빈티지 오브제의 매력을 느낄 수 있는 온라인 숍 계정을 소개합니다.\n" ,
                    txt_magazine_date = "2019.12.02",
                    txt_detail_magazine_contents = "집 꾸미기, 인테리어 덕후를 자처하는 에디터를 공개해요. 보는 순간 '어머 이건 사야 해!'를 외치게 되는 빈티지 소품들을 만나볼 수 있는 계정이죠. 빈티지의 특성상 '원 & 온리'이기 때문에 쇼핑에 필요한 건 바로 다름 아닌 스피드! 선착순 1등에 들고 싶어지는, 오롯이 나만 알고 싶은 빈티지 숍 계정이예요. ",
                    img_detail_magazine_contents = "https://image.jtbcplus.kr/data/contents/jam_photo/201907/05/be2eda24-223e-4819-82a8-bb77a6f09379.jpg",
                    txt_detail_magazine_contents_product_title = "@our_studio_",
                    txt_detail_magazine_product_contents = "마티스와 피카소 등 유명 화가들의 페인팅 액자로 이름을 알린 '아우어 스튜디오'예요. " +
                            "이후 빈티지 오브제를 소개하며 인스타그램에서 유명세를 얻고 있죠! 아우어 스튜디오의 주력 아이템은 다름 아닌 빈티지 램프. " +
                            "테이블 램프를 포함해 벽 등 램프까지 다채로운 디자인의 빈티지 오브제를 만나볼 수 있답니다. " +
                            "조명은 인테리어에서 '신스틸러' 같은 아이템인데요. 식탁이나 커피 테이블, 침대 옆 사이드 테이블에 두는 것만으로도 공간의 분위기를 근사하게 만들어주는 기특한 오브제죠. " +
                            "아우어 스튜디오에서 소개하는 70, 80년대의 우든 램프(플리츠처럼 주름 잡힌 갓이 특징!)나 조개나 튤립이 떠오르는 독특한 쉐이프의 세라믹 램프를 눈여겨보세요!  "))
                adapter.notifyDataSetChanged()
            },
            onError = {
                throw Exception()
            },
            onFail = {_,_->sendToast("오류입니다")}
        )


//        magazine_datas.add(MagazineData(img_magazine = "https://cdn.pixabay.com/photo/2016/01/19/17/47/hiker-1149898__340.jpg",txt_magazine_title = "군복에서 시작된 빈티지 아이템"))
//        magazine_datas.add(MagazineData(img_magazine = "https://cdn.pixabay.com/photo/2017/12/01/03/17/landscape-2990060__340.jpg",txt_magazine_title = "군복에서 시작된 빈티지 아이템"))
//        magazine_datas.add(MagazineData(img_magazine = "https://cdn.pixabay.com/photo/2017/01/28/02/24/japan-2014619__340.jpg",txt_magazine_title = "옷 만큼 개성있는 오프라인 빈티지 매장들"))
//        magazine_datas.add(MagazineData(img_magazine = "https://cdn.pixabay.com/photo/2017/05/13/16/02/taj-mahal-2309887__340.jpg",txt_magazine_title = "군복에서 시작된 빈티지 아이템"))
        adapter.datas = magazine_datas
        vp_magazine.adapter = adapter
        vp_magazine.setPageTransformer(false,DefaultTransformer())
        vp_magazine.offscreenPageLimit=5
    }
}
