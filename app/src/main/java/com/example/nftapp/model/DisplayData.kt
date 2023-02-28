package com.example.nftapp.model


import com.google.gson.annotations.SerializedName

data class DisplayData(
    @SerializedName("card_display_style")
    val cardDisplayStyle: String? = null
)