package com.example.tugasapi.model

import com.google.gson.annotations.SerializedName

data class Images(
    @SerializedName("jpg") val jpg: ImageData
)
