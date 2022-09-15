package com.hyeok.plant.base

import android.os.Bundle
import com.hyeok.plant.databinding.ActivityDetailBinding
import com.hyeok.plant.search.SearchResultData

class BaseDetail : BaseActivity<ActivityDetailBinding>({
    ActivityDetailBinding.inflate(it)
}) {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        val intent = intent //intent받기

        binding.resultImg.setImageResource(intent.getParcelableExtra<SearchResultData>("data")!!.img) //이미지
        binding.resultName.text = intent.getParcelableExtra<SearchResultData>("data")!!.name //이름
        binding.resultCharacteristic.text = intent.getParcelableExtra<SearchResultData>("data")!!.characteristic //특징
    }
}