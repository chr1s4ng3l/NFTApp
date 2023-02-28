package com.example.nftapp.model


import com.google.gson.annotations.SerializedName

data class Collection(
    @SerializedName("banner_image_url")
    val bannerImageUrl: String? = null,
    @SerializedName("chat_url")
    val chatUrl: Any? = null,
    @SerializedName("created_date")
    val createdDate: String? = null,
    @SerializedName("default_to_fiat")
    val defaultToFiat: Boolean? = null,
    @SerializedName("description")
    val description: String? = null,
    @SerializedName("dev_buyer_fee_basis_points")
    val devBuyerFeeBasisPoints: String? = null,
    @SerializedName("dev_seller_fee_basis_points")
    val devSellerFeeBasisPoints: String? = null,
    @SerializedName("discord_url")
    val discordUrl: String? = null,
    @SerializedName("display_data")
    val displayData: DisplayData? = null,
    @SerializedName("external_url")
    val externalUrl: String? = null,
    @SerializedName("featured")
    val featured: Boolean? = null,
    @SerializedName("featured_image_url")
    val featuredImageUrl: String? = null,
    @SerializedName("hidden")
    val hidden: Boolean? = null,
    @SerializedName("image_url")
    val imageUrl: String? = null,
    @SerializedName("instagram_username")
    val instagramUsername: String? = null,
    @SerializedName("is_nsfw")
    val isNsfw: Boolean? = null,
    @SerializedName("is_subject_to_whitelist")
    val isSubjectToWhitelist: Boolean? = null,
    @SerializedName("large_image_url")
    val largeImageUrl: String? = null,
    @SerializedName("medium_username")
    val mediumUsername: String? = null,
    @SerializedName("name")
    val name: String? = null,
    @SerializedName("only_proxied_transfers")
    val onlyProxiedTransfers: Boolean? = null,
    @SerializedName("opensea_buyer_fee_basis_points")
    val openseaBuyerFeeBasisPoints: String? = null,
    @SerializedName("opensea_seller_fee_basis_points")
    val openseaSellerFeeBasisPoints: String? = null,
    @SerializedName("payout_address")
    val payoutAddress: String? = null,
    @SerializedName("require_email")
    val requireEmail: Boolean? = null,
    @SerializedName("safelist_request_status")
    val safelistRequestStatus: String? = null,
    @SerializedName("short_description")
    val shortDescription: Any? = null,
    @SerializedName("slug")
    val slug: String? = null,
    @SerializedName("telegram_url")
    val telegramUrl: Any? = null,
    @SerializedName("twitter_username")
    val twitterUsername: String? = null,
    @SerializedName("wiki_url")
    val wikiUrl: Any? = null
)