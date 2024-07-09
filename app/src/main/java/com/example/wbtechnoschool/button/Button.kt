package com.example.wbtechnoschool.button

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.IconButton
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Color.Companion.LightGray
import androidx.compose.ui.graphics.Color.Companion.White
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.wbtechnoschool.ui.theme.LightColorTheme

@Composable
fun AllButton(
    modifier: Modifier = Modifier,
    containerColor: Color,
    shadowColor: Color = Color.Transparent,
    enable: Boolean,
    onClick: () -> Unit,
) {
    Row(
        modifier = Modifier
            .fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        StatusButton(
            containerColor = containerColor,
            enable = enable,
            modifier = modifier,
            onClick = onClick,
            contentText = "Button"
        )
        StatusOutlinedButton(
            contentColor = containerColor,
            enable = enable,
            modifier = modifier,
            onClick = onClick,
            contentText = "Button"
        )
        StatusTextButton(
            contentColor = containerColor,
            enable = enable,
            containerColor = shadowColor,
            modifier = modifier,
            onClick = onClick,
            contentText = "Button"
        )
    }
}

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
        shape = RoundedCornerShape(78),
        modifier = modifier,
        colors = ButtonDefaults.buttonColors(
            containerColor = containerColor,
            contentColor = White,
            disabledContainerColor = LightColorTheme.brandColorDefault.copy(alpha = 0.5f)
        ),
        enabled = enable,
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
        shape = RoundedCornerShape(78),
        modifier = modifier,
        border = BorderStroke(
            width = 2.dp,
            color = contentColor
        ),
        colors = ButtonDefaults.buttonColors(
            containerColor = Color.Transparent,
            contentColor = contentColor,
        ),
        enabled = enable,
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
        shape = RoundedCornerShape(78),
        modifier = modifier,
        colors = ButtonDefaults.buttonColors(
            contentColor = contentColor,
            containerColor = containerColor,
        ),
        enabled = enable,
    ) {
        Text(text = contentText, fontSize = 20.sp)
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
        shape = RoundedCornerShape(78),
        modifier = modifier,
        border = BorderStroke(
            width = 2.dp,
            color = contentColor
        ),
        colors = ButtonDefaults.buttonColors(
            containerColor = Color.Transparent,
            contentColor = contentColor,
        ),
    ) {
        Icon(painter = painterResource(id = icon), contentDescription = "")
    }
}

