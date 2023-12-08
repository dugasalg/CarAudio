package com.example.caraudio.intropage.Views
import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Visibility
import androidx.compose.material.icons.filled.VisibilityOff
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.caraudio.R
import com.example.caraudio.intropage.Model.LoginDataBody
import com.example.caraudio.login.viewModel.LoginViewModel
import com.example.caraudio.navigation.NavRoutes

@Composable
fun LoginScreen(NavController: NavController, viewModel: LoginViewModel) {

    var password by remember { mutableStateOf("") }
    var userName by remember { mutableStateOf("") }
    val isLoginSuccessful by viewModel.isLoginSuccessful.observeAsState()
    var showErrorDialog by remember { mutableStateOf(false) }
    val loginAttempted by viewModel.loginAttempted.observeAsState()

    LaunchedEffect(isLoginSuccessful) {        if (loginAttempted == true) {
            if (isLoginSuccessful == true) {
                NavController.navigate("home"){
                    popUpTo(NavRoutes.Home.route){
                        inclusive = true
                    }
                }
                showErrorDialog = false
            } else {
                Log.d("LoginScreen", "Login failed")
                showErrorDialog = true
            }
        } else{
            showErrorDialog = false
        }
    }

    Row(
        modifier = Modifier
            .fillMaxWidth()
            .background(MaterialTheme.colorScheme.background)
            .padding(16.dp),
    ) {


        if (showErrorDialog) {
            AlertDialog(
                onDismissRequest = { showErrorDialog = false },
                title = { Text("Error") },
                text = { Text("Error al iniciar sesion") },
                confirmButton = {
                    Button(
                        onClick = { showErrorDialog = false }
                    ) {
                        Text("Aceptar")
                    }
                }
            )
        }

        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 72.dp),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally

        ) {
            // Welcome message
            Text(
                text = stringResource(id = R.string.Welcome_back),
                fontSize = 24.sp,
                textAlign = TextAlign.Center
            )
            Text(
                text = stringResource(id = R.string.Glad_to_see_you_again),
                fontSize = 24.sp,
                textAlign = TextAlign.Center
            )

            Spacer(modifier = Modifier.height(32.dp))

            // Email text field with email keyboard

            OutlinedTextField(
                value = userName,
                onValueChange = {userName = it },
                label = { Text(text = stringResource(id = R.string.Enter_your_username)) },
                keyboardOptions = KeyboardOptions.Default.copy(
                    keyboardType = androidx.compose.ui.text.input.KeyboardType.Email
                ),
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 11.dp)
            )

            // Password text field with eye icon
            var isPasswordVisible by remember { mutableStateOf(false) }
            OutlinedTextField(
                value = password,
                onValueChange = { password = it },
                label = { Text(text = stringResource(id = R.string.Enter_your_password))},
                trailingIcon = {
                    IconButton(
                        onClick = { isPasswordVisible = !isPasswordVisible }
                    ) {
                        Icon(
                            imageVector = if (isPasswordVisible) Icons.Default.Visibility else Icons.Default.VisibilityOff,
                            contentDescription = if (isPasswordVisible) "Hide password" else "Show password"
                        )
                    }
                },
                visualTransformation = if (isPasswordVisible) VisualTransformation.None else PasswordVisualTransformation(),
                keyboardOptions = KeyboardOptions.Default.copy(
                    keyboardType = androidx.compose.ui.text.input.KeyboardType.Password
                ),
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 8.dp)
            )

            Spacer(modifier = Modifier.height(16.dp))

            Spacer(modifier = Modifier.height(16.dp))

            // Login button
            // Inside the LoginScreen composable
            Button(
                //onClick = { NavController.navigate(route = "home") },
                onClick = {
                    viewModel.doLogin(
                        LoginDataBody(
                            usrn = userName, password = password
                        )
                    )
                },
                modifier = Modifier
                    .fillMaxWidth()  // Apply fillMaxWidth() directly here
                    .height(56.dp),
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color.Black,  // Set the background color here
                    contentColor = Color.White,
                ),
                shape = RoundedCornerShape(8.dp)
            ) {
                Text(text = stringResource(id = R.string.Login), color = Color.White)  // Set the text color here
            }


            Spacer(modifier = Modifier.height(16.dp))

            // "Don't have an account? Register now" button
            TextButton(
                onClick = { NavController.navigate(route = "register") },
            ) {
                Text(text = stringResource(id = R.string.Dont_have_an_account_Register_now))
            }
        }
    }
}
@Preview(showBackground = true)
@Composable
fun LoginScreenPreview() {
    // Dummy NavController for preview
    val navController = rememberNavController()
    LoginScreen(NavController = navController, viewModel = LoginViewModel())
}


