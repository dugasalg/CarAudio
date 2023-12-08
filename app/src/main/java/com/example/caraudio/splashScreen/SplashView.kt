package com.example.caraudio.splashScreen

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.caraudio.R
import kotlinx.coroutines.delay
import com.airbnb.lottie.compose.*

@Composable
fun SplashView(navController: NavController) {
    val context = LocalContext.current
    val composition by rememberLottieComposition(LottieCompositionSpec.RawRes(R.raw.soundlottie)) // Reemplaza con tu archivo Lottie
    val progress by animateLottieCompositionAsState(composition)

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Black),
        contentAlignment = Alignment.Center
    ) {
        // Usando LottieAnimation en lugar de Image
        LottieAnimation(
            composition = composition,
            progress = progress,
            modifier = Modifier.size(300.dp) // Tamaño de la animación
        )
    }

    // Efecto de lado para manejar la navegación
    LaunchedEffect(Unit) {
        delay(3000) // Retraso de 3 segundos
        navController.navigate("intro") {
            popUpTo("splash") { inclusive = true }
        }
    }
}


@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    SplashView(navController = NavController(LocalContext.current))
}