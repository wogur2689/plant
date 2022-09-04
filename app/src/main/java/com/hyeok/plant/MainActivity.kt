package com.hyeok.plant

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.hyeok.plant.databinding.ActivityMainBinding
import com.hyeok.plant.databinding.ActivitySearchBinding

class MainActivity : BaseActivity<ActivityMainBinding>({
    ActivityMainBinding.inflate(it)
}) {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        binding.button1.setOnClickListener {
            toast("로그인 화면")
        }
        binding.searchBtn.setOnClickListener {
            val intent = Intent(this, SearchActivity::class.java)
            startActivity(intent)
        }
        binding.button3.setOnClickListener {
            toast("오늘의 식물 추천")
        }
        binding.button4.setOnClickListener {
            toast("오늘의 날씨")
        }
    }

}