package com.example.caraudio.splashScreen

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
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

@Composable
fun SplashView(navController: NavController) {
    // Fondo de pantalla completo con el logo de la aplicación en el centro

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Black),
        contentAlignment = Alignment.Center
    ) {
        // Reemplaza esto con tu logo o imagen de splash
        Image(
            painter = painterResource(id = R.drawable.icon),
            contentDescription = "Logo",
                    modifier = Modifier
                    // Añade un corte redondo a la imagen
                    .clip(CircleShape)
                // Agrega un tamaño específico si lo deseas, por ejemplo 100.dp
                .size(200.dp)
        )
    }

    // Efecto de lado para manejar la navegación
    LaunchedEffect(Unit) {
        delay(3000) // Retraso de 3 segundos
        navController.navigate("intro") { // Navega a la pantalla principal
            popUpTo("splash") { inclusive = true } // Elimina la splash screen de la pila
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    SplashView(navController = NavController(LocalContext.current))
}