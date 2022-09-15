package com.hyeok.plant.search

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class SearchResultData(
    var name : String, //이름
    var img : Int, //이미지
    var characteristic : String //특징
) : Parcelable
