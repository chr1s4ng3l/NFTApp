package com.example.nftapp.rest

import android.util.Log
import com.example.nftapp.model.domain.AssetsDomain
import com.example.nftapp.model.domain.CollectionDomain
import com.example.nftapp.model.domain.mapToDomainAssets
import com.example.nftapp.model.domain.mapToDomainCollections
import com.example.nftapp.utils.FailureResponse
import com.example.nftapp.utils.NullAssetsResponse
import com.example.nftapp.utils.UIState
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import javax.inject.Inject


private const val TAG = "NftRepository"

interface NftRepository {
    suspend fun getAssets(): Flow<UIState<List<AssetsDomain>>>
    suspend fun getCollections(): Flow<UIState<List<CollectionDomain>>>
}

class NftRepositoryImp @Inject constructor(
    private val nftApi: NFTApi, private val ioDispatcher: CoroutineDispatcher = Dispatchers.IO
) : NftRepository {
    override suspend fun getAssets(): Flow<UIState<List<AssetsDomain>>> = flow {
        emit(UIState.LOADING)

        try {
            val response = nftApi.getAssets()
            if (response.isSuccessful) {
                response.body()?.let {
                    Log.d(TAG, "Response -> $response")
                    Log.d(TAG, "Response Body -> ${it}")
                    emit(UIState.SUCCESS(it.assets.mapToDomainAssets()))

                } ?: throw NullAssetsResponse()
            } else throw FailureResponse(response.errorBody().toString())


        } catch (e: Exception) {
            emit(UIState.ERROR(e))
        }

    }.flowOn(ioDispatcher)


    override suspend fun getCollections(): Flow<UIState<List<CollectionDomain>>> =
        flow<UIState<List<CollectionDomain>>> {
            emit(UIState.LOADING)

            try {
                val response = nftApi.getCollections()
                if (response.isSuccessful) {
                    response.body()?.let {

                        emit(UIState.SUCCESS(it.collections.mapToDomainCollections()))
                        Log.d(TAG, "getCollections: $response")
                        Log.d(TAG, "getCollections: $response")
                    } ?: throw NullAssetsResponse()

                } else throw FailureResponse(response.errorBody().toString())


            } catch (e: Exception) {
                emit(UIState.ERROR(e))
            }

        }.flowOn(ioDispatcher)

}