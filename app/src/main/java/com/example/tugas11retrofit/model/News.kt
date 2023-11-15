package com.example.tugas11retrofit.model

import com.google.gson.annotations.SerializedName

data class News(
    @SerializedName("datanews")
    val datanews: List<DataNews>
)
