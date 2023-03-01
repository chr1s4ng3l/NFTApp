package com.example.nftapp.view


import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.*
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.example.nftapp.R
import com.example.nftapp.model.domain.AssetsDomain

@Composable
fun AssetList(
    assets: List<AssetsDomain>,
    selectedAsset: (AssetsDomain) -> Unit
) {
    LazyColumn {
        itemsIndexed(items = assets) { index, asset ->
            AssetItem(asset = asset, selectedAsset)
        }
    }
}

@OptIn(ExperimentalMaterialApi::class, ExperimentalUnitApi::class, ExperimentalFoundationApi::class)
@Composable
fun AssetItem(
    asset: AssetsDomain,
    selectedAsset: ((AssetsDomain) -> Unit)? = null
) {


    Card(
        modifier = Modifier
            .padding(horizontal = 10.dp, vertical = 10.dp)
            .fillMaxWidth(),
        elevation = 10.dp,
        backgroundColor = Color.White,
        shape = RoundedCornerShape(corner = CornerSize(16.dp))
    ) {
        Row{
            AsyncImage(
                model = ImageRequest.Builder(LocalContext.current)
                    .data(asset.image_thumbnail_url)
                    .crossfade(true)
                    .build(),
                placeholder = painterResource(R.drawable.nft),
                contentDescription = stringResource(R.string.app_name),
                contentScale = ContentScale.Fit,
                modifier = Modifier.size(100.dp).clip(RoundedCornerShape(10.dp))
            )

                Text(
                    text = asset.name,
                    color = Color.Black,
                    fontSize = TextUnit(25F, TextUnitType.Sp),
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier.fillMaxWidth().padding(30.dp)

                )


        }
    }
}
