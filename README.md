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

1. 회원가입 및 로그인
![register](https://user-images.githubusercontent.com/54485132/71463252-19b73b00-27f9-11ea-93a6-1be8127c1af5.gif).

1) 애니매이션
어플 실행시 배경의 변화, 로그인 / 회원가입 시 EditText변화 등의 애니매이션을 적용하였다.
ObjectAnimator의 ALPHA, TRANSLATE 속성 등을 이용하였다.

2) kotlin extension이용
kotlin extension을 이용하여 작성된 enqueue메소드와 sendToast라는 메소드를 적용하였다.
위 이미지에서는 이메일 중복 체크, 로그인 요청에 enqueue 함수를 이용하였고,
이메일 중복체크 결과를 띄우는 토스트 또한 Toast의 함수를 확장시켜 sendToast를 이용하였다.
(기존 코드의 반복되는 요소들을 줄일 수 있었다.)

ex) 토스트를 만들어 사용하는 경우
val toast = Toast.makeText(this,"멘트",Toast.LENTH_SHORT)
toast.show()

를 kotlin extension 을 이용하여 생성한 함수 sendToast()를 이용하여
toast.sendToast(this,"멘트") 를 작성해주기만 하면 된다.

.![s](https://user-images.githubusercontent.com/54485132/71463993-816e8580-27fb-11ea-8b67-1a6dd3516188.png).





