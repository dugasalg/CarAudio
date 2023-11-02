package com.example.caraudio.intropage

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.caraudio.R

@Composable
fun IntroScreen(navController: NavController) {
    val backgroundDrawable = painterResource(id = R.drawable.wpp2) // Change to your drawable

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
    ) {
        Image(
            painter = backgroundDrawable,
            contentDescription = null,
            modifier = Modifier
                .fillMaxSize()
                .clip(MaterialTheme.shapes.medium),
            contentScale = ContentScale.FillBounds
        )

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp)
        ) {
            // Text at the top right
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(end = 10.dp, top = 10.dp),
                horizontalArrangement = Arrangement.End
            ) {
                Text(stringResource(id = R.string.Your_CarAudio_Store), color = Color.White, fontSize = 50.sp)
            }

            Spacer(modifier = Modifier.height(16.dp))

            // Spacer to push buttons to the bottom
            Spacer(modifier = Modifier.weight(1f))

            // Buttons at the bottom
            Button(
                onClick = { navController.navigate(route = "login") },
                modifier = Modifier
                    .fillMaxWidth()  // Apply fillMaxWidth() directly here
                    .height(56.dp),
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color.Gray,  // Set the background color here
                    contentColor = Color.White,
                ),
                shape = RoundedCornerShape(8.dp)
            ) {
                Text(stringResource(id = R.string.Login), color = Color.White)  // Set the text color here
            }

            Spacer(modifier = Modifier.height(10.dp))

            Button(
                onClick = { navController.navigate(route = "register") },
                modifier = Modifier
                    .fillMaxWidth()  // Apply fillMaxWidth() directly here
                    .height(56.dp),
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color.Gray,  // Set the background color here
                    contentColor = Color.White,
                ),
                shape = RoundedCornerShape(8.dp)
            ) {
                Text(stringResource(id = R.string.Register), color = Color.White)  // Set the text color here
            }

            TextButton(
                onClick = { navController.navigate(route = "onboarding") },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 8.dp)
            ) {
                Text(stringResource(id = R.string.Continue_as_a_guest), color = Color.White)
            }
        }
    }
}
@Preview(showBackground = true)
@Composable
fun IntroScreenPreview() {
    // Dummy NavController for preview
    val navController = rememberNavController()
    IntroScreen(navController = navController)
}

