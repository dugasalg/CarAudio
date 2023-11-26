package com.example.caraudio.product
    import androidx.compose.foundation.Image
    import androidx.compose.foundation.layout.*
    import androidx.compose.material.*
    import androidx.compose.runtime.Composable
    import androidx.compose.ui.Alignment
    import androidx.compose.ui.Modifier
    import androidx.compose.ui.res.painterResource
    import androidx.compose.ui.text.font.FontWeight
    import androidx.compose.ui.tooling.preview.Preview
    import androidx.compose.ui.unit.dp
    import androidx.compose.ui.unit.sp
    import androidx.navigation.NavController
    import androidx.navigation.compose.rememberNavController
    import com.example.caraudio.R

@Composable
    fun ProductDetailsScreen(navController: NavController) {
        Column(modifier = Modifier.padding(16.dp)) {
            // Imagen del producto (reemplaza R.drawable.product_image con tu imagen de recurso)
            Image(
                painter = painterResource(id = R.drawable.jlamp),
                contentDescription = "Product Image",
                modifier = Modifier
                    .fillMaxWidth()
                    .height(240.dp)
            )

            Spacer(modifier = Modifier.height(16.dp))

            // Nombre del producto
            Text(
                text = "VX400/4i",
                fontSize = 24.sp,
                fontWeight = FontWeight.Bold
            )

            // Marca del producto
            Text(
                text = "by JLAudio",
                fontSize = 16.sp
            )

            // Calificación del producto
            Text(
                text = "4.8 (1390 reviews)",
                fontSize = 16.sp
            )

            Spacer(modifier = Modifier.height(16.dp))

            // Título de la descripción del producto
            Text(
                text = "Product Description",
                fontSize = 18.sp,
                fontWeight = FontWeight.Bold
            )

            // Descripción del producto
            Text(
                text = "4-Channel Class D Full-Range Amplifier with Integrated DSP, 100 W x 4 @ 2 Ω / 75 W x 4 @ 4 Ω - 14.4V",
                fontSize = 16.sp
            )

            Spacer(modifier = Modifier.height(24.dp))

            // Botón para agregar al carrito
            Button(
                onClick = {
                    // Acción de agregar al carrito
                },
                modifier = Modifier.fillMaxWidth()
            ) {
                Text("Add to cart  ")
                // Icono del carrito (reemplaza R.drawable.ic_shopping_cart con tu icono de recurso)
                Icon(
                    modifier = Modifier
                        .size(18.dp)
                        .align(Alignment.CenterVertically),
                    painter = painterResource(id = R.drawable.vector),
                    contentDescription = "Cart Icon"
                )
            }
        }
    }

    @Preview(showBackground = true)
    @Composable
    fun ProductDetailsScreenPreview() {
        ProductDetailsScreen(navController = rememberNavController())
    }

