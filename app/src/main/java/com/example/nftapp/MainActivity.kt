package com.example.nftapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.nftapp.model.Collection
import com.example.nftapp.model.domain.AssetsDomain
import com.example.nftapp.ui.theme.NFTAppTheme
import com.example.nftapp.utils.UIState
import com.example.nftapp.view.AssetItem
import com.example.nftapp.view.AssetList
import com.example.nftapp.viewmodel.NftViewModel

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            NFTAppTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {

                    //val nftViewModel: NftViewModel = hiltViewModel()
                    
                   // MainScreen(nftViewModel = nftViewModel)
                }
            }
        }
    }
}

@Composable
fun MainScreen(nftViewModel: NftViewModel) {
    when(val state = nftViewModel.asset.collectAsState(UIState.LOADING).value) {
        is UIState.LOADING -> {}
        is UIState.SUCCESS -> {
            AssetList(state.response) {
                nftViewModel.selectedAsset = it

            }
        }
        is UIState.ERROR -> {}
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    NFTAppTheme {
        AssetItem(
            asset = AssetsDomain(
                name = "Christopher",
                description = "",
                image_thumbnail_url = "",
                image_preview_url = "",
                id = 0,
                tokenId = "",
                collection = Collection(description = "")
            )
        )

    }
}