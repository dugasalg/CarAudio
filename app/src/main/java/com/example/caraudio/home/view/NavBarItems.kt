package com.example.caraudio.home.view

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
//Here we will create define the items contained on the bottom navigation bar,
// the BarItem Params are defined on the BarItem data class
object NavBarItems {
    val NavBarItems = listOf(
        BarItem(
            title = "Home",
            image = Icons.Filled.Article,
            route = "Home"
        ),
        BarItem(
            title = "Cart",
            image = Icons.Filled.CameraAlt,
            route = ""
        ),
        BarItem(
            title = "Menu",
            image = Icons.Filled.AccountBox,
            route = "Menu"
        ),
    )



}