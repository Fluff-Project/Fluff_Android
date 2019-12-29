package kr.market.fluff.ui.fragment.mypage.flub

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_flub_regular_customer.*
import kr.market.fluff.data.mypage.FlubCustomerData


class FlubRegularCustomer : AppCompatActivity() {

    lateinit var customerAdapter : FlubCustomerListAdapter
    lateinit var flub_customer_data : List<FlubCustomerData>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(kr.market.fluff.R.layout.activity_flub_regular_customer)

        makeCustomerList()

        img_regular_arrow.setOnClickListener {
            finish()
        }


    }

    fun makeCustomerList()
    {

        flub_customer_data = listOf(
            FlubCustomerData("https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRc4Bcz-y7xc_wH-L-NitJOiJzt2w8Y5eRPio8fIWp65l63seOu&s"
                ,"id-1"),
            FlubCustomerData("https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRc4Bcz-y7xc_wH-L-NitJOiJzt2w8Y5eRPio8fIWp65l63seOu&s"
                ,"id-2"),
            FlubCustomerData("https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRc4Bcz-y7xc_wH-L-NitJOiJzt2w8Y5eRPio8fIWp65l63seOu&s"
                ,"id-3"),
            FlubCustomerData("https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRc4Bcz-y7xc_wH-L-NitJOiJzt2w8Y5eRPio8fIWp65l63seOu&s"
                ,"id-4"),
            FlubCustomerData("https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRc4Bcz-y7xc_wH-L-NitJOiJzt2w8Y5eRPio8fIWp65l63seOu&s"
                ,"id-5")
        )

        customerAdapter = FlubCustomerListAdapter(flub_customer_data)
        rv_regular_customer_list.layoutManager = LinearLayoutManager(this@FlubRegularCustomer, LinearLayoutManager.VERTICAL,false)
        rv_regular_customer_list.adapter = customerAdapter
        customerAdapter.notifyDataSetChanged()
    }
}

