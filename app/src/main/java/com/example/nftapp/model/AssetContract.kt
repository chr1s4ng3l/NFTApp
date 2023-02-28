package com.example.nftapp.model


import com.google.gson.annotations.SerializedName

data class AssetContract(
    @SerializedName("address")
    val address: String? = null,
    @SerializedName("asset_contract_type")
    val assetContractType: String? = null,
    @SerializedName("buyer_fee_basis_points")
    val buyerFeeBasisPoints: Int? = null,
    @SerializedName("created_date")
    val createdDate: String? = null,
    @SerializedName("default_to_fiat")
    val defaultToFiat: Boolean? = null,
    @SerializedName("description")
    val description: String? = null,
    @SerializedName("dev_buyer_fee_basis_points")
    val devBuyerFeeBasisPoints: Int? = null,
    @SerializedName("dev_seller_fee_basis_points")
    val devSellerFeeBasisPoints: Int? = null,
    @SerializedName("external_link")
    val externalLink: String? = null,
    @SerializedName("image_url")
    val imageUrl: String? = null,
    @SerializedName("name")
    val name: String? = null,
    @SerializedName("nft_version")
    val nftVersion: String? = null,
    @SerializedName("only_proxied_transfers")
    val onlyProxiedTransfers: Boolean? = null,
    @SerializedName("opensea_buyer_fee_basis_points")
    val openseaBuyerFeeBasisPoints: Int? = null,
    @SerializedName("opensea_seller_fee_basis_points")
    val openseaSellerFeeBasisPoints: Int? = null,
    @SerializedName("opensea_version")
    val openseaVersion: String? = null,
    @SerializedName("owner")
    val owner: Int? = null,
    @SerializedName("payout_address")
    val payoutAddress: String? = null,
    @SerializedName("schema_name")
    val schemaName: String? = null,
    @SerializedName("seller_fee_basis_points")
    val sellerFeeBasisPoints: Int? = null,
    @SerializedName("symbol")
    val symbol: String? = null,
    @SerializedName("total_supply")
    val totalSupply: String? = null
)