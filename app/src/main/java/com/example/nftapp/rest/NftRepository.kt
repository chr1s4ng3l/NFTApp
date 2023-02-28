package com.example.nftapp.rest

import com.example.nftapp.model.domain.AssetsDomain
import com.example.nftapp.model.domain.mapToDomainAssets
import com.example.nftapp.utils.FailureResponse
import com.example.nftapp.utils.NullAssetsResponse
import com.example.nftapp.utils.UIState
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

interface NftRepository {
    suspend fun getAssets(): Flow<UIState<List<AssetsDomain>>>
}

class NftRepositoryImp @Inject constructor(private val nftApi: NFTApi) : NftRepository {
    override suspend fun getAssets(): Flow<UIState<List<AssetsDomain>>> = flow {
        emit(UIState.LOADING)

        try {
            val response = nftApi.getAssets()
            if (response.isSuccessful) {
                response.body()?.let {


                    emit(UIState.SUCCESS(it.assets.mapToDomainAssets()))


                } ?: throw NullAssetsResponse()
            } else throw FailureResponse(response.errorBody().toString())


        } catch (e: Exception) {
            emit(UIState.ERROR(e))
        }

    }

}