package com.example.wbtechnoschool.screens.auth

import android.net.Uri
import android.widget.VideoView
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.paddingFrom
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.viewinterop.AndroidView
import androidx.compose.ui.zIndex
import androidx.navigation.NavController
import com.example.wbtechnoschool.R
import com.example.wbtechnoschool.ui.theme.LightColorTheme
import com.example.wbtechnoschool.utils.button.GradientButton

@Composable
fun ScreenMakeAnAppointmentDone(
    modifier: Modifier = Modifier,
    navController: NavController,
) {
    val context = LocalContext.current
    val videoView = remember { VideoView(context) }
    val videoUri = remember {
        Uri.parse("android.resource://${context.packageName}/" + R.raw.gradient_meetings_done_animation)
    }
    DisposableEffect(videoView) {
        videoView.setVideoURI(videoUri)
        videoView.setOnCompletionListener {
            videoView.start()
        }
        videoView.setOnPreparedListener { mediaPlayer ->
            mediaPlayer.isLooping = true
            mediaPlayer.setVideoScalingMode(android.media.MediaPlayer.VIDEO_SCALING_MODE_SCALE_TO_FIT)
        }
        videoView.start()
        onDispose {
            videoView.stopPlayback()
        }
    }
        Box(
            modifier = Modifier
                .fillMaxSize()
        ) {
            AndroidView(
                factory = { videoView },
                modifier = Modifier.fillMaxHeight().zIndex(0f)
            )
            Column(
                modifier = modifier
                    .padding(20.dp)
                    .statusBarsPadding()
            ) {
                    Column(
                        modifier = Modifier
                            .weight(5f),
                        verticalArrangement = Arrangement.Top,
                        horizontalAlignment = Alignment.Start
                    ) {
                        Text(
                            text = stringResource(id = R.string.your_make_an_appointment_done),
                            fontWeight = FontWeight.W600,
                            fontSize = 49.sp,
                            color = LightColorTheme.neutralWhite,
                            lineHeight = 40.sp
                        )
                        Spacer(modifier = Modifier.height(10.dp))
                        Text(
                            text = "Супертестировщики · 12 августа · Невский проспект, 11",
                            fontWeight = FontWeight.W400,
                            fontSize = 16.sp,
                            color = LightColorTheme.neutralWhite,
                        )
                    }
                }
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.SpaceBetween,
                modifier = Modifier
                    .padding(horizontal = 20.dp)
                    .padding(bottom = 15.dp)
                    .navigationBarsPadding()
                    .align(Alignment.BottomCenter)

            ) {
                Text(
                    text = stringResource(id = R.string.my_meetings),
                    color = LightColorTheme.fixVioletBlaze,
                    fontWeight = FontWeight.W500,
                    fontSize = 18.sp,
                    modifier = Modifier.clickable { }
                )
                Spacer(modifier = Modifier.height(20.dp))
                GradientButton(
                    modifier = Modifier.height(56.dp),
                    textButton = "Найти другие встречи",
                    enable = true,
                ) {}
            }
        }
    }
