package com.hyeok.plant.imgSearch

import android.annotation.SuppressLint
import android.content.Intent
import android.graphics.Bitmap
import android.os.Bundle
import android.view.View
import android.webkit.WebSettings
import android.webkit.WebView
import android.webkit.WebViewClient
import com.hyeok.plant.MainActivity
import com.hyeok.plant.base.BaseActivity
import com.hyeok.plant.databinding.ActivityImgsearchBinding

class ImgSearchActivity : BaseActivity<ActivityImgsearchBinding>({
    ActivityImgsearchBinding.inflate(it)
}) {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        val intent = intent

        binding.progressBar.visibility = View.GONE //로딩바 가리기 (공간차지 X)

        initWebView()//웹뷰 초기화 및 구글 검색

        binding.btnCamera.setOnClickListener {
            val intent1 = Intent(this, CameraActivity::class.java)
            startActivity(intent1)
        }

        binding.btnMain.setOnClickListener {
            val intent2 = Intent(this, MainActivity::class.java)
            startActivity(intent2)
        }

    }

    /* 웹뷰 초기화 */
    @SuppressLint("SetJavaScriptEnabled") //javascript 사용시, XSS 경고가 뜨기 때문에 막기위해 사용.
    fun initWebView() {
        //1. 웹뷰클라이언트 연결(로딩 시작 / 끝 받아오기)
        binding.webView.webViewClient = object : WebViewClient() {
            //1) 로딩 시작
            override fun onPageStarted(view: WebView?, url: String?, favicon: Bitmap?) {
                super.onPageStarted(view, url, favicon)
                binding.progressBar.visibility = View.VISIBLE //로딩이 시작되면 로딩바 보이기
            }

            //2) 로딩 끝
            override fun onPageFinished(view: WebView?, url: String?) {
                super.onPageFinished(view, url)
                binding.progressBar.visibility = View.GONE //로딩이 끝나면 로딩바 없애기
            }

            //3)외부 브라우저가 아닌 웹뷰 자체에서 url 호출
            override fun shouldOverrideUrlLoading(view: WebView?, url: String?): Boolean {
                if (view != null && url != null) {
                    view.loadUrl(url)
                    return true
                }
                return false
            }
        }

        //2. WebSetting: 웹뷰의 각종 설정을 정하기
        val ws : WebSettings = binding.webView.settings
        //3. 자바스크립트 사용 허가
        ws.javaScriptEnabled = true
        //4. 웹페이지 호출
        binding.webView.loadUrl("https://www.google.co.kr")
    }

    /* 뒤로가기 동작 컨트롤 */
    override fun onBackPressed() {
        if(binding.webView.canGoBack()) { //이전페이지가 있으면
            binding.webView.goBack() //이전페이지로 이동
        } else {
            super.onBackPressed() //없으면 앱 종료
        }
    }
}