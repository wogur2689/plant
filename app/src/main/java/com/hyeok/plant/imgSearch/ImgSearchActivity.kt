package com.hyeok.plant.imgSearch

import android.os.Bundle
import com.hyeok.plant.base.BaseActivity
import com.hyeok.plant.databinding.ActivityImgsearchBinding

class ImgSearchActivity : BaseActivity<ActivityImgsearchBinding>({
    ActivityImgsearchBinding.inflate(it)
}) {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        binding.btnCamera.setOnClickListener {

        }
        binding.btnSearch.setOnClickListener {

        }

    }
}