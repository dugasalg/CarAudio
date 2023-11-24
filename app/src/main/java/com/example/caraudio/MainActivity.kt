package com.example.caraudio

import android.annotation.SuppressLint
import android.os.Bundle
import android.util.Log
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.caraudio.intropage.Views.IntroScreen
import com.example.caraudio.intropage.Views.LoginScreen
import com.example.caraudio.intropage.Views.RegisterScreen

import com.example.caraudio.navigation.NavRoutes
import com.example.caraudio.onboarding.OnboardingView
import com.example.caraudio.ui.theme.CarAudioTheme
import com.example.caraudio.views.ProductCardPreview
import com.google.accompanist.pager.ExperimentalPagerApi
import androidx.core.content.ContextCompat
import com.example.caraudio.intropage.ViewModel.LoginViewModel

class MainActivity : AppCompatActivity() {
    @OptIn(ExperimentalPagerApi::class)

    private var canAuthenticate = false
    private lateinit var promptInfo: androidx.biometric.BiometricPrompt.PromptInfo
    private lateinit var biometricPrompt: androidx.biometric.BiometricPrompt
    var isAuthenticated = mutableStateOf(false)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setUpAuth()
        setContent {

            CarAudioTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    //Auth(isAuthenticated, onAuthenticated = ::handleAuthenticationResult)
                    MainScreen()
                    //IntroScreen()
                    //OnboardingView()
                    //LoginScreenPreview()
                    //RegisterScreenPreview()
                    //ProductCardPreview()
                }
            }
        }
    }


    private fun setUpAuth() {
        val biometricManager = androidx.biometric.BiometricManager.from(this)
        if (biometricManager.canAuthenticate(androidx.biometric.BiometricManager.Authenticators.BIOMETRIC_WEAK or androidx.biometric.BiometricManager.Authenticators.DEVICE_CREDENTIAL) == androidx.biometric.BiometricManager.BIOMETRIC_SUCCESS) {
            Log.d("MainActivity", "Puede autenticar")
            canAuthenticate = true
            promptInfo = androidx.biometric.BiometricPrompt.PromptInfo.Builder()
                .setTitle("Autenticación biométrica")
                .setSubtitle("Inicia sesión usando tu huella digital")
                .setAllowedAuthenticators(androidx.biometric.BiometricManager.Authenticators.BIOMETRIC_WEAK or androidx.biometric.BiometricManager.Authenticators.DEVICE_CREDENTIAL)
                .build()
            biometricPrompt = androidx.biometric.BiometricPrompt(
                this,
                ContextCompat.getMainExecutor(this),
                object : androidx.biometric.BiometricPrompt.AuthenticationCallback() {
                    override fun onAuthenticationError(errorCode: Int, errString: CharSequence) {
                        super.onAuthenticationError(errorCode, errString)
                        Log.d("MainActivity", "onAuthenticationError: $errString ($errorCode)")

                        // Manejar error
                    }

                    override fun onAuthenticationSucceeded(result: androidx.biometric.BiometricPrompt.AuthenticationResult) {
                        super.onAuthenticationSucceeded(result)
                        Log.d("MainActivity", "onAuthenticationSucceeded")

                        // Autenticación exitosa
                        handleAuthenticationResult(true)
                    }

                    override fun onAuthenticationFailed() {
                        super.onAuthenticationFailed()
                        // Autenticación fallida
                        Log.d("MainActivity", "onAuthenticationFailed")
                        handleAuthenticationResult(false)
                    }
                })
        } else {
            Log.d("MainActivity", "No puede autenticar")
            // Manejar el caso donde no se puede autenticar
        }
    }
    private fun handleAuthenticationResult(result: Boolean) {
        Log.d("MainActivity", "aquiii")

        isAuthenticated.value = result  // Actualiza el estado observado

        //canAuthenticate = result
        // Aquí puedes manejar el resultado de la autenticación
        // Por ejemplo, puedes cambiar el estado de la UI o navegar a otra pantalla
    }


    fun authenticate(onAuthenticated: (Boolean) -> Unit) {
        if (canAuthenticate) {
            Log.d("MainActivity", "Intentando autenticar")
            biometricPrompt.authenticate(promptInfo)
        } else {
            // Manejar el caso donde no se puede autenticar
            Log.d("MainActivity", "No se puede autenticar")
            onAuthenticated(false)
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
            LoginScreen(NavController = navController, viewModel = LoginViewModel())
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




