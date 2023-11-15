package com.example.tugas11retrofit.network

import com.example.tugas11retrofit.model.DataNews
import retrofit2.Call
import retrofit2.http.GET

interface ApiService {

    @GET("/v1/news?access_key=eaece2cab85415cbac361fce9f931150")
    fun getAllNews() : Call<DataNews>

}