package com.hyeok.plant.search

import android.graphics.drawable.Drawable

data class SearchResultData(
    var name : String, //이름
    var img : Drawable, //이미지
    var characteristic : String //특징
)
