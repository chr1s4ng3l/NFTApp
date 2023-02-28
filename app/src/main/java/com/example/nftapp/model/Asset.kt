package com.example.nftapp.model


import com.google.gson.annotations.SerializedName

data class Asset(
    @SerializedName("animation_original_url")
    val animationOriginalUrl: String? = "",
    @SerializedName("animation_url")
    val animationUrl: String? = "",
    @SerializedName("asset_contract")
    val assetContract: AssetContract? = AssetContract(),
    @SerializedName("background_color")
    val backgroundColor: Any? = Any(),
    @SerializedName("collection")
    val collection: Collection? = Collection(),
    @SerializedName("creator")
    val creator: Creator? = Creator(),
    @SerializedName("decimals")
    val decimals: Int? = 0,
    @SerializedName("description")
    val description: String? = "",
    @SerializedName("external_link")
    val externalLink: String? = "",
    @SerializedName("id")
    val id: Int? = 0,
    @SerializedName("image_original_url")
    val imageOriginalUrl: String? = "",
    @SerializedName("image_preview_url")
    val imagePreviewUrl: String? = "",
    @SerializedName("image_thumbnail_url")
    val imageThumbnailUrl: String? = "",
    @SerializedName("image_url")
    val imageUrl: String? = "",
    @SerializedName("is_nsfw")
    val isNsfw: Boolean? = false,
    @SerializedName("is_presale")
    val isPresale: Boolean? = false,
    @SerializedName("last_sale")
    val lastSale: Any? = Any(),
    @SerializedName("listing_date")
    val listingDate: Any? = Any(),
    @SerializedName("name")
    val name: String? = "",
    @SerializedName("num_sales")
    val numSales: Int? = 0,
    @SerializedName("owner")
    val owner: Owner? = Owner(),
    @SerializedName("permalink")
    val permalink: String? = "",
    @SerializedName("sell_orders")
    val sellOrders: Any? = Any(),
    @SerializedName("token_id")
    val tokenId: String? = "",
    @SerializedName("token_metadata")
    val tokenMetadata: String? = "",
    @SerializedName("top_bid")
    val topBid: Any? = Any(),
    @SerializedName("traits")
    val traits: List<Trait>? = listOf(),
    @SerializedName("transfer_fee")
    val transferFee: Any? = Any(),
    @SerializedName("transfer_fee_payment_token")
    val transferFeePaymentToken: Any? = Any()
)