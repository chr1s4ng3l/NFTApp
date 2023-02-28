package com.example.nftapp.model


import com.google.gson.annotations.SerializedName

data class Creator(
    @SerializedName("address")
    val address: String? = null,
    @SerializedName("config")
    val config: String? = null,
    @SerializedName("profile_img_url")
    val profileImgUrl: String? = null,
    @SerializedName("user")
    val user: User? = null
)