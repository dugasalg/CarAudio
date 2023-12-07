package com.example.caraudio.product
    import androidx.compose.foundation.Image
    import androidx.compose.foundation.background
    import androidx.compose.foundation.layout.*
    import androidx.compose.foundation.shape.RoundedCornerShape
    import androidx.compose.material.*
    import androidx.compose.runtime.Composable
    import androidx.compose.runtime.LaunchedEffect
    import androidx.compose.runtime.getValue
    import androidx.compose.runtime.livedata.observeAsState
    import androidx.compose.ui.Alignment
    import androidx.compose.ui.Modifier
    import androidx.compose.ui.draw.clip
    import androidx.compose.ui.graphics.Color
    import androidx.compose.ui.layout.ContentScale
    import androidx.compose.ui.res.painterResource
    import androidx.compose.ui.text.font.FontWeight
    import androidx.compose.ui.tooling.preview.Preview
    import androidx.compose.ui.unit.dp
    import androidx.compose.ui.unit.sp
    import androidx.lifecycle.viewmodel.compose.viewModel
    import androidx.navigation.NavController
    import androidx.navigation.compose.rememberNavController
    import coil.compose.rememberImagePainter
    import com.example.caraudio.R
    import com.example.caraudio.home.viewModel.ProductsViewModel

@Composable
fun ProductDetailsScreen(navController: NavController, productId: String, product: String, price: Double, image: String, rating: Double, brand: String) {
    // Obtiene una instancia del ViewModel
    val viewModel: ProductsViewModel = viewModel()
    // Observa los cambios en los detalles del producto
    val productDetails by viewModel.productDetails.observeAsState()

    LaunchedEffect(productId) {
        viewModel.fetchProductDetails(productId)
    }

    Scaffold(
        bottomBar = {
            BottomAppBar(
                contentPadding = PaddingValues(16.dp),
                backgroundColor = Color.Black
            ) {
                Button(
                    onClick = {
                        // Acción de agregar al carrito
                    },
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(56.dp)
                        .padding(horizontal = 16.dp),
                    colors = ButtonDefaults.buttonColors(
                        backgroundColor = Color.Black,
                        contentColor = Color.White
                    )
                ) {
                    Text("Add to cart  ", fontSize = 20.sp)
                    Icon(
                        modifier = Modifier
                            .size(24.dp)
                            .align(Alignment.CenterVertically),
                        painter = painterResource(id = R.drawable.vector),
                        contentDescription = "Cart Icon"
                    )
                }
            }
        }
    ) { innerPadding ->
        Column(
            modifier = Modifier
                .padding(innerPadding)
                .fillMaxSize()
        ) {
            productDetails?.let { product ->
                Spacer(modifier = Modifier.height(30.dp))

                // Cargando la imagen del producto usando rememberImagePainter
                val image = rememberImagePainter(image)
                Image(
                    painter = image,
                    contentDescription = "Product Image",
                    contentScale = ContentScale.Fit,
                    modifier = Modifier
                        .height(240.dp)
                        .fillMaxWidth()
                        .clip(RoundedCornerShape(8.dp))
                )
                Spacer(modifier = Modifier.height(10.dp))

                Box(
                    modifier = Modifier
                        .padding(16.dp)
                        .background(
                            color = Color(android.graphics.Color.parseColor("#F2F2F4")),
                            shape = RoundedCornerShape(16.dp)
                        )
                        .padding(16.dp)
                        .fillMaxWidth()
                        .weight(1f)
                ) {
                    Column(
                        modifier = Modifier.fillMaxWidth()
                    ) {
                        // Nombre del producto
                        Text(
                            text = product.product,
                            fontSize = 26.sp,
                            fontWeight = FontWeight.Bold,
                            modifier = Modifier.padding(4.dp)
                        )

                        // Marca del producto
                        Text(
                            text = "by ${product.brand}",
                            fontSize = 19.sp,
                            modifier = Modifier.padding(4.dp)
                        )

                        // Calificación del producto
                        Text(
                            text = "${product.rating} reviews)",
                            fontSize = 19.sp,
                            modifier = Modifier.padding(4.dp)
                        )

                        Spacer(modifier = Modifier.height(16.dp))

                        // Descripción del producto
                        Text(
                            text = product.description,
                            fontSize = 19.sp,
                            modifier = Modifier.padding(4.dp)
                        )
                    }
                }
            }
        }
    }
}

@Preview
@Composable
fun ProductDetailsScreenPreview() {
    ProductDetailsScreen(
        navController = rememberNavController(),
        productId = "6563d9929a6e4719531b8cd2",
        product = "Product Name",
        price = 100.0,
        image = "https://picsum.photos/200/300",
        rating = 4.5,
        brand = "Brand Name"
    )
}




