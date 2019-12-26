# Fluff_Android


#1. 프로젝트 사용 라이브러리!

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


#2. 프로그램 구조

![d](https://user-images.githubusercontent.com/54485132/71461583-a4953700-27f3-11ea-9547-2ed74f5e90ff.png).

프로그램 구조는 크게 data, network, ui로 패키징하여 작업을 진행중이다.



![network_structure](https://user-images.githubusercontent.com/54485132/71461999-3cdfeb80-27f5-11ea-90d1-13545e10940c.png).


network는 다음과 위와 같이 BASE_URL을 가진 싱글톤과, 해당 부분 구현시 이용할 interface,
Kotlin Extension Function을 이용한 enqueue 메소드가 있다.


![ui_structure](https://user-images.githubusercontent.com/54485132/71462003-40737280-27f5-11ea-9ff5-3ddfd5424a8e.png).


ui도 나름대로 패키징을 하였으나, 아직 뷰 구현이 진행중이라 구조가 명확하지는 않다.
하지만 로그인,회원가입에 대한 부분과 하단 탭바를 눌렀을 때 전환되는 5가지 프래그먼트가 있고,
해당 프래그먼트에서 연동되는 액티비티같은 경우 그 패키지 속에 분류를 하여 진행하고있다.



#3. 핵심 기능 구현 방법 정리
