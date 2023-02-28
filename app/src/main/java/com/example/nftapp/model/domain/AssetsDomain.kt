package com.example.nftapp.model.domain

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.nftapp.model.Asset
import com.example.nftapp.model.Collection

@Entity(tableName = "assets")
data class AssetsDomain(
    @PrimaryKey
    val id: Int,
    val tokenId: String,
    val image_preview_url: String,
    val image_thumbnail_url: String,
    val name: String,
    val description: String,
    val collection: com.example.nftapp.model.Collection,


    )

fun List<Asset>?.mapToDomainAssets(): List<AssetsDomain> =
    this?.map {
        AssetsDomain(
            id = it.id ?: 0,
            tokenId = it.tokenId ?: "Token Id no available",
            image_preview_url = it.imagePreviewUrl ?: "",
            image_thumbnail_url = it.imageThumbnailUrl ?: "",
            name = it.name ?: "Name not available",
            description = it.description ?: "Description not available",
            collection = it.collection ?: Collection(
                bannerImageUrl = "Image not available",
                description = "Description not available", createdDate = "Date not available"
            )

        )
    } ?: emptyList()
