package com.example.nftapp.view

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.itemsIndexed
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
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
import com.example.nftapp.model.domain.CollectionDomain
import com.example.nftapp.utils.UIState
import com.example.nftapp.viewmodel.NftViewModel


@Composable
fun CollectionScreen(nftViewModel: NftViewModel, navController: NavController) {
    when (val state = nftViewModel.collection.observeAsState(UIState.LOADING).value) {
        is UIState.LOADING -> {}
        is UIState.SUCCESS -> {
            CollectiontList(state.response, navController) {
                nftViewModel.selectedCollection = it
            }
        }
        is UIState.ERROR -> {}
    }
}

@Composable
fun CollectiontList(
    collections: List<CollectionDomain>,
    navController: NavController? = null,
    selectedCollection: ((CollectionDomain) -> Unit)? = null

) {

    Column(Modifier.background(color = Color.Black)) {
        LazyColumn {
            itemsIndexed(items = collections) { index, collection ->
                CollectionItem(collection = collection, navController, selectedCollection)
            }
        }
    }


}

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun CollectionItem(
    collection: CollectionDomain,
    navController: NavController? = null,
    selectedCollection: ((CollectionDomain) -> Unit)? = null

) {

    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 7.dp, vertical = 7.dp),
        elevation = 10.dp,
        backgroundColor = Color(0xFF232325),
        shape = RoundedCornerShape(corner = CornerSize(16.dp)),
        onClick = {
            selectedCollection?.invoke(collection)
            navController?.navigate("assets")
        },
    ) {
        Row(modifier = Modifier.fillMaxWidth().padding(5.dp)) {
            AsyncImage(
                model = ImageRequest.Builder(LocalContext.current)
                    .data(collection.imageUrl)
                    .crossfade(true)
                    .build(),
                placeholder = painterResource(R.drawable.loading_image),
                contentDescription = stringResource(R.string.app_name),
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .size(80.dp)
                    .clip(RoundedCornerShape(10.dp))

            )

            Text(
                text = collection.name,
                fontWeight = FontWeight.ExtraBold,
                color = Color.White,
                fontSize = 15.sp,
                textAlign = TextAlign.Center, modifier = Modifier.padding(top = 15.dp, start = 10.dp)
            )


        }


    }


}