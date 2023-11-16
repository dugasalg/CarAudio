package com.example.caraudio.biometric

import android.util.Log
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.getValue
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.Modifier
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.ui.Alignment
import com.example.caraudio.MainActivity

@Composable
fun Auth(isAuthenticatedState: MutableState<Boolean>, onAuthenticated: (Boolean) -> Unit) {
    val auth by isAuthenticatedState

    val context = LocalContext.current

    Column(
        modifier = Modifier
            .background(if (auth) Color.Green else Color.Red)
            .fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text(
            text = if (auth) "Estás Authenticado" else "Necesitas autenticarte",
            fontSize = 22.sp
        )
        Spacer(modifier = Modifier.height(8.dp))
        Button(onClick = {
            if (auth) {
                Log.d("MainActivity", "aquiii")
                isAuthenticatedState.value = false
            } else {

                (context as MainActivity).authenticate { isAuthenticated ->
                    onAuthenticated(isAuthenticated)
                }
            }
        }) {
            Text(text = if (auth) "Cerrar Sesión" else "Autenticar")
        }
    }
}