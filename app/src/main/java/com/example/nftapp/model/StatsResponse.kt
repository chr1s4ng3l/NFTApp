package com.example.nftapp.model


import com.google.gson.annotations.SerializedName

data class StatsResponse(
    @SerializedName("stats")
    val stats: Stats? = Stats()
)