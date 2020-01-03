# Fluff_Android


# 1. 프로젝트 사용 라이브러리! (2020.01.02 수정)

    implementation 'com.google.android.material:material:1.0.0'
    implementation 'com.android.support:design:29.0.0'
    //리사이클러뷰
    implementation 'androidx.recyclerview:recyclerview:1.0.0'

    //Retrofit 라이브러리 : https://github.com/square/retrofit
    implementation 'com.squareup.retrofit2:retrofit:2.6.2'
    //Retrofit 라이브러리 응답으로 가짜 객체를 만들기 위해
    implementation 'com.squareup.retrofit2:retrofit-mock:2.6.2'

    //객체 시리얼라이즈를 위한 Gson 라이브러리 : https://github.com/google/gson
    implementation 'com.google.code.gson:gson:2.8.6'
    //Retrofit 에서 Gson 을 사용하기 위한 라이브러리
    implementation 'com.squareup.retrofit2:converter-gson:2.6.2'

    //이미지 로딩
    implementation 'com.github.bumptech.glide:glide:4.10.0'
    annotationProcessor 'com.github.bumptech.glide:compiler:4.10.0'

    //동그란 이미지 커스텀 뷰 라이브러리 : https://github.com/hdodenhof/CircleImageView
    implementation 'de.hdodenhof:circleimageview:3.0.1'

    //indecator 효과
    implementation 'com.tbuonomo.andrui:viewpagerdotsindicator:4.1.2'
    
    //multi radiobutton
    implementation 'com.yuxingxin.multiradiogroup:library:1.0.0'
    //Picaso 라이브러리 (이미지)
    implementation 'com.squareup.picasso:picasso:2.4.0'

    //페이스북 연동
    implementation 'com.facebook.android:facebook-login:[5,6)'


# 2. 프로그램 구조

![d](https://user-images.githubusercontent.com/54485132/71461583-a4953700-27f3-11ea-9547-2ed74f5e90ff.png)

프로그램 구조는 크게 data, network, ui로 패키징하여 작업을 진행중이다.




![network_structure](https://user-images.githubusercontent.com/54485132/71461999-3cdfeb80-27f5-11ea-90d1-13545e10940c.png)



network는 다음과 위와 같이 BASE_URL을 가진 싱글톤과, 해당 부분 구현시 이용할 interface,
Kotlin Extension Function을 이용한 enqueue 메소드가 있다.<br/>

![ui_structure](https://user-images.githubusercontent.com/54485132/71462003-40737280-27f5-11ea-9ff5-3ddfd5424a8e.png)



ui도 나름대로 패키징을 하였으나, 아직 뷰 구현이 진행중이라 구조가 명확하지는 않다.
하지만 로그인,회원가입에 대한 부분과 하단 탭바를 눌렀을 때 전환되는 5가지 프래그먼트가 있고,
해당 프래그먼트에서 연동되는 액티비티같은 경우 그 패키지 속에 분류를 하여 진행하고있다.



# 3. 핵심 기능 구현 방법 정리

## 1. 회원가입 및 로그인.

![register](https://user-images.githubusercontent.com/54485132/71463252-19b73b00-27f9-11ea-93a6-1be8127c1af5.gif)

### 1) 애니매이션
어플 실행시 배경의 변화, 로그인 / 회원가입 시 EditText변화 등의 애니매이션을 적용하였다.
ObjectAnimator의 ALPHA, TRANSLATE 속성 등을 이용하였다.

### 2) kotlin extension이용
kotlin extension을 이용하여 작성된 enqueue메소드와 sendToast라는 메소드를 적용하였다.
위 이미지에서는 이메일 중복 체크, 로그인 요청에 enqueue 함수를 이용하였고,
이메일 중복체크 결과를 띄우는 토스트 또한 Toast의 함수를 확장시켜 sendToast를 이용하였다.
(기존 코드의 반복되는 요소들을 줄일 수 있었다.)

ex 1) 토스트를 만들어 사용하는 경우
val toast = Toast.makeText(this,"멘트",Toast.LENTH_SHORT)
toast.show()

를 kotlin extension 을 이용하여 생성한 함수 sendToast()를 이용하여
sendToast("멘트") 를 작성해주기만 하면 된다.

![s](https://user-images.githubusercontent.com/54485132/71463993-816e8580-27fb-11ea-8b67-1a6dd3516188.png)

ex 2) enqueue 메소드

ex 3) textview
가격을 1000원 -> 1,000원 으로 바꾸어주었다.

![image](https://user-images.githubusercontent.com/37995236/71648441-ad33c300-2d47-11ea-9707-542272650377.png)

ex 4) editText
가격 입력시 자동으로 ,(콤마) 넣어주었다.
![image](https://user-images.githubusercontent.com/37995236/71648529-bcffd700-2d48-11ea-994f-ac0e8eb865e9.png)

![edittext](https://user-images.githubusercontent.com/37995236/71648539-ed477580-2d48-11ea-92c9-70a735696213.gif)


## 2. lambda 식 이용하기.


![back](https://user-images.githubusercontent.com/54485132/71465526-3c991d80-2800-11ea-9336-7cb551814fde.png)

가독성을 높이기 위해 위와 같이 람다식을 활용하였다.



# 3. 외부 라이브러리 및 소스 이용한 화면 전환하기.

![main](https://user-images.githubusercontent.com/54485132/71464258-238e6d80-27fc-11ea-8f77-2fb96955a52c.gif)

implementation 'com.tbuonomo.andrui:viewpagerdotsindicator:4.1.2' 을 이용해 추가한 Indicator를
뷰페이져와 연동시켜 전환 효과를 적용시켰다.

또한 매거진의 세로 스크롤 기능 또한 Vertical ViewPager 검색을 통해 기존의 뷰페이저를 변형한 커스텀을 적용시켰다.

# 4. 리사이클러뷰를 이용한 화면 구성

![fssfda](https://user-images.githubusercontent.com/54485132/71465343-b11f8c80-27ff-11ea-9be7-98c8b3f9e584.gif)


위에 사용된 리사이클러뷰는 세미나때 배운 내용을 바탕으로 적용되었다.

- 홈화면의 상단 뷰페이져를 제외한 목록들

- 마이페이지의 최근 본 상품, 좋아요/팔로우 리스트

# 5. 페이스북 로그인 연동하기
https://re-build.tistory.com/11
해당 사이트 및 facebook developer 사이트를 참고하여 다음과 같이 페이스북 로그인 연동을 하였다.
이와 더불어 SharedPreferences를 활용해 자동로그인 및 로그아웃에 대한 이벤트 처리를 구현하였다.
아래는 해당 화면이다.

![facebook_login](https://user-images.githubusercontent.com/54485132/71578034-c8c97e80-2b39-11ea-8b36-89b58ebbdc5f.gif)


![autoLogin](https://user-images.githubusercontent.com/54485132/71577987-9750b300-2b39-11ea-85e3-c0eaa85e4c2e.gif)



# 6. 경매 화면 애니매이션 적용
구글 머티리얼 디자인 가이드와 구글링을 통해 recyclerview의 아이템 클릭시 액티비티로 전환될 때 애니매이션을 구현하였다.
아래는 해당 화면과 코드이다.

![auction](https://user-images.githubusercontent.com/54485132/71577995-9b7cd080-2b39-11ea-8389-5cb5e5eb3fdc.gif)


![제목 없음](https://user-images.githubusercontent.com/54485132/71577999-a0418480-2b39-11ea-8426-023a9fa4a873.png)



# 7.필터 뷰 완성 - Bottom sheet Behavior 이용
옷을 선택할 때는 RadioButton을 이용하였다.
이 과정에서 RadioGroup은 기본으로 제공되는 상태로는 두 줄로 나열 할 수 없었기에 
implementation 'com.yuxingxin.multiradiogroup:library:1.0.0'
을 통해 이를 가능하게 해 주었다.
Bottom sheet Behavior 속성 중 hideable="true"를 통해 드래그해서 필터 뷰를 내릴 수 있도록 구현해주었다.

![bottomsheet](https://user-images.githubusercontent.com/37995236/71648361-9f317280-2d46-11ea-99b9-193261e98ad2.gif)



# 8. 갤러리 연동하기 - 빈티지 샵을 등록하기 위해 사진을 올릴 필요가 있는데 이를 위해 내 폰의 갤러리를 연동할 수 있도록 하였다.

![glary](https://user-images.githubusercontent.com/54485132/71577997-9e77c100-2b39-11ea-98bd-fd646d4de623.gif)


# 9. RecyclerView 아이템 개수에 따른 처리 구현하기
아래 사진을 보면 3개정도 이상의 아이템이 있는 경우 +3과 같은 요약 표시를 해줘야 할 필요가 있었다.
해당 기능에 대해 kotlin의 collection 기능을 이용하였고, 이에 대한 코드는 다음과 같다.


![recyclerview](https://user-images.githubusercontent.com/54485132/71578004-a899bf80-2b39-11ea-8bc3-c6f0d481a328.gif)

![recycler](https://user-images.githubusercontent.com/54485132/71578123-3a093180-2b3a-11ea-901e-0e87ba7a1bcf.png)


# 10. 경매 Timer 구현하기 
경매가 끝나는 시간을 서버에 받아온 뒤 경매를 진행 중인 시간을 계산하여 해당 경매 아이템 뷰에 흘러가는 시간을 표시했다.
해당 기능에 대해 kotlin에 존재하는 CountDownTimer 객체를 이용하여 1초마다 시간이 줄어가는 것을 표시했다.
이에 대한 코드는 다음과 같다.

```kotlin
fun countDownTimer(long: Long)
    {
        var countDownTimer = object :  CountDownTimer(long*1000, 1000)
        {
            override fun onFinish() {
                tv_auction_detail_extra_time.text = "경매가 마감되었습니다."
                tv_auction_detail_extra_text.text = ""
//                sendToast("경매가 마감되었습니다.")
            }
            override fun onTick(p0: Long) {
                val hours = p0.div(3600000)
                var temp = p0/1000 - hours*3600
                val min = p0.div(60000).toInt() - p0.div(3600000)*60
                val seconds = temp - min*60
                if ( hours < 10)
                {
                    tv_auction_detail_extra_time.text  = "0" + hours.toString()+ " : "+ min.toString() + " : " + seconds.toString()
                    if( min < 10)
                    {
                        tv_auction_detail_extra_time.text  = "0" + hours.toString()+ " : "+ "0" + min.toString() + " : " + seconds.toString()
                    }
                }
                else
                {
                    if(min < 10)
                    {
                        tv_auction_detail_extra_time.text  =  hours.toString()+ " : "+ "0" + min.toString() + " : " + seconds.toString()
                    }
                    tv_auction_detail_extra_time.text  = hours.toString()+ " : "+ min.toString() + " : " + seconds.toString()
                }
            }
        }
        countDownTimer.start()
    }
```



# 11 장바구니 기능 
상품을 장바구니에 담으면 상품이 장바구니에 담기게 되고, 장바구니 뷰에서 상품을 삭제하면 장바구니에서 상품이 삭제되는 기능을 구현했다. 또한 장바구니에서 전체선택 체크박스를 통해 상품들을 모두 다 선택 하기를 원할 시 전체 선택이 되고, 
만약 하나라도 상품의 체크박스가 체크가 풀릴 시 전체선택이 풀리게 구현하였다.

```kotlin
//액티비티 내의 코드
cb_cart_check_all.setOnClickListener{
            if(cb_cart_check_all.isChecked){
                cartGoodsAdapter.isAllSelected = true
                cartGoodsAdapter.notifyDataSetChanged()
            }else{
                cartGoodsAdapter.isAllSelected = false
                cartGoodsAdapter.notifyDataSetChanged()
            }
        }
```

```kotlin
//체크박스 들어있는 RecyclerView의 뷰홀더에 해당하는 부분
 if(isAllCheck){
            cb_cart_goods.isChecked = true
        }else{
            cb_cart_goods.isChecked = false
        }
        cb_cart_goods.setOnCheckedChangeListener{
            buttonView, isChecked ->
            if(isChecked){
                ctx.count++
                ctx.checkItem()
                ctx.selected_cart_list!!.add(goodsData)
            }else{
                ctx.count--
                ctx.checkItem()
                ctx.selected_cart_list!!.remove(goodsData)
                ctx.cb_cart_check_all.isChecked = false
            }
        }
```

# 12 스타일 추천 
회원가입 성공 후, 각각의 유저에 취향에 따른 상품을 추천해주기 위해, 유저가 마음에 드는 사진을 3개 이상 선택하게 한다.
유저의 취향이 서버를 통해 분석이 되어지면, 그에 맞는 키워드를 가진 셀러(플럽)을 추천해주고, 
취향에 맞는 스타일의 옷들이 홈화면에 나오게 된다.

# 13 상품 둘러보기 탭
유저 취향에 따른 옷들이 최신순으로 둘러보기 화면에 나오게 되고, 필터 아이콘을 선택하여 옷의 종류, 색깔, 스타일, 사이즈,등 을
선택하게 되면 상품 DB에 존재하는 모든 옷들 중 유저가 고른 필터에 따른 옷들만 화면에 존재하게 된다.

# 14 custom Toast 사용
유저가 마음에 드는 사진을 클릭시 customToast를 통해 하트 이미지가 화면 중앙에 뜨게 되고 해당 상품의 하단 하트 버튼이 
채워지게 된다.

# 15 

