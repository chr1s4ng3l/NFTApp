package com.example.nftapp.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.nftapp.model.domain.AssetsDomain
import com.example.nftapp.model.domain.CollectionDomain
import com.example.nftapp.rest.NftRepositoryImp
import com.example.nftapp.utils.UIState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class NftViewModel @Inject constructor(private val nftRepository: NftRepositoryImp) : ViewModel() {

    var selectedAsset: AssetsDomain? = null
    var selectedCollection: CollectionDomain? = null

    private val _asset: MutableLiveData<UIState<List<AssetsDomain>>> =
        MutableLiveData(UIState.LOADING)
    val asset: LiveData<UIState<List<AssetsDomain>>> get() = _asset

    private val _collection: MutableLiveData<UIState<List<CollectionDomain>>> =
        MutableLiveData(UIState.LOADING)
    val collection: LiveData<UIState<List<CollectionDomain>>> get() = _collection

    var isLoading = MutableLiveData<Boolean>()


    init {
        getAsset()
        getCollection()

    }

    val slug = selectedCollection?.slug

     fun getAsset() {
            viewModelScope.launch {
                nftRepository.getAssets().collect() {
                    _asset.value = it

                }
        }


    }


    private fun getCollection() {
        viewModelScope.launch {
            nftRepository.getCollections().collect() {
                _collection.value = it
            }
        }
    }
}