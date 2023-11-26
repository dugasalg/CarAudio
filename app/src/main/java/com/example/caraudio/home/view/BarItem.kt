package com.example.caraudio.home.view

import androidx.compose.ui.graphics.vector.ImageVector

/*BottonNavigationBarItems elements
 */
data class BarItem(
    //Item Title
    val title: String,
    //Item Icon
    val image: ImageVector,
    //Route to which we will be directed on click
    val route: String
)