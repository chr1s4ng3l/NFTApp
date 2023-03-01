package com.example.nftapp.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.nftapp.model.Asset
import com.example.nftapp.model.domain.AssetsDomain
import com.example.nftapp.rest.NftRepository
import com.example.nftapp.rest.NftRepositoryImp
import com.example.nftapp.utils.UIState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel
class NftViewModel @Inject constructor(private val nftRepository: NftRepositoryImp) : ViewModel() {

    var selectedAsset: AssetsDomain? = null

    private val _asset: MutableStateFlow<UIState<List<AssetsDomain>>> =
        MutableStateFlow(UIState.LOADING)
    val asset: StateFlow<UIState<List<AssetsDomain>>> get() = _asset


    init {
        getAsset()

    }

    private fun getAsset() {
        viewModelScope.launch {
            nftRepository.getAssets().collect(){
                _asset.value = it
            }
        }
    }
}