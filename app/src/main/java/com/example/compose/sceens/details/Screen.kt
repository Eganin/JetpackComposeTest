package com.example.compose.sceens.details

import android.media.Rating
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Color.Companion.Gray
import androidx.compose.ui.graphics.Color.Companion.White
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.compose.sceens.base.DarkColors


@Preview
@Composable
fun ComposePreview(){
    MaterialTheme(
        colors = DarkColors
    ){
        ProductScreen()
    }
}

@Composable
fun ProductScreen(productViewModel: ProductViewModel = viewModel(ProductViewModel::class.java)){
    val name by productViewModel.name.observeAsState()

    LazyColumn(content = {
        item{ Text("Name is -> $name") }
        item{
            Button(
                onClick = {
                    productViewModel.setName("New name")
                }, modifier = Modifier.padding(16.dp)
            ){
                Text("Click to change name")
            }
        }
    })
}