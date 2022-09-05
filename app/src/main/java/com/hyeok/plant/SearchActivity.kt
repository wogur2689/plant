package com.hyeok.plant

import android.os.Bundle
import com.hyeok.plant.databinding.ActivitySearchBinding

class SearchActivity : BaseActivity<ActivitySearchBinding>({
    ActivitySearchBinding.inflate(it)
}) {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        val intent = intent //화면에서 넘어온 값 받기

        //검색 버튼 클릭시 검색
        binding.search.setOnClickListener {
            toast("검색")
        }

        binding.searchInput.text
    }
}