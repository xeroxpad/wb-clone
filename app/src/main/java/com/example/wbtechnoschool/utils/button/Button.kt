package com.example.wbtechnoschool.utils.button

import android.content.Context
import android.media.MediaPlayer
import android.os.Build
import android.os.VibrationEffect
import android.os.Vibrator
import android.os.VibratorManager
import androidx.annotation.RequiresApi
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Color.Companion.Transparent
import androidx.compose.ui.graphics.Color.Companion.White
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.airbnb.lottie.compose.LottieAnimation
import com.airbnb.lottie.compose.LottieCompositionSpec
import com.airbnb.lottie.compose.animateLottieCompositionAsState
import com.airbnb.lottie.compose.rememberLottieComposition
import com.example.wbtechnoschool.R
import com.example.wbtechnoschool.screens.splash.iterationsSplashScreen
import com.example.wbtechnoschool.ui.theme.LightColorTheme
import com.example.wbtechnoschool.ui.theme.fontSFPro
import com.example.wbtechnoschool.utils.constants.MagicNumbers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

@Composable
fun StatusButton(
    modifier: Modifier = Modifier,
    onClick: () -> Unit,
    contentText: String,
    isGoing: Boolean,
) {
    Button(
        onClick = onClick,
        modifier = modifier.fillMaxSize(),
        colors =
        ButtonDefaults.buttonColors(
            containerColor = Transparent,
            contentColor = if (isGoing) White else LightColorTheme.fixVioletBlaze,
            disabledContainerColor = LightColorTheme.brandColorDefault.copy(alpha = MagicNumbers.BUTTON_DISABLED_CONTAINER_COLOR)
        ),
    ) {
        Text(text = contentText)
    }
}

@Composable
fun StatusOutlinedButton(
    modifier: Modifier = Modifier,
    contentColor: Color,
    enable: Boolean,
    onClick: () -> Unit,
    contentText: String
) {
    OutlinedButton(
        onClick = onClick,
        shape = RoundedCornerShape(MagicNumbers.BUTTON_SHAPE),
        modifier = modifier,
        border =
        BorderStroke(
            width = MagicNumbers.BUTTON_BORDER_STROKE_WIDTH.dp,
            color = contentColor
        ),
        colors =
        ButtonDefaults.buttonColors(
            containerColor = Color.Transparent,
            contentColor = contentColor
        ),
        enabled = enable
    ) {
        Text(text = contentText)
    }
}

@Composable
fun StatusTextButton(
    modifier: Modifier = Modifier,
    contentColor: Color,
    containerColor: Color,
    enable: Boolean,
    onClick: () -> Unit,
    contentText: String
) {
    TextButton(
        onClick = onClick,
        shape = RoundedCornerShape(MagicNumbers.BUTTON_SHAPE),
        modifier = modifier,
        colors =
        ButtonDefaults.buttonColors(
            contentColor = contentColor,
            containerColor = containerColor
        ),
        enabled = enable
    ) {
        Text(text = contentText, fontSize = MagicNumbers.BUTTON_TEXT_BUTTON_FONT_SIZE.sp)
    }
}

@Composable
fun IconOutlinedButton(
    modifier: Modifier = Modifier,
    contentColor: Color,
    onClick: () -> Unit,
    icon: Int
) {
    OutlinedButton(
        onClick = onClick,
        shape = RoundedCornerShape(MagicNumbers.BUTTON_SHAPE),
        modifier = modifier,
        border =
        BorderStroke(
            width = MagicNumbers.BUTTON_BORDER_STROKE_WIDTH.dp,
            color = contentColor
        ),
        colors =
        ButtonDefaults.buttonColors(
            containerColor = Color.Transparent,
            contentColor = contentColor
        )
    ) {
        Icon(painter = painterResource(id = icon), contentDescription = null)
    }
}

@Composable
fun FixButton(
    modifier: Modifier = Modifier,
    containerColor: Color,
    enable: Boolean,
    onClick: () -> Unit,
) {
    Button(
        onClick = onClick,
        shape = RoundedCornerShape(MagicNumbers.BUTTON_SHAPE),
        modifier = modifier,
        colors =
        ButtonDefaults.buttonColors(
            containerColor = containerColor,
            contentColor = White,
            disabledContainerColor = LightColorTheme.brandColorDefault.copy(alpha = MagicNumbers.BUTTON_DISABLED_CONTAINER_COLOR)
        ),
        enabled = enable
    ) {
        Text(text = "Изменить фото")
    }
}

@Composable
fun GradientButton(
    modifier: Modifier = Modifier,
    enable: Boolean = false,
    textButton: String,
    onClick: () -> Unit,
) {
    val background = listOf(
        LightColorTheme.fixBlushPink,
        LightColorTheme.fixFuchsiaGlow,
        LightColorTheme.fixVividViolet,
        LightColorTheme.fixElectricViolet,
        LightColorTheme.fixRadiantMagenta,
        LightColorTheme.fixVioletBlaze,
        LightColorTheme.fixNeonLavender,
        LightColorTheme.fixRoyalIndigo
    )
    Button(
        onClick = {
            onClick()
        },
        shape = RoundedCornerShape(MagicNumbers.BUTTON_SHAPE),
        modifier = modifier.fillMaxWidth(),
        colors =
        ButtonDefaults.buttonColors(
            containerColor = Transparent,
            contentColor = White,
            disabledContainerColor = LightColorTheme.fixLavenderBlush
        ),
        enabled = enable,
        contentPadding = PaddingValues()
    ) {
        val backgroundModifier = if (enable) {
            Modifier.background(Brush.linearGradient(colors = background))
        } else {
            Modifier.background(LightColorTheme.fixLavenderBlush)
        }
        Box(
            modifier = backgroundModifier
                .fillMaxSize(),
            contentAlignment = Alignment.Center
        ) {
            Text(
                text = textButton,
                fontWeight = FontWeight.W600,
                fontSize = 18.sp,
                color = if (enable) White else LightColorTheme.lightGrey
            )
        }
    }
}


@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun PaymentButton(
    modifier: Modifier = Modifier,
    background: List<Color>,
    enable: Boolean,
    onClick: () -> Unit,
    contentText: String,
) {
    var loading by remember { mutableStateOf(false) }
    val gradient = Brush.horizontalGradient(colors = background)
    var success by remember { mutableStateOf(false) }
    val interactionSource = remember { MutableInteractionSource() }
    val lottiAnimation by rememberLottieComposition(LottieCompositionSpec.Asset("ic_check2.json"))
    val progress by animateLottieCompositionAsState(
        composition = lottiAnimation,
        iterations = iterationsSplashScreen,
        isPlaying = success
    )
    val coroutineScope = rememberCoroutineScope()
    val context = LocalContext.current
    val mediaPlayer = remember { MediaPlayer.create(context, R.raw.apple_pay_succes) }
    val vibrationResponse = remember {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.S) {
            (context.getSystemService(Context.VIBRATOR_MANAGER_SERVICE) as VibratorManager).defaultVibrator
        } else {
            context.getSystemService(Context.VIBRATOR_SERVICE) as Vibrator
        }
    }
    Button(
        modifier = modifier
            .fillMaxWidth()
            .height(50.dp),
        onClick = {
            loading = true
            onClick()
            coroutineScope.launch {
                delay(3000)
                loading = false
                success = true
                mediaPlayer.apply {
                    if (isPlaying) {
                        stop()
                    }
                    seekTo(0)
                    start()
                }
                vibrationResponse.vibrate(
                    VibrationEffect.createOneShot(
                        200,
                        VibrationEffect.DEFAULT_AMPLITUDE
                    )
                )
                delay(3000)
                success = false
            }
        },
        shape = RoundedCornerShape(MagicNumbers.BUTTON_SHAPE),
        colors =
        ButtonDefaults.buttonColors(
            containerColor = Transparent,
            contentColor = White,
            disabledContainerColor = LightColorTheme.brandColorDefault.copy(alpha = MagicNumbers.BUTTON_DISABLED_CONTAINER_COLOR)
        ),
        enabled = enable && !loading && !success,
        interactionSource = interactionSource,
        contentPadding = PaddingValues(0.dp)
    ) {
        Box(
            modifier = Modifier
                .background(gradient)
                .fillMaxSize(),
            contentAlignment = Alignment.Center
        ) {
            when {
                loading -> {
                    CircularProgressIndicator(
                        modifier = Modifier.size(20.dp),
                        color = White,
                        strokeWidth = 2.dp
                    )
                }

                success -> {
                    LottieAnimation(
                        composition = lottiAnimation,
                        progress = progress,
                        modifier = Modifier.fillMaxSize(),
                    )
                }

                else -> {
                    Text(
                        text = contentText,
                        fontSize = MagicNumbers.FIX_BUTTON_TEXT_BUTTON_FONT_SIZE.sp,
                        fontWeight = FontWeight.W600,
                        fontFamily = fontSFPro
                    )
                }
            }
        }
    }
}

