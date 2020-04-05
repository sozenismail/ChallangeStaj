package com.ismailsozen.challangestaj.ui

import android.net.Uri
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.github.twocoffeesoneteam.glidetovectoryou.GlideToVectorYou
import com.github.twocoffeesoneteam.glidetovectoryou.GlideToVectorYouListener
import com.ismailsozen.challangestaj.R
import kotlinx.android.synthetic.main.activity_money_detail.*

class MoneyDetailActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_money_detail)




        var getIntent=intent
        setTitle(getIntent.getStringExtra("moneytype"))
        var getUrlSvg=getIntent.getStringExtra("moneyimage")

        GlideToVectorYou
            .init()
            .with(this)
            .withListener(object : GlideToVectorYouListener {
                override fun onLoadFailed() {
                    Toast.makeText(applicationContext, "Loading failed", Toast.LENGTH_SHORT).show()
                }

                override fun onResourceReady() {
                    //--
                }
            })
            .load(Uri.parse(getUrlSvg), imgMoneyIcon)


        if (getIntent !=null)
        {
            textViewMoneyType.text=getIntent.getStringExtra("moneytype")
            textViewMoneyPrice.text=getIntent.getStringExtra("moneyprice")
            textViewMoneyDetail.text=getIntent.getStringExtra("moneydetail")



        }

    }
}
