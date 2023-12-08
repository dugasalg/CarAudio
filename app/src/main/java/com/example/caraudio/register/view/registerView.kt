
package com.example.caraudio.register.view

import android.util.Log
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.caraudio.R
import com.example.caraudio.intropage.Model.LoginDataBody
import com.example.caraudio.navigation.NavRoutes
import com.example.caraudio.register.model.RegisterDataBody
import com.example.caraudio.register.viewModel.RegisterViewModel
import java.util.*

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun RegisterScreen(NavController: NavController, viewModel: RegisterViewModel) {

    var password by remember { mutableStateOf("") }
    var userName by remember { mutableStateOf("") }
    var birthDate by remember { mutableStateOf("") }
    var address by remember { mutableStateOf("") }
    val isRegisterSuccessful by viewModel.isRegisterSuccessful.observeAsState()
    var showErrorDialog by remember { mutableStateOf(false) }
    val registerAttempted by viewModel.registerAttempted.observeAsState()

    LaunchedEffect(isRegisterSuccessful, registerAttempted) {
        if (registerAttempted == true) {
            if (isRegisterSuccessful == true) {
                showErrorDialog = false
                NavController.navigate("onboarding"){
                    popUpTo(NavRoutes.Onboarding.route){
                        inclusive = true
                    }
                }
            } else {
                Log.d("RegisterScreen", "Register failed")
                showErrorDialog = true
            }
        } else{
            showErrorDialog = false
        }
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.Center
    ) {
        if (showErrorDialog) {
            AlertDialog(
                onDismissRequest = { showErrorDialog = false },
                title = { Text("Error") },
                text = { Text("Error al registrar usuario") },
                confirmButton = {
                    Button(
                        onClick = { showErrorDialog = false }
                    ) {
                        Text("Aceptar")
                    }
                }
            )
        }
        // Welcome message
        Text(
            text = stringResource(id = R.string.Hello_Register_to_get_started),
            fontSize = 40.sp,
            textAlign = TextAlign.Left,
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 16.dp)
        )

        // Username text field
        OutlinedTextField(
            value = userName,
            onValueChange = {userName = it },
            label = {Text(text = stringResource(id = R.string.Username)) },
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 8.dp)
        )


        // Email text field
        OutlinedTextField(
            value = password,
            onValueChange = {password = it },
            label = { Text(text = stringResource(id = R.string.Password)) },
            visualTransformation = PasswordVisualTransformation(),
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 8.dp)
        )


        OutlinedTextField(
            value = birthDate,
            onValueChange = {birthDate = it },
            label = { Text(text = stringResource(id = R.string.birthDate)) },
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 8.dp)
        )

        // Confirm Password text field
        OutlinedTextField(
            value = address,
            onValueChange = {address = it },
            label = { Text(text = stringResource(id = R.string.address)) },
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 8.dp)

        )

        // Register button
        Button(
           // onClick = { NavController.navigate(route = "onboarding") },
            onClick = {
                viewModel.doRegister(
                    RegisterDataBody(
                        usrn = userName, password = password, birthDate = birthDate, address = address
                    )
                )
            },
            modifier = Modifier
                .fillMaxWidth()
                .height(56.dp),
            colors = ButtonDefaults.buttonColors(
                containerColor = Color.Black,
                contentColor = Color.White,
            ),
            shape = RoundedCornerShape(8.dp)
        ) {
            Text(text = stringResource(id = R.string.Register))
        }
    }
}

@Preview(showBackground = true)
@Composable
fun RegisterScreenPreview() {
    // Dummy NavController for preview
    val navController = rememberNavController()
    RegisterScreen(NavController = navController, viewModel = RegisterViewModel())
}


