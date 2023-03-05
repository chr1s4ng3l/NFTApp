package com.example.nftapp.rest

import com.example.nftapp.model.AssetResponse
import com.example.nftapp.model.CollectionsResponse
import com.example.nftapp.rest.NFTApi.Companion.COLLECTION_PATH
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface NFTApi {


    @GET(ASSET_PATH)
    suspend fun getAssets(
        @Query("collection_slug") collection_slug: String = "clonex",
        @Query("order_direction") order_direction: String = "desc",
        @Query("limit") limit: Int = 200,
        @Query("include_orders") include_orders: Boolean = false,
    ): Response<AssetResponse>


    @GET(COLLECTION_PATH)
    suspend fun getCollections(
          //@Query("asset_owner") asset_owner: String = "0xb47e3cd837ddf8e4c57f05d70ab865de6e193bbb",
         // @Query("offset") offset: Int = 1,
          @Query("limit") limit: Int = 300
    ): Response<CollectionsResponse>

    companion object {

        //https://opensea13.p.rapidapi.com/collection/
        //collections?offset=0&limit=300"


        //https://opensea13.p.rapidapi.com/
        //assets?collection_slug=cryptopunks
        //&order_direction=desc
        // &limit=20
        // &include_orders=false
        const val BASE_URL = "https://opensea13.p.rapidapi.com/"
        private const val ASSET_PATH = "assets"
        private const val COLLECTION_PATH = "collections"
    }
}