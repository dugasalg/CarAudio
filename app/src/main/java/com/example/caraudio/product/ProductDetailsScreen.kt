package com.example.caraudio.product

import android.util.Log
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
import androidx.compose.ui.window.Dialog
import androidx.compose.ui.window.DialogProperties
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import coil.compose.rememberImagePainter
import com.example.caraudio.R
import com.example.caraudio.home.viewModel.ProductsViewModel

@Composable
fun ProductDetailsScreen(
    productId: String,
    product: String,
    price: Double,
    image: String,
    rating: Double,
    onDismiss: () -> Unit
) {
    // Obtiene una instancia del ViewModel
    val viewModel: ProductsViewModel = viewModel()
    // Observa los cambios en los detalles del producto
    val productDetails by viewModel.productDetails.observeAsState()


    /*
    LaunchedEffect(productId) {
        viewModel.fetchProductDetails(productId)
    }
     */


    Dialog(
        onDismissRequest = { onDismiss() },
        properties = DialogProperties(dismissOnBackPress = true, dismissOnClickOutside = true)
    ) {
        Box(
            modifier = Modifier
                .height(400.dp)
                .padding(top = 100.dp)
                .background(Color.White)
                .clip(shape = MaterialTheme.shapes.small)
        ) {
            Column {
                val image = rememberImagePainter(image)
                Image(
                    painter = image,
                    contentDescription = null,
                    contentScale = ContentScale.Fit,
                    modifier = Modifier
                        .height(120.dp)
                        .fillMaxWidth()
                        .clip(RoundedCornerShape(8.dp))
                )

                Spacer(modifier = Modifier.height(16.dp))
                Text(text = product)
                Text(text = productId)
                Text(text = price.toString())
                BottomAppBar(
                    contentPadding = PaddingValues(16.dp),
                    backgroundColor = Color.Black
                ) {
                    Button(
                        onClick = {
                            // Acción de agregar al carrito // post para agregar al carrito
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

        }
    }
 }


@Preview
@Composable
fun ProductDetailsScreenPreview() {
    ProductDetailsScreen(
        productId = "6563d9929a6e4719531b8cd2",
        product = "Product Name",
        price = 100.0,
        image = "https://picsum.photos/200/300",
        rating = 4.5,
        onDismiss = {}
    )
}




