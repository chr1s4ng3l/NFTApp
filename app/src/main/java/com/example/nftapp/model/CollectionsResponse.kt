package com.example.nftapp.model


import com.google.gson.annotations.SerializedName

data class CollectionsResponse(
    @SerializedName("collections")
    val collections: List<Collection>? = listOf()
)