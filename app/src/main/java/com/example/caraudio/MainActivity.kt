package com.example.caraudio

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.BlendMode.Companion.Screen
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.caraudio.intropage.IntroScreen
import com.example.caraudio.intropage.LoginScreen
import com.example.caraudio.intropage.RegisterScreen

import com.example.caraudio.navigation.NavRoutes
import com.example.caraudio.onboarding.OnboardingView
import com.example.caraudio.ui.theme.CarAudioTheme
import com.example.caraudio.views.ProductCardPreview
import com.google.accompanist.pager.ExperimentalPagerApi

class MainActivity : ComponentActivity() {
    @OptIn(ExperimentalPagerApi::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            CarAudioTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    //IntroScreen()
                    //OnboardingView()
                    //LoginScreenPreview()
                    //RegisterScreenPreview()
                    //ProductCardPreview()
                }
            }
        }
    }
}
@SuppressLint("SuspiciousIndentation")
@Composable
fun MainScreen() {
    val navController = rememberNavController()
            NavigationHost(navController = navController) }

@OptIn(ExperimentalPagerApi::class)
@Composable
fun NavigationHost(navController: NavHostController) {
    NavHost(navController, startDestination = NavRoutes.Intro.route) {
        composable(NavRoutes.Intro.route) {
            IntroScreen(navController = navController)
        }
        composable(NavRoutes.Login.route) {
            LoginScreen(NavController = navController)
        }
        composable(NavRoutes.Register.route) {
            RegisterScreen(NavController = navController)
        }
        composable(NavRoutes.Home.route) {
            ProductCardPreview(NavController = navController)
        }
        composable(NavRoutes.Onboarding.route) {
            OnboardingView(navController = navController)
        }
        // Puedes agregar más composables aquí para otras pantallas
    }
}
@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    CarAudioTheme {
        MainScreen()
    }
}




