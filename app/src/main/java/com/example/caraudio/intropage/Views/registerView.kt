
package com.example.caraudio.intropage.Views

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.*
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
import java.util.*

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun RegisterScreen(NavController: NavController) {

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.Center
    ) {
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
            value = "",
            onValueChange = { /* Handle username change */ },
            label = {Text(text = stringResource(id = R.string.Username)) },
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 8.dp)
        )


        // Email text field
        OutlinedTextField(
            value = "",
            onValueChange = { /* Handle email change */ },
            label = { Text(text = stringResource(id = R.string.Email)) },
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 8.dp)
        )

        // Password text field
        OutlinedTextField(
            value = "",
            onValueChange = { /* Handle password change */ },
            label = { Text(text = stringResource(id = R.string.Password)) },
            visualTransformation = PasswordVisualTransformation(),
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 8.dp)
        )

        // Confirm Password text field
        OutlinedTextField(
            value = "",
            onValueChange = { /* Handle confirm password change */ },
            label = { Text(text = stringResource(id = R.string.Confirm_Password)) },
            visualTransformation = PasswordVisualTransformation(),
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 8.dp)

        )

        // Register button
        Button(
            onClick = { NavController.navigate(route = "onboarding") },
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
    RegisterScreen(NavController = navController)
}


