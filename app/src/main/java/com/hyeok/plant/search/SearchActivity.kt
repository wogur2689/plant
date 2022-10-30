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
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase
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
        toast("이름을 입력하고 돋보기를 누르면 검색됩니다!")
        //검색 버튼 클릭시 검색
        binding.search.setOnClickListener {
            toast("검색")
            initRecycler(binding.searchInput.text.toString())
            binding.searchInput.text = null
        }
    }

    private fun initRecycler(keyword: String) {
        var datas = arrayListOf<SearchResultData>()
        val db = Firebase.firestore //데이터베이스 초기화
        //db에서 검색

        db.collection("plant")
            .get()
            .addOnSuccessListener { result ->
                for (document in result) {
                    if(document.id.equals(keyword)) {
                        datas.add(SearchResultData(document.get("name") as String,
                            (document.get("img").toString()).toInt(),
                            document.get("characteristic") as String
                        ))
                    }
                }
                val searchAdapter = SearchAdapter(datas)
                binding.searchResult.adapter = searchAdapter
            }
            .addOnFailureListener { exception ->
                toast("시스템 오류입니다. 다시 입력후 검색해주세요.")
                Log.w(TAG, "Error getting documents.", exception)
            }
    }
}