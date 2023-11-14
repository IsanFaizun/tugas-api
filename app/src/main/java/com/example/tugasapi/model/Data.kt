package com.example.tugasapi.model

import com.google.gson.annotations.SerializedName

data class Data (
    @SerializedName("images") val images : Images,
    @SerializedName("title") val title : String,
    @SerializedName("type") val type : String,
    @SerializedName("source") val source : String,
    @SerializedName("episodes") val episodes : Int,
    @SerializedName("status") val status : String,
    @SerializedName("score") val score : Double,
)