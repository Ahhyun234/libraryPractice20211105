package com.nepplus.librarypractice20211105

import android.Manifest
import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.bumptech.glide.Glide
import com.gun0912.tedpermission.PermissionListener
import com.gun0912.tedpermission.normal.TedPermission
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

//            권한이 있거나 없을때의 행동은 위에서 코딩 완료
//            권한이 있는지 확인하는것은 아래 적음
            TedPermission.create().setPermissionListener(performedListener)
                .setPermissions(Manifest.permission.CALL_PHONE)
                .check()





        }

    }

    fun setupValues() {

        Glide.with(this).load("https://i.ytimg.com/vi/NLy6UdpBlPw/maxresdefault.jpg").into(imgAction)

        btnCall.setOnClickListener {

        }

    }
}