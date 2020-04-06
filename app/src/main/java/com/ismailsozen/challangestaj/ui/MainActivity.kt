package com.ismailsozen.challangestaj.ui

import android.os.Bundle
import android.widget.ProgressBar
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.gson.GsonBuilder
import com.ismailsozen.challangestaj.R
import com.ismailsozen.challangestaj.mock.MainCls
import com.ismailsozen.challangestaj.ui.adapter.MoneyListAdapter
import kotlinx.android.synthetic.main.activity_main.*
import okhttp3.Callback
import okhttp3.OkHttpClient
import okhttp3.Request


class MainActivity : AppCompatActivity() {



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        recyclerviewMain.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)

        progressbar.visibility=ProgressBar.VISIBLE

        fetchJson()



    }

     fun fetchJson() {

         val url="https://api.coinranking.com/v1/public/coins"
         var request=Request.Builder().url(url).build()

         val client= OkHttpClient()
         client.newCall(request).enqueue(object: Callback {

             override fun onFailure(call: okhttp3.Call, e: java.io.IOException) {
                 print("Error !")
             }

             override fun onResponse(call: okhttp3.Call, response: okhttp3.Response) {

                 val body= response.body?.string()

                         val gson = GsonBuilder().create()
                         val mainCls = gson.fromJson(body, MainCls::class.java)
                         runOnUiThread {

                             recyclerviewMain.adapter =
                                 MoneyListAdapter(mainCls)
                             progressbar.visibility=ProgressBar.INVISIBLE


                         }

                 }


         })



    }


}



