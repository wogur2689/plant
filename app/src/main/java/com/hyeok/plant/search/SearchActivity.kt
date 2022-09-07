package com.hyeok.plant.search

import android.os.Bundle
import androidx.core.content.ContextCompat
import com.hyeok.plant.base.BaseActivity
import com.hyeok.plant.R
import com.hyeok.plant.databinding.ActivitySearchBinding

class SearchActivity : BaseActivity<ActivitySearchBinding>({
    ActivitySearchBinding.inflate(it)
}) {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        val intent = intent //화면에서 넘어온 값 받기

        toast("돋보기를 누르면 검색됩니다!")
        //검색 버튼 클릭시 검색
        binding.search.setOnClickListener {
            toast("검색")
            initRecycler(binding.searchInput.text.toString())
            binding.searchInput.text = null
        }
    }

    private fun initRecycler(keyword: String) {
        //이제 DB에서 데이터 가져와서 하면 끝
        val data = arrayListOf<SearchResultData>()
        data.add(SearchResultData(keyword, ContextCompat.getDrawable(this, R.drawable.ic_search)!!))
        data.add(SearchResultData(keyword, ContextCompat.getDrawable(this, R.drawable.ic_search)!!))
        data.add(SearchResultData(keyword, ContextCompat.getDrawable(this, R.drawable.ic_search)!!))

        val searchAdapter = SearchAdapter(data)
        binding.searchResult.adapter = searchAdapter
    }
}