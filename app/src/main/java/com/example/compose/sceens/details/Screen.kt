package com.example.compose.sceens.details

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.compose.sceens.base.LightColors

private val brownGrayColor = Color(0xFF959595)
private val whiteTwo = Color(0xFFf9f9f9)

@ExperimentalFoundationApi
@Preview
@Composable
fun ComposePreview() {
    MaterialTheme(
        colors = LightColors
    ) {
        ProductScreen()
    }
}

@Composable
fun Subtitle5(text: String) =
    Text(
        text = text,
        style = TextStyle(color = Color.Black, fontSize = 14.sp, fontWeight = FontWeight.Normal)
    )

@Composable
fun Caption(text: String) = Text(
    text = text,
    style = TextStyle(color = brownGrayColor, fontSize = 12.sp, fontWeight = FontWeight.Normal)
)

@ExperimentalFoundationApi
@Composable
fun ProductScreen(productViewModel: ProductViewModel = viewModel(ProductViewModel::class.java)) {
    val article by productViewModel.article.observeAsState()
    val title by productViewModel.title.observeAsState()

    LazyColumn(
        content = {
            stickyHeader { Toolbar() }
            item { ImageHeader() }
            item {
                Text(
                    article.orEmpty(),
                    modifier = Modifier.padding(top = 24.dp, start = 16.dp),
                    style = TextStyle(color = brownGrayColor),
                    fontWeight = FontWeight.Normal,
                    fontSize = 12.sp
                )
            }
            item {
                Text(
                    title.orEmpty(),
                    modifier = Modifier.padding(top = 4.dp, start = 16.dp, end = 24.dp),
                    style = TextStyle(
                        color = Color.Black,
                        fontWeight = FontWeight.Medium,
                        fontSize = 20.sp
                    )
                )
            }
            item { RatingView() }
            item { PriceView(productViewModel = productViewModel) }
            item { CountView(productViewModel = productViewModel) }
            item { HeaderView(height = 60.dp, title = "Способы получения") }
            item { DeliveryPickUpView(productViewModel = productViewModel) }
        },
        modifier = Modifier.fillMaxSize()
    )
}

@Composable
fun PriceView(productViewModel: ProductViewModel) {

    val itemsInCard by productViewModel.itemsInCard.observeAsState()

    Row(
        modifier = Modifier
            .height(80.dp)
            .fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(
            "13 686,00", modifier = Modifier.padding(start = 16.dp),
            style = TextStyle(color = Color.Black, fontSize = 20.sp, fontWeight = FontWeight.Medium)
        )
        Text(
            "₽/шт.", modifier = Modifier
                .weight(1f)
                .padding(start = 4.dp),
            style = TextStyle(color = brownGrayColor, fontSize = 12.sp)
        )


        if (itemsInCard == 0) {
            Button(
                onClick = {
                    productViewModel.addToCart()
                },
                modifier = Modifier
                    .background(
                        color = MaterialTheme.colors.background,
                        shape = RoundedCornerShape(4.dp)
                    )
                    .height(48.dp)
                    .width(160.dp)
                    .padding(end = 24.dp),
            ) {
                Box(contentAlignment = Alignment.Center, modifier = Modifier.fillMaxSize()) {
                    Text(
                        "В корзину",
                        style = TextStyle(
                            color = Color.White,
                            fontWeight = FontWeight.Medium,
                            fontSize = 16.sp
                        )
                    )
                }
            }
        } else {
            Box(
                contentAlignment = Alignment.Center,
                modifier = Modifier
                    .height(48.dp)
                    .width(160.dp)
                    .padding(end = 24.dp)
            ) {
                Text("$itemsInCard")
            }
        }
    }
}

@Composable
fun DeliveryPickUpView(productViewModel: ProductViewModel) {

    val pickupStoresCount by productViewModel.pickupStoreCount.observeAsState(0)

    Row(modifier = Modifier.padding(start = 16.dp, end = 24.dp, top = 22.dp, bottom = 22.dp)) {
        Box(
            modifier = Modifier
                .background(color = whiteTwo)
                .size(24.dp)
        )

        Column() {
            Subtitle5(text = "Доставка завтра")
            Caption("На складе 112 шт")
            if (pickupStoresCount > 0) {
                Subtitle5("Самовызов сегодня")
                //Caption("Доступно в ${} магазинах")
            }
        }
    }
}

@Composable
fun CountView(productViewModel: ProductViewModel) {

    val availableCount by productViewModel.availableCount.observeAsState()

    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier
            .fillMaxWidth()
            .height(78.dp)
            .padding(start = 16.dp, end = 24.dp)
    ) {
        Box(
            Modifier
                .background(color = brownGrayColor)
                .offset(x = 16.dp)
                .size(24.dp)
        )

        Column(
            modifier = Modifier
                .weight(1f)
                .padding(start = 24.dp, end = 24.dp)
        ) {
            Text("Рассчитать количество", style = TextStyle(color = Color.Black))
            Text(
                "В наличии $availableCount",
                style = TextStyle(color = brownGrayColor, fontSize = 12.sp)
            )
        }

        Box(
            Modifier
                .background(color = brownGrayColor)
                .size(24.dp)
        )
    }
}

@Composable
fun RatingView() {
    Box(
        modifier = Modifier
            .background(color = Color.White)
            .height(52.dp)
            .fillMaxWidth()
    )
}

@Composable
fun ImageHeader() {
    Box(
        modifier = Modifier
            .background(color = Color.White)
            .height(300.dp)
            .fillMaxWidth()
    )
}

@Composable
fun Toolbar() {
    Row(
        modifier = Modifier
            .height(44.dp)
            .fillMaxWidth()
            .background(color = MaterialTheme.colors.background)
    ) {
        Text("Back", modifier = Modifier.weight(1f))
        Text("Menu")
    }
}

@Composable
fun HeaderView(height: Dp, title: String) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(height = height)
            .background(color = whiteTwo)
            .padding(start = 16.dp, bottom = 16.dp),
        contentAlignment = Alignment.BottomStart
    ) {
        Text(title, style = TextStyle(fontWeight = FontWeight.Medium, fontSize = 16.sp))
    }
}