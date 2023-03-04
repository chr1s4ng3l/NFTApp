package com.example.nftapp.model.domain

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.nftapp.model.Collection

@Entity(tableName = "collections")
data class CollectionDomain(

    @PrimaryKey
    val slug: String,
    val imageUrl: String,
    val name: String,


)

fun List<Collection>?.mapToDomainCollections(): List<CollectionDomain> =
    this?.map {
        CollectionDomain(
            slug = it.slug ?: "Slug no available",
            imageUrl = it.imageUrl ?: "Slug no available",
            name = it.name ?: "Slug no available",
        )
    }?: emptyList()
