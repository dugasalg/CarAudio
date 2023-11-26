package com.example.caraudio.home.view

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.caraudio.R
import com.example.caraudio.models.Amps
import com.example.caraudio.models.Speakers
import com.example.caraudio.views.BottomNavBar
import com.example.caraudio.views.CrazyRoll

@Composable
fun SearchBar() {
    var text by remember { mutableStateOf("") }
    TextField(
        value = text,
        onValueChange = { text = it },
        label = {  Text(stringResource(id = R.string.search)) },
        modifier = Modifier.fillMaxWidth(),
        colors = TextFieldDefaults.colors(
            unfocusedIndicatorColor = Color.Transparent,
            focusedIndicatorColor = Color.Transparent,
            cursorColor = Color.Transparent,
        )
    )
}

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val navController = rememberNavController()

            val amps = listOf(
                Amps("JL Audio Amplifier", "$9000.00", R.drawable.jlamp),
                Amps("Hifonics Amplifier", "$8000.00", R.drawable.hifonicsamp)
            )
            val speakers = listOf(
                Speakers("Example Speaker 1", "$5000.00", R.drawable.jlamp),
                Speakers("Example Speaker 2", "$7000.00", R.drawable.hifonicsamp)
            )

            Surface(
                modifier = Modifier
                    .fillMaxSize()
                    .background(MaterialTheme.colorScheme.background)
            ) {
                Column {
                    CrazyRoll(products = amps, modifier = Modifier.weight(1f))
                    CrazyRoll(products = speakers, modifier = Modifier.weight(1f))
                    BottomNavBar(navController = navController)
                }
            }
        }
    }
}


@Composable
fun ProductCardPreview(NavController: NavController) {
    val navController = rememberNavController()

    val amps = listOf(
        Amps("JL Audio Amplifier", "$9000.00", R.drawable.jlamp),
        Amps("Hifonics Amplifier", "$8000.00", R.drawable.hifonicsamp)
    )

    val speakers = listOf(
        Speakers("JL Speaker", "$1200.00", R.drawable.jlspeak),
        Speakers("JL Subwoofer", "$1800.00", R.drawable.jlsub)
    )

    Column {
        CrazyRoll(products = amps, modifier = Modifier.weight(1f))
        CrazyRoll(products = speakers, modifier = Modifier.weight(1f))
        BottomNavBar(navController = navController)

    }

}

@Preview(showBackground = true)
@Composable
fun MainActivityPreview() {
    // Dummy NavController for preview


    val amps = listOf(
        Amps("JL Audio Amplifier", "$9000.00", R.drawable.jlamp),
        Amps("Hifonics Amplifier", "$8000.00", R.drawable.hifonicsamp)
    )

    val speakers = listOf(
        Speakers("JL Speaker", "$1200.00", R.drawable.jlspeak),
        Speakers("JL Subwoofer", "$1800.00", R.drawable.jlsub)
    )

    Surface(
        modifier = Modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.background)
    ) {
        Column {
            CrazyRoll(products = amps, modifier = Modifier.weight(1f))
            CrazyRoll(products = speakers, modifier = Modifier.weight(1f))
            BottomNavBar(navController = rememberNavController())
            }
        }
    }


