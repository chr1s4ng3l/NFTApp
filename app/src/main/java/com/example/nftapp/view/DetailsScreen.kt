package com.example.nftapp.view

import androidx.compose.foundation.layout.*
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.example.nftapp.R
import com.example.nftapp.viewmodel.NftViewModel


@Composable
fun MyDetails(nftViewModel: NftViewModel) {
    val asset = nftViewModel.selectedAsset

    Column(
        Modifier
            .fillMaxSize()
    ) {

        AsyncImage(
            model = ImageRequest.Builder(LocalContext.current)
                .data(asset?.image_preview_url)
                .crossfade(true)
                .build(),
            placeholder = painterResource(id = R.drawable.nft),
            contentScale = ContentScale.FillBounds,
            contentDescription = "ImageDetails",
            modifier = Modifier
                .fillMaxWidth()
                .height(300.dp)
        )


        Column(Modifier.padding(10.dp)) {
            Text(
                text = asset?.name ?: "Name no available",
                fontSize = 25.sp,
                textDecoration = TextDecoration.Underline,
                fontWeight = FontWeight.ExtraBold
            )


            Text(
                text = asset?.collection?.description ?: "Description no available",
                fontSize = 20.sp,
                fontWeight = FontWeight.Light
            )


        }


    }
}
