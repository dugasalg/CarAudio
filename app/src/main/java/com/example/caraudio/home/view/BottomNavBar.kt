package com.example.caraudio.views

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.navigation.NavController
import com.example.caraudio.R
import com.example.caraudio.navigation.NavRoutes

@Composable
fun BottomNavBar(navController: NavController) {
    BottomNavigation(
        modifier = Modifier.fillMaxWidth(),
        backgroundColor = Color.White,
        contentColor = Color.DarkGray
    ) {
        BottomNavigationItem(
            icon = { Icon(Icons.Default.Home, contentDescription = null) },
            label = { androidx.compose.material3.Text(text = stringResource(id = R.string.home)) },
            selected = true,
            onClick = {}
        )
        BottomNavigationItem(
            icon = { Icon(Icons.Default.ShoppingCart, contentDescription = null) },
            label = { androidx.compose.material3.Text(text = stringResource(id = R.string.cart)) },
            selected = false,
            onClick = {}
        )
        BottomNavigationItem(
            icon = { Icon(Icons.Default.Menu, contentDescription = null) },
            label = { androidx.compose.material3.Text(text = stringResource(id = R.string.menu)) },
            selected = false,
            onClick =
            {
                navController.navigate(NavRoutes.Menu.route)
            }
        )
    }
}
