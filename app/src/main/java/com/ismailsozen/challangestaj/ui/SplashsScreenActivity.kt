package com.ismailsozen.challangestaj.ui

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.ismailsozen.challangestaj.R

class SplashsScreenActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splashs_screen)

        val background = object : Thread() {

            override fun run() {
                 try {
                     Thread.sleep(3000)
                     val intent= Intent(baseContext,MainActivity::class.java)
                     startActivity(intent)
                 }catch (e:Exception){e.printStackTrace()}
            }
        }

        background.start()

    }
}
