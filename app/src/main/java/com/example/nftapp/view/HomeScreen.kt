package com.example.nftapp.view


import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.itemsIndexed
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.*
import androidx.navigation.NavController
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.example.nftapp.R
import com.example.nftapp.model.domain.AssetsDomain
import com.example.nftapp.utils.UIState
import com.example.nftapp.viewmodel.NftViewModel


@Composable
fun AssetsScreen(nftViewModel: NftViewModel, navController: NavController) {
    when (val state = nftViewModel.asset.observeAsState(UIState.LOADING).value) {
        is UIState.LOADING -> {}
        is UIState.SUCCESS -> {
            AssetList(state.response, navController){
                nftViewModel.selectedAsset = it
            }
        }
        is UIState.ERROR -> {}
    }
}

@Composable
fun AssetList(
    assets: List<AssetsDomain>,
    navController: NavController? = null,
    selectedAsset: ((AssetsDomain) -> Unit)? = null

) {

    Column(Modifier.background(color = Color.Black)) {
        LazyVerticalGrid(columns = GridCells.Fixed(2), content = {
            itemsIndexed(items = assets) { index, asset ->
                AssetItem(asset = asset, navController, selectedAsset)
            }
        })
    }


}

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun AssetItem(
    asset: AssetsDomain,
    navController: NavController? = null,
    selectedAsset: ((AssetsDomain) -> Unit)? = null

) {


    Column(
        modifier = Modifier
            .padding(horizontal = 5.dp, vertical = 5.dp)
            .background(
                Color(0xFF232325),
                shape = RoundedCornerShape(corner = CornerSize(16.dp))
            )
    ) {
        Card(
            modifier = Modifier
                .padding(horizontal = 7.dp, vertical = 7.dp),
            elevation = 10.dp,
            backgroundColor = Color(0xFF232325),
            shape = RoundedCornerShape(corner = CornerSize(16.dp)),
            onClick = {
                selectedAsset?.invoke(asset)
                navController?.navigate("details")
            }
        ) {


            AsyncImage(
                model = ImageRequest.Builder(LocalContext.current)
                    .data(asset.image_thumbnail_url)
                    .crossfade(true)
                    .build(),
                placeholder = painterResource(R.drawable.loading_image),
                contentDescription = stringResource(R.string.app_name),
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .fillMaxSize()
                    .clip(RoundedCornerShape(10.dp))

            )


        }
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 10.dp, vertical = 5.dp)
        ) {
            Text(
                text = asset.name,
                fontWeight = FontWeight.ExtraBold,
                color = Color.White,
                fontSize = 18.sp,
                textAlign = TextAlign.End
            )
        }

    }

}
