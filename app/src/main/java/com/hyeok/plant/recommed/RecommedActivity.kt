package com.hyeok.plant.recommed

import android.os.Bundle
import com.hyeok.plant.base.BaseActivity
import com.hyeok.plant.databinding.ActivitySearchBinding
import java.util.*

class RecommedActivity : BaseActivity<ActivitySearchBinding>({
    ActivitySearchBinding.inflate(it)
}) {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        /* 오늘의 식물 추천 */
    }

    fun rand(from: Int, to: Int) : Int {
        val random = Random()
        return random.nextInt(to - from) + from
    }
}