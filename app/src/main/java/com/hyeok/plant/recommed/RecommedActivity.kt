package com.hyeok.plant.recommed

import android.os.Bundle
import com.hyeok.plant.base.BaseActivity
import com.hyeok.plant.databinding.ActivitySearchBinding

class RecommedActivity : BaseActivity<ActivitySearchBinding>({
    ActivitySearchBinding.inflate(it)
}) {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
    }
}