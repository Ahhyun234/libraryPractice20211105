package com.nepplus.librarypractice20211105

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setupEvent()
        setupValues()
    }

    fun setupEvent(){

//        이미지 뷰나 txt 뷰/ LinearLayout등은 버튼처럼 setOnClickListener가능
        imgProfile.setOnClickListener {

            val myIntent=Intent(this,ViewPhotoActivity::class.java)
            startActivity(myIntent)

        }

    }
    fun setupValues(){

    }
}