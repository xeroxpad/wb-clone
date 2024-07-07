package com.example.wbtechnoschool.screens

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.airbnb.lottie.compose.LottieAnimation
import com.airbnb.lottie.compose.LottieCompositionSpec
import com.airbnb.lottie.compose.animateLottieCompositionAsState
import com.airbnb.lottie.compose.rememberLottieComposition

@Composable
fun SplashScreen(onTimeout: () -> Unit) {
    val lottiAnimation by rememberLottieComposition(LottieCompositionSpec.Asset("lottie_animation.json"))
    val progress by animateLottieCompositionAsState(
        composition = lottiAnimation,
        iterations = 1,
        speed = (1f)
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