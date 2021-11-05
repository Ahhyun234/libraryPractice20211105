package com.nepplus.librarypractice20211105

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.gun0912.tedpermission.PermissionListener
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setupEvent()
        setupValues()
    }

    fun setupEvent() {

//        이미지 뷰나 txt 뷰/ LinearLayout등은 버튼처럼 setOnClickListener가능
        imgProfile.setOnClickListener {

            val myIntent = Intent(this, ViewPhotoActivity::class.java)
            startActivity(myIntent)
//      권한 획득
//      1) 권한 여하에 따른 상황별 대처 방안. 미리 변수에 담아두자
            val performedListener = object : PermissionListener {
                override fun onPermissionGranted() {
//                    권한이 획득 되었을 때 실행 할 코드
//                    Call 액션을 권한 ok일 때 만 활용
                    val myUri = Uri.parse("tel:010-5555-5555")
                    val myIntent = Intent(Intent.ACTION_CALL,myUri)
                    startActivity(myIntent)
                    

                }

                override fun onPermissionDenied(deniedPermissions: MutableList<String>?) {
//                    권한이 거부 되었을 때 실행 할 코드
                    Toast.makeText(this@MainActivity, "권한이 거부되어 전화연결이 불가합니다.", Toast.LENGTH_SHORT).show()
                }

            }

        }

    }

    fun setupValues() {

        btnCall.setOnClickListener {

        }

    }
}