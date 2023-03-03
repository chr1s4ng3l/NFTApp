package com.example.nftapp

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.nftapp.model.Collection
import com.example.nftapp.model.domain.AssetsDomain
import com.example.nftapp.ui.theme.NFTAppTheme
import com.example.nftapp.view.AssetList
import com.example.nftapp.view.AssetsScreen
import com.example.nftapp.view.MyDetails
import com.example.nftapp.viewmodel.NftViewModel
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    @SuppressLint("SuspiciousIndentation")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            NFTAppTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    val navController = rememberNavController()
                    val nftViewModel: NftViewModel = hiltViewModel()
                    NavHost(navController = navController, startDestination = "main") {
                        composable("main") {
                            AssetsScreen(nftViewModel = nftViewModel, navController)

                        }
                        composable("details") {
                            MyDetails(nftViewModel = nftViewModel)
                        }
                    }


                }
            }
        }
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun DefaultPreview() {
    NFTAppTheme {
        AssetList(
            assets = listOf(
                AssetsDomain(
                    name = "Hola",
                    description = "",
                    image_thumbnail_url = "",
                    image_preview_url = "",
                    id = 0,
                    tokenId = "",
                    collection = Collection(description = "")
                ),

                AssetsDomain(
                    name = "sdffg",
                    description = "",
                    image_thumbnail_url = "",
                    image_preview_url = "",
                    id = 0,
                    tokenId = "",
                    collection = Collection(description = "")
                ),

                AssetsDomain(
                    name = "fghjhg",
                    description = "",
                    image_thumbnail_url = "",
                    image_preview_url = "",
                    id = 0,
                    tokenId = "",
                    collection = Collection(description = "")
                ),

                AssetsDomain(
                    name = "fghj",
                    description = "",
                    image_thumbnail_url = "",
                    image_preview_url = "",
                    id = 0,
                    tokenId = "",
                    collection = Collection(description = "")
                ),
                AssetsDomain(
                    name = "",
                    description = "",
                    image_thumbnail_url = "",
                    image_preview_url = "",
                    id = 0,
                    tokenId = "",
                    collection = Collection(description = "")
                ),
                AssetsDomain(
                    name = "",
                    description = "",
                    image_thumbnail_url = "",
                    image_preview_url = "",
                    id = 0,
                    tokenId = "",
                    collection = Collection(description = "")
                ),
                AssetsDomain(
                    name = "",
                    description = "",
                    image_thumbnail_url = "",
                    image_preview_url = "",
                    id = 0,
                    tokenId = "",
                    collection = Collection(description = "")
                ),
                AssetsDomain(
                    name = "",
                    description = "",
                    image_thumbnail_url = "",
                    image_preview_url = "",
                    id = 0,
                    tokenId = "",
                    collection = Collection(description = "")
                ),
                AssetsDomain(
                    name = "",
                    description = "",
                    image_thumbnail_url = "",
                    image_preview_url = "",
                    id = 0,
                    tokenId = "",
                    collection = Collection(description = "")
                )


            )
        )

    }
}