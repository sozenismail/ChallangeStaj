package com.ismailsozen.challangestaj.ui.adapter

import android.content.Intent
import android.graphics.Color
import android.net.Uri
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.github.twocoffeesoneteam.glidetovectoryou.GlideToVectorYou
import com.github.twocoffeesoneteam.glidetovectoryou.GlideToVectorYouListener
import com.ismailsozen.challangestaj.R
import com.ismailsozen.challangestaj.mock.Coins
import com.ismailsozen.challangestaj.ui.MoneyDetailActivity
import kotlinx.android.synthetic.main.adapter_item_money_list.view.*
import java.math.RoundingMode


class MoneyListViewHolder(parent: ViewGroup) : RecyclerView.ViewHolder(

    LayoutInflater.from(parent.context).inflate(R.layout.adapter_item_money_list, parent, false)

) {

    val moneytype = itemView.moneyType
    val moneyprice = itemView.moneyPrice
    var moneyimage = itemView.imgMoneyIcon
    var moneydetail =""



    fun bind(money: Coins) {

        moneytype.text = money.name
        val round =money.price.toBigDecimal().setScale(2, RoundingMode.FLOOR).toDouble()

        moneyprice.text = round.toString()
        // moneyprice.text=money.price
        moneydetail=money.description


        if (money.color==null || money.color.length<6){
            moneyprice.setTextColor(Color.parseColor("#000000"))
            moneytype.setTextColor(Color.parseColor("#000000"))

        }

        else  {
            moneyprice.setTextColor(Color.parseColor(money.color))
            moneytype.setTextColor(Color.parseColor(money.color))
        }




        GlideToVectorYou
            .init()
            .with(itemView.context)
            .withListener(object : GlideToVectorYouListener {
                override fun onLoadFailed() {
                    Toast.makeText(itemView.context, "Loading failed", Toast.LENGTH_SHORT).show()
                }

                override fun onResourceReady() {
                    //--
                }
            })
            .load(Uri.parse(money.iconUrl), moneyimage)


        itemView.setOnClickListener{v->

            var intent= Intent(v.context, MoneyDetailActivity::class.java)
            intent.putExtra("moneytype",itemView.moneyType.text)
            intent.putExtra("moneyprice",itemView.moneyPrice.text)
            intent.putExtra("moneydetail",money.description)
            intent.putExtra("moneyimage",money.iconUrl)
            intent.putExtra("moneycolor",money.color)


            v.context.startActivity(intent)


        }





    }
}