package com.hyeok.plant

import android.content.Intent
import android.os.Bundle
import com.hyeok.plant.base.BaseActivity
import com.hyeok.plant.databinding.ActivityMainBinding
import com.hyeok.plant.search.SearchActivity

class MainActivity : BaseActivity<ActivityMainBinding>({
    ActivityMainBinding.inflate(it)
}) {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        binding.recommedBtn.setOnClickListener {
            toast("오늘의 식물 추천")
        }
        binding.searchBtn.setOnClickListener {
            val intent = Intent(this, SearchActivity::class.java)
            startActivity(intent)
        }
        binding.imgSearchBtn.setOnClickListener {
            toast("이미지 검색")
        }
    }
}