package com.example.nftapp.rest

import com.example.nftapp.model.AssetResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface NFTApi {


    @GET(PATH)
    suspend fun getAssets(
        @Query("collection_slug") collection_slug: String = "cryptopunks",
        @Query("order_direction") order_direction: String = "desc",
        @Query("limit") limit: Int = 200,
        @Query("include_orders") include_orders: Boolean = false,
        ): Response<AssetResponse>


    companion object {



        //https://opensea13.p.rapidapi.com/assets?collection_slug=doodles-official&order_direction=desc&limit=20&include_orders=false
        //https://opensea13.p.rapidapi.com/
        //assets?collection_slug=cryptopunks
        //&order_direction=desc
        // &limit=20
        // &include_orders=false
         const val BASE_URL = "https://opensea13.p.rapidapi.com/"
        private const val PATH = "assets"
    }
}