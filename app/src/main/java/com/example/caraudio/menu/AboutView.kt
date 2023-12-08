package com.example.caraudio.menu

import android.webkit.WebViewClient
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.ClickableText
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.caraudio.home.view.BottomNavBar
import com.google.accompanist.web.WebView
import com.google.accompanist.web.rememberWebViewState

@Composable
fun AboutScreen(navController: NavController) {
    var selectedProfileUrl by remember { mutableStateOf<String?>(null) }

    Scaffold(
        bottomBar = { BottomNavBar(navController, Modifier) }
    ) { innerPadding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
                .padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text("Proyecto CarAudio Store", fontSize = 24.sp, color = MaterialTheme.colors.onBackground)
            Spacer(modifier = Modifier.height(16.dp))
            Text("Descubre la elegancia del sonido con nuestra aplicación de tienda en línea para equipos de audio de carros. Con un diseño minimalista y fácil navegación, ofrecemos una selección exclusiva de equipos de alta calidad para mejorar tu experiencia auditiva al volante. Explora, selecciona y compra con facilidad, todo en un solo lugar.", fontSize = 16.sp)
            Spacer(modifier = Modifier.height(16.dp))
            Text("Programación de dispositivos móviles", fontSize = 16.sp)
            Spacer(modifier = Modifier.height(16.dp))
            Text("Equipo:", fontSize = 20.sp)
            MemberInfo("Diego Salgado", "https://github.com/dugasalg") {
                selectedProfileUrl = it
            }
            MemberInfo("Sebastian Balderrama", "https://github.com/sebasba9") {
                selectedProfileUrl = it
            }

            Spacer(modifier = Modifier.height(20.dp))

            selectedProfileUrl?.let { url ->
                val webViewState = rememberWebViewState(url)
                WebView(
                    state = webViewState,
                    modifier = Modifier
                        .weight(1f)
                        .fillMaxWidth(),
                    onCreated = { webView ->
                        webView.webViewClient = WebViewClient()
                    }
                )
            }
        }
    }
}

@Composable
fun MemberInfo(name: String, githubUrl: String, onProfileSelected: (String) -> Unit) {
    val context = LocalContext.current
    val annotatedString = buildAnnotatedString {
        append(name)
        withStyle(style = SpanStyle(color = Color.Blue)) {
            append(" (Github)")
        }
    }
    ClickableText(
        text = annotatedString,
        onClick = {
            onProfileSelected(githubUrl)
        }
    )

}


@Preview
        @Composable
        fun AboutScreenPreview() {
            val navController = rememberNavController()
            AboutScreen(navController)
        }
