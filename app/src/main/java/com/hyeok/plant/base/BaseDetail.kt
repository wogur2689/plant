package com.hyeok.plant.base

import android.os.Bundle
import com.hyeok.plant.databinding.ActivityDetailBinding

class BaseDetail : BaseActivity<ActivityDetailBinding>({
    ActivityDetailBinding.inflate(it)
}) {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        val intent = intent //intent받기
    }
}