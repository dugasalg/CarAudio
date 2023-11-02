package com.example.caraudio.onboarding

import androidx.annotation.FloatRange
import androidx.annotation.IntRange
import androidx.compose.animation.core.animateDpAsState
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.google.accompanist.pager.ExperimentalPagerApi
import com.google.accompanist.pager.HorizontalPager
import com.google.accompanist.pager.PagerState
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.caraudio.R
import com.example.caraudio.utils.PreferencesManager
import com.google.accompanist.pager.rememberPagerState
import kotlinx.coroutines.launch

@ExperimentalPagerApi
@Composable
fun OnboardingView(navController: NavController) {
    val items = ArrayList<OnBoardingData>()

    items.add(
        OnBoardingData(
            stringResource(id = R.string.Glad_to_see_you_You_will_discover_new_amazing_Car_Audio_products)
        )
    )

    items.add(
        OnBoardingData(
            stringResource(id = R.string.With_us_you_can_buy_whatever_Car_Audio_component_or_accesory_you_need),
        )
    )

    items.add(
        OnBoardingData(
            stringResource(id = R.string.Dont_hesitate_to_ask_for_help_Our_support_team_is_available_24_7),
        )
    )
    val pagerState = rememberPagerState(
        pageCount = items.size,
        initialOffscreenLimit = 2,
        infiniteLoop = false,
        initialPage = 0
    )
    val backgroundImage =
        painterResource(id = R.drawable.wpp2) // Replace with your background image
    Box {

    }
    Box(
        modifier = Modifier
            .fillMaxSize()
    ) {

        Image(
            painter = backgroundImage,
            contentDescription = null, // Provide a content description if needed
            modifier = Modifier.fillMaxSize(),
            contentScale = ContentScale.FillBounds
        )


        OnBoardingPager(
            item = items,
            pagerState = pagerState,
            modifier = Modifier.fillMaxWidth(),
            navController = navController
        )
    }
}

@ExperimentalPagerApi
@Composable
fun OnBoardingPager(
    item: List<OnBoardingData>,
    pagerState: PagerState,
    modifier: Modifier = Modifier,
    navController: NavController

    ) {
    Box(modifier = modifier) {
        Spacer(modifier = Modifier.height(790.dp))

        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Bottom,
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 40.dp)
        ) {
            HorizontalPager(
                state = pagerState
            ) { page ->
                Column(
                    modifier = Modifier
                        .padding(10.dp)
                        .fillMaxWidth(),
                    horizontalAlignment = Alignment.Start // Align the content to the start
                ) {
                    Spacer(modifier = Modifier.height(430.dp)) // Add spacer for spacing

                    Text(
                        text = item[page].title,
                        modifier = Modifier.padding(top = 50.dp),
                        color = Color.White,
                        style = MaterialTheme.typography.headlineLarge// Adjust font size

                    )


                }
            }

            PagerIndicator(item.size, pagerState.currentPage)
        }
        Box(modifier = Modifier.align(Alignment.BottomCenter)) {
           BottomSection(pagerState.currentPage, pagerState, navController)
        }
    }
}

@ExperimentalPagerApi
@Composable
fun rememberPagerState(
    @IntRange(from = 0) pageCount: Int,
    @IntRange(from = 0) initialPage: Int = 0,
    @FloatRange(from = 0.0, to = 1.0) initialPageOffset: Float = 0f,
    @IntRange(from = 1) initialOffscreenLimit: Int = 1,
    infiniteLoop: Boolean = false
): PagerState = rememberSaveable(
    saver = PagerState.Saver
) {
    PagerState(
        pageCount = pageCount,
        currentPage = initialPage,
        currentPageOffset = initialPageOffset,
        offscreenLimit = initialOffscreenLimit,
        infiniteLoop = infiniteLoop
    )
}

@Composable
fun PagerIndicator(
    size: Int,
    currentPage: Int
) {
    Row(
        horizontalArrangement = Arrangement.SpaceBetween,
        modifier = Modifier.padding(top = 60.dp)
    ) {
        repeat(size) {
            Indicator(isSelected = it == currentPage)
        }
    }
}

@Composable
fun Indicator(isSelected: Boolean) {
    val width = animateDpAsState(targetValue = if (isSelected) 25.dp else 10.dp)

    Box(
        modifier = Modifier
            .padding(1.dp)
            .height(10.dp)
            .width(width.value)
            .clip(CircleShape)
            .background(
                if (isSelected) Color.White else Color.White.copy(alpha = 0.5f)
            )
    )
}
@OptIn(ExperimentalPagerApi::class)
@Composable
fun BottomSection(currentPager: Int, pagerState: PagerState, navController: NavController) {
    val context = LocalContext.current
    val preferencesManager = remember { PreferencesManager(context) }
    Row(
        modifier = Modifier
            .padding(bottom = 20.dp)
            .fillMaxWidth(),
        horizontalArrangement = if (currentPager != 2) Arrangement.SpaceBetween else Arrangement.Center
    ) {
        if (currentPager == 2) {
            Button(
                onClick = { navController.navigate(route = "home")
                    preferencesManager.saveData("alreadyShowOnboarding", true)},
                shape = RoundedCornerShape(80),
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color.Black,
                    contentColor = Color.White,
                )
            ) {
                Text(
                    text = "Get Started",
                    modifier = Modifier
                        .padding(vertical = 10.dp, horizontal = 10.dp),
                    color = Color.White,
                    fontSize = 20.sp
                )
            }
        } else {
            SkipNextButton(text = "Skip", modifier = Modifier.padding(start = 20.dp), pagerState, navController) // Pasar navController
            SkipNextButton(text = "Next", modifier = Modifier.padding(end = 20.dp), pagerState, navController) // Pasar navController
        }
    }
}

@OptIn(ExperimentalPagerApi::class)
@Composable
fun SkipNextButton(text: String, modifier: Modifier, pagerState: PagerState, navController: NavController) {  // Añadir navController
    val coroutineScope = rememberCoroutineScope()

    Text(
        text = text,
        color = Color.White,
        modifier = modifier.clickable {
            if (text == "Skip") {
                coroutineScope.launch {
                    pagerState.scrollToPage(pagerState.pageCount - 1)
                }
                navController.navigate(route = "home") // Navegación para "Skip"
            } else if (text == "Next") {
                coroutineScope.launch {
                    pagerState.scrollToPage(pagerState.currentPage + 1)
                }
            }
        },
        fontSize = 18.sp,
        style = MaterialTheme.typography.headlineLarge,
        fontWeight = FontWeight.Medium
    )
}

@ExperimentalPagerApi
@Preview(showBackground = true)
@Composable
fun OnboardingViewPreview() {
    // Dummy NavController for preview
    val navController = rememberNavController()
    OnboardingView(navController = navController)
}
