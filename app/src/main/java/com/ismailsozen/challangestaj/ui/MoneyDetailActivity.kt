package com.ismailsozen.challangestaj.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide
import com.ismailsozen.challangestaj.R
import kotlinx.android.synthetic.main.activity_money_detail.*

class MoneyDetailActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_money_detail)




        var getIntent=intent
        setTitle(getIntent.getStringExtra("moneytype"))

        if (getIntent !=null)
        {
            textViewMoneyType.text=getIntent.getStringExtra("moneytype")
            textViewMoneyPrice.text=getIntent.getStringExtra("moneyprice")
            textViewMoneyDetail.text=getIntent.getStringExtra("moneydetail")
            Glide.with(this)

                .load("https://icons.iconarchive.com/icons/cjdowner/cryptocurrency-flat/512/Ethereum-ETH-icon.png")
                .into(imgMoneyIcon)

        }

    }
}
