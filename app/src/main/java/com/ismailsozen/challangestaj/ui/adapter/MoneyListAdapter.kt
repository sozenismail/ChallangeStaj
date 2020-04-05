package com.ismailsozen.challangestaj.ui.adapter

import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.ismailsozen.challangestaj.model.MoneyModel
import com.ismailsozen.challangestaj.ui.MainActivity


class MoneyListAdapter(val mainCls: MainActivity.MainCls, val liste:List<MoneyModel>): RecyclerView.Adapter<MoneyListViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MoneyListViewHolder {

        return MoneyListViewHolder(parent)

    }

    override fun getItemCount(): Int {

        return mainCls.data.coins.count()
    }

    override fun onBindViewHolder(holder: MoneyListViewHolder, position: Int) {

        val money=mainCls.data.coins.get(position)

        holder.bind(money)




    }


    }

