package com.ismailsozen.challangestaj.ui.adapter

import android.content.Intent
import android.graphics.Color
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.ismailsozen.challangestaj.R
import com.ismailsozen.challangestaj.ui.MainActivity
import com.ismailsozen.challangestaj.ui.MoneyDetailActivity
import kotlinx.android.synthetic.main.activity_money_detail.view.*
import kotlinx.android.synthetic.main.adapter_item_money_list.view.*
import kotlinx.android.synthetic.main.adapter_item_money_list.view.imgMoneyIcon


class MoneyListViewHolder(parent: ViewGroup) : RecyclerView.ViewHolder(

    LayoutInflater.from(parent.context).inflate(R.layout.adapter_item_money_list, parent, false)

) {

    val moneytype = itemView.moneyType
    val moneyprice = itemView.moneyPrice
    val moneyimage = itemView.imgMoneyIcon
    var moneydetail =""

    fun bind(money: MainActivity.Coins) {

        moneytype.text = money.name
        moneyprice.text = money.price
        moneydetail=money.description.toString()

         if (money.color==null){
             moneyprice.setTextColor(Color.parseColor("#000000"))
         }

         else  {
                moneyprice.setTextColor(Color.parseColor(money.color))
          }

        Glide.with(itemView.context)

            .load("http://icons.iconarchive.com/icons/froyoshark/enkel/256/Bitcoin-icon.png")
            .into(moneyimage)




        itemView.setOnClickListener{v->

            var intent= Intent(v.context, MoneyDetailActivity::class.java)
            intent.putExtra("moneytype",itemView.moneyType.text)
            intent.putExtra("moneyprice",itemView.moneyPrice.text)
            intent.putExtra("moneydetail",itemView.textViewMoneyDetail.text)


            v.context.startActivity(intent)


        }

/*
        Picasso.get()
            .load("")
            .into(moneyimage);

    }
*/





    }
}