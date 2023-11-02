package com.example.caraudio.navigation

sealed class NavRoutes(val route: String) {
    object Intro: NavRoutes("intro")
    object Login: NavRoutes("login")
    object Onboarding: NavRoutes("onboarding")
    object Register: NavRoutes("register")
    object Home: NavRoutes("home")
}