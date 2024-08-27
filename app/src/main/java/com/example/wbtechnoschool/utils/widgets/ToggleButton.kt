package com.example.wbtechnoschool.utils.widgets

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.example.wbtechnoschool.R
import com.example.wbtechnoschool.ui.theme.LightColorTheme
import com.example.wbtechnoschool.utils.button.StatusButton

@Composable
fun GradientToggleButton(
    modifier: Modifier = Modifier,
    isSelected: (Boolean) -> Unit,
) {
    var isGoing by remember { mutableStateOf(true) }
    val gradientIsGoing = Brush.horizontalGradient(
        colors = listOf(
            LightColorTheme.fixBlushPink,
            LightColorTheme.fixFuchsiaGlow,
            LightColorTheme.fixVividViolet,
            LightColorTheme.fixElectricViolet,
            LightColorTheme.fixRadiantMagenta,
            LightColorTheme.fixVioletBlaze,
            LightColorTheme.fixNeonLavender,
            LightColorTheme.fixRoyalIndigo
        )
    )
    val gradientNotGoing = Brush.horizontalGradient(
        colors = listOf(
            LightColorTheme.blushPink,
            LightColorTheme.petalPink,
            LightColorTheme.cottonCandy,
            LightColorTheme.lavenderMist,
            LightColorTheme.softLilac,
            LightColorTheme.paleLavender,
            LightColorTheme.lavenderWhisper,
            LightColorTheme.frostedViolet
        )
    )
    val gradient = if (isGoing) gradientIsGoing else gradientNotGoing
    val contentText = if (isGoing) stringResource(id = R.string.go_to_the_meetings) else stringResource(id = R.string.go_another_time_meetings)
    Box(
        modifier = modifier
            .clip(shape = RoundedCornerShape(16.dp))
            .height(56.dp)
            .background(gradient)
            .fillMaxWidth(),
        contentAlignment = Alignment.Center
    ) {
        StatusButton(
            modifier = Modifier.matchParentSize(),
            onClick = {
                isGoing = !isGoing
                isSelected(isGoing)
            },
            contentText = contentText,
            isGoing = isGoing,
        )
    }
}
