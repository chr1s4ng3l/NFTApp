package com.example.nftapp.model


import com.google.gson.annotations.SerializedName

data class Trait(
    @SerializedName("display_type")
    val displayType: Any? = null,
    @SerializedName("max_value")
    val maxValue: Any? = null,
    @SerializedName("order")
    val order: Any? = null,
    @SerializedName("trait_count")
    val traitCount: Int? = null,
    @SerializedName("trait_type")
    val traitType: String? = null,
    @SerializedName("value")
    val value: String? = null
)