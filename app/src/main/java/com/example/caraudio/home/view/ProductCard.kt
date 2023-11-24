package com.example.caraudio.views

import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.example.caraudio.models.Amps
import com.example.caraudio.models.Speakers

@Composable
fun ProductCard(product: Amps) {
    Box(
        modifier = Modifier
            .clip(RoundedCornerShape(27.dp))
            .border(
                width = 1.dp,
                color = Color.LightGray,
                shape = RoundedCornerShape(27.dp)
            )
            .padding(10.dp)
            .height(200.dp)
            .width(240.dp)
    )
    {
        Column(
            modifier = Modifier
                .fillMaxWidth()
        ) {
            Image(
                painter = painterResource(id = product.imageResourceId),
                contentDescription = null,
                contentScale = ContentScale.Fit,
                modifier = Modifier
                    .height(120.dp)
                    .fillMaxWidth()
                    .clip(RoundedCornerShape(8.dp))
            )

            Spacer(modifier = Modifier.height(16.dp))

            Text(
                text = product.name,
                style = MaterialTheme.typography.headlineSmall,
                fontWeight = FontWeight.Bold,
                modifier = Modifier.fillMaxWidth()
            )

            Spacer(modifier = Modifier.height(2.dp))

            Text(
                text = product.price,
                style = MaterialTheme.typography.bodyMedium,
                modifier = Modifier.fillMaxWidth()
            )
        }
    }
}

@Composable
fun ProductCard2(product: Speakers) {
    Box(
        modifier = Modifier
            .clip(RoundedCornerShape(27.dp))
            .border(
                width = 1.dp,
                color = Color.LightGray,
                shape = RoundedCornerShape(27.dp)
            )
            .padding(10.dp)
            .height(200.dp)
            .width(200.dp)
    )
    {
        Column(
            modifier = Modifier
                .fillMaxWidth()
        ) {
            Image(
                painter = painterResource(id = product.imageResourceId),
                contentDescription = null,
                contentScale = ContentScale.Fit,
                modifier = Modifier
                    .height(120.dp)
                    .fillMaxWidth()
                    .clip(RoundedCornerShape(8.dp))
            )

            Spacer(modifier = Modifier.height(16.dp))

            Text(
                text = product.name,
                style = MaterialTheme.typography.headlineSmall,
                fontWeight = FontWeight.Bold,
                modifier = Modifier.fillMaxWidth()
            )

            Spacer(modifier = Modifier.height(8.dp))

            Text(
                text = product.price,
                style = MaterialTheme.typography.bodyMedium,
                modifier = Modifier.fillMaxWidth()
            )
        }
    }
}