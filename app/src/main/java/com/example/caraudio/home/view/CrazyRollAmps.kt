package com.example.caraudio.views

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.caraudio.R
import com.example.caraudio.home.view.SearchBar
import com.example.caraudio.models.Amps

@Composable
fun CrazyRoll(products: List<Amps>, modifier: Modifier = Modifier) {

    Column(
        modifier = modifier.padding(16.dp)
    ) {
        SearchBar()
        Spacer(modifier = Modifier.height(16.dp))
        Text(
            text = stringResource(id = R.string.Amplifiers),
            fontSize = 30.sp,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.fillMaxWidth()
        )
        Spacer(modifier = Modifier.height(5.dp))
        LazyRow {
            items(products) { product ->
                Spacer(modifier = Modifier.width(8.dp))
                //ProductCard(product)
            }
        }
    }
}
