package com.example.nftapp.model


import com.google.gson.annotations.SerializedName

data class User(
    @SerializedName("username")
    val username: String? = null
)