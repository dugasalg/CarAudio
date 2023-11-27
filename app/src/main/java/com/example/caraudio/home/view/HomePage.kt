package com.example.caraudio.home.view

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.caraudio.R
import com.example.caraudio.home.viewModel.ProductsViewModel

@Composable
fun HomePage(navController: NavController, viewModel: ProductsViewModel) {
    viewModel.fetchProducts()
    val products by viewModel.products.observeAsState(emptyList())
    Column(
        modifier = Modifier
            .fillMaxHeight()
            .padding(16.dp)
    ) {
        SearchBar()
        Spacer(modifier = Modifier.height(16.dp))
        Text(
            text = stringResource(id = R.string.Amplifiers),
            fontSize = 30.sp,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.fillMaxWidth()
        )
        Spacer(modifier = Modifier.height(5.dp))
        LazyRow {
            items(products) { product ->
                Spacer(modifier = Modifier.width(8.dp))
                ProductCard(product.product, product.price, product.image)
            }
        }
    }
        BottomNavBar(navController = navController, modifier = Modifier)
}

@Composable
fun SearchBar() {
    var text by remember { mutableStateOf("") }
    TextField(
        value = text,
        onValueChange = { text = it },
        label = {  Text(stringResource(id = R.string.search)) },
        modifier = Modifier.fillMaxWidth(),
        colors = TextFieldDefaults.colors(
            unfocusedIndicatorColor = Color.Transparent,
            focusedIndicatorColor = Color.Transparent,
            cursorColor = Color.Transparent,
        )
    )
}

@Preview
@Composable
fun PreviewHomePage() {
    HomePage(navController = NavController(LocalContext.current), viewModel = ProductsViewModel())
}





