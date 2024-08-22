package com.example.wbtechnoschool.screens.splash

import android.net.Uri
import android.widget.VideoView
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.material3.Icon
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.viewinterop.AndroidView
import com.airbnb.lottie.compose.LottieAnimation
import com.airbnb.lottie.compose.LottieCompositionSpec
import com.airbnb.lottie.compose.animateLottieCompositionAsState
import com.airbnb.lottie.compose.rememberLottieComposition
import com.example.wbtechnoschool.R
import com.example.wbtechnoschool.ui.theme.LightColorTheme
import com.example.wbtechnoschool.ui.theme.fontSFPro
import com.example.wbtechnoschool.utils.constants.MagicNumbers
import com.example.wbtechnoschool.utils.constants.SPACER

const val iterationsSplashScreen = 1

@Composable
fun SplashScreen(
    modifier: Modifier = Modifier,
    onTimeout: () -> Unit
) {
    val context = LocalContext.current
    val videoView = remember { VideoView(context) }
    val videoUri = remember {
        Uri.parse("android.resource://${context.packageName}/" + R.raw.animation_loader)
    }
    DisposableEffect(videoView) {
        videoView.setVideoURI(videoUri)
        videoView.setOnCompletionListener {
            onTimeout()
        }
        videoView.start()
        onDispose {
            videoView.stopPlayback()
        }
    }
    Box(modifier = modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
        AndroidView(
            factory = { videoView },
            modifier = Modifier.fillMaxSize()
        )
        Column(
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Icon(
                painter = painterResource(id = R.drawable.image_wb),
                contentDescription = null,
                tint = Color.Unspecified
            )
            Spacer(modifier = Modifier.height(SPACER.SPACER_10.value.dp))
            Icon(
                painter = painterResource(id = R.drawable.image_meetings),
                contentDescription = null,
                tint = Color.Unspecified
            )
        }
    }
}

@Composable
fun SplashScreenHelloName(
    modifier: Modifier = Modifier,
    name: String,
    onTimeout: () -> Unit
) {
    val lottiAnimation by rememberLottieComposition(LottieCompositionSpec.RawRes(R.raw.animation_loader))
    val progress by animateLottieCompositionAsState(
        composition = lottiAnimation,
        iterations = iterationsSplashScreen,
        speed = (1f)
    )
    Column(
        modifier =
        modifier
            .fillMaxSize()
            .statusBarsPadding(),
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Spacer(modifier = Modifier.height(SPACER.SPACER_60.value.dp))
        Text(
            text = "${stringResource(id = R.string.the_greeting)}\n$name !",
            fontSize = MagicNumbers.SPLASH_SCREEN_TEXT_NAME_FONT_SIZE.sp,
            fontWeight = FontWeight.W700,
            fontFamily = fontSFPro,
            color = LightColorTheme.neutralActive,
            textAlign = TextAlign.Center,
            lineHeight = MagicNumbers.SPLASH_SCREEN_TEXT_NAME_LINE_HEIGHT.sp
        )
        Spacer(modifier = Modifier.height(SPACER.SPACER_60.value.dp))
        LottieAnimation(composition = lottiAnimation, progress = { progress })
    }
    LaunchedEffect(progress) {
        if (progress == 1f) {
            onTimeout()
        }
    }
}
