package com.example.caraudio.onboarding

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import com.airbnb.lottie.compose.LottieAnimation
import com.airbnb.lottie.compose.LottieCompositionSpec
import com.airbnb.lottie.compose.LottieConstants
import com.airbnb.lottie.compose.animateLottieCompositionAsState
import com.airbnb.lottie.compose.rememberLottieComposition

data class OnBoardingData(val title: String)

@Composable
fun LoaderIntro(modifier: Modifier, image: Int) {
    Image(
        painter = painterResource(image),
        contentDescription = null, // Provide a content description if needed
        modifier = modifier.fillMaxSize() // Fill the entire available space
    )
}