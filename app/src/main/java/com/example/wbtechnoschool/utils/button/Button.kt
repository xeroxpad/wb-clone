package com.example.wbtechnoschool.utils.button

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
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
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.focusModifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Color.Companion.Transparent
import androidx.compose.ui.graphics.Color.Companion.White
import androidx.compose.ui.graphics.Paint
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
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
    containerColor: Color,
    enable: Boolean,
    onClick: () -> Unit,
    contentText: String
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
    icon: Int,
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
        Icon(painter = painterResource(id = icon), contentDescription = null)
    }
}

@Composable
fun FixGradientButton(
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

