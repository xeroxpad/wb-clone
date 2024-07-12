package com.example.wbtechnoschool.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.airbnb.lottie.compose.LottieAnimation
import com.airbnb.lottie.compose.LottieCompositionSpec
import com.airbnb.lottie.compose.animateLottieCompositionAsState
import com.airbnb.lottie.compose.rememberLottieComposition
import com.example.wbtechnoschool.ui.theme.LightColorTheme
import com.example.wbtechnoschool.ui.theme.fontSFPro

@Composable
fun SplashScreen(onTimeout: () -> Unit) {

    val lottiAnimation by rememberLottieComposition(LottieCompositionSpec.Asset("lottie_animation.json"))
    val progress by animateLottieCompositionAsState(
        composition = lottiAnimation,
        iterations = 1,
        speed = (1.5f)
    )
    Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
        LottieAnimation(composition = lottiAnimation, progress = { progress })
    }
    LaunchedEffect(progress) {
        if (progress == 1f) {
            onTimeout()
        }
    }
}

@Composable
fun SplashScreenHelloName(name: String, onTimeout: () -> Unit) {
    val lottiAnimation by rememberLottieComposition(LottieCompositionSpec.Asset("lottie4.json"))
    val progress by animateLottieCompositionAsState(
        composition = lottiAnimation,
        iterations = 1,
        speed = (0.7f)
    )
    Column(
        modifier = Modifier
            .fillMaxSize()
            .statusBarsPadding(),
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Spacer(modifier = Modifier.height(60.dp))
        Text(
            text = "Добрый день,\n$name!",
            fontSize = 30.sp,
            fontWeight = FontWeight.W700,
            fontFamily = fontSFPro,
            color = LightColorTheme.neutralActive,
            textAlign = TextAlign.Center,
            lineHeight = 35.sp
        )
        LottieAnimation(composition = lottiAnimation, progress = { progress })
    }
    LaunchedEffect(progress) {
        if (progress == 1f) {
            onTimeout()
        }
    }
}

