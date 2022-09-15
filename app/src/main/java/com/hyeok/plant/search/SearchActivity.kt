package com.hyeok.plant.search

import android.content.ContentValues.TAG
import android.os.Bundle
import android.util.Log
import androidx.core.content.ContextCompat
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.ValueEventListener
import com.google.firebase.database.ktx.database
import com.google.firebase.database.ktx.getValue
import com.google.firebase.ktx.Firebase
import com.hyeok.plant.base.BaseActivity
import com.hyeok.plant.R
import com.hyeok.plant.databinding.ActivitySearchBinding

class SearchActivity : BaseActivity<ActivitySearchBinding>({
    ActivitySearchBinding.inflate(it)
}) {
    private lateinit var database: DatabaseReference

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        val intent = intent //화면에서 넘어온 값 받기
        database = Firebase.database.reference //데이터베이스 인스턴스 가져오기

        database.setValue("데이터1")
        database.setValue("데이터2")
        database.setValue("데이터3")

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

        database.addValueEventListener(object  : ValueEventListener {
            override fun onDataChange(snapshot: DataSnapshot) {
                val value = snapshot.getValue<String>()
                Log.d(TAG, "value is: $value")
            }

            override fun onCancelled(error: DatabaseError) {
                Log.w(TAG, "Failed to read value.", error.toException())
            }
        })

        data.add(SearchResultData(keyword, R.drawable.ic_search, "특징10"))
        data.add(SearchResultData(keyword, R.drawable.ic_search, "특징20"))
        data.add(SearchResultData(keyword, R.drawable.ic_search, "특징30"))

        val searchAdapter = SearchAdapter(data)
        binding.searchResult.adapter = searchAdapter
    }
}