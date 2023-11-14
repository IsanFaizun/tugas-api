package com.example.tugasapi.model

import com.google.gson.annotations.SerializedName

data class Anime(
    @SerializedName("data") val data: List<Data>
)
