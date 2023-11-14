package com.example.tugasapi.network

import com.example.tugasapi.model.Anime
import retrofit2.Call
import retrofit2.http.GET

interface ApiService {
    @GET("anime")
    fun getAllAnime() : Call<Anime>
}