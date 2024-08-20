package com.example.wbtechnoschool.utils.button

import androidx.compose.foundation.background
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Color.Companion.Transparent
import androidx.compose.ui.graphics.Color.Companion.White
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.wbtechnoschool.R
import com.example.wbtechnoschool.ui.theme.LightColorTheme
import com.example.wbtechnoschool.utils.constants.MagicNumbers

@Composable
fun SubscribeButton(
    modifier: Modifier = Modifier,
    background: List<Color>,
) {
    val gradient = Brush.horizontalGradient(colors = background)
    val interactionSource = remember { MutableInteractionSource() }
    var isSubscribed by remember { mutableStateOf(false) }
    Button(
        modifier = modifier
            .fillMaxWidth()
            .height(40.dp),
        onClick = { isSubscribed = !isSubscribed },
        shape = RoundedCornerShape(MagicNumbers.BUTTON_SHAPE),
        colors =
        ButtonDefaults.buttonColors(
            containerColor = Transparent,
            contentColor = White,
            disabledContainerColor = LightColorTheme.brandColorDefault.copy(alpha = MagicNumbers.BUTTON_DISABLED_CONTAINER_COLOR)
        ),
        interactionSource = interactionSource,
        contentPadding = PaddingValues(0.dp)
    ) {
        if (isSubscribed) {
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .background(LightColorTheme.fixVioletBlaze),
                contentAlignment = Alignment.Center
            ) {
                Icon(
                    painter = painterResource(id = R.drawable.icon_subscribe),
                    contentDescription = null,
                )
            }
        } else {
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .background(gradient),
                contentAlignment = Alignment.Center
            ) {
                Icon(
                    painter = painterResource(id = R.drawable.icon_add),
                    contentDescription = null,
                    tint = LightColorTheme.fixVioletBlaze
                )
            }
        }
    }
}
