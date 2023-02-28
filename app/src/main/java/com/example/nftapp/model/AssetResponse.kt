package com.example.nftapp.model


import com.google.gson.annotations.SerializedName

data class AssetResponse(
    @SerializedName("assets")
    val assets: List<Asset>? = listOf(),
    @SerializedName("next")
    val next: String? = "",
    @SerializedName("previous")
    val previous: Any? = Any()
)