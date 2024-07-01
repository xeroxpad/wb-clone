package com.example.wbtechnoschool.avatar

import androidx.compose.foundation.Image
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale

@Composable
fun MyMainAvatar(
    modifier: Modifier = Modifier,
    painter: Painter,
    contentDescription: String?,
    contentScale: ContentScale = ContentScale.Crop
) {
    Image(
        modifier = modifier,
        painter = painter,
        contentDescription = contentDescription,
        contentScale = contentScale
    )
}

@Composable
fun MyPreviewAvatar(
    modifier: Modifier = Modifier,
    painter: Painter,
    contentDescription: String?,
    contentScale: ContentScale = ContentScale.Crop
) {
    Image(
        modifier = modifier,
        painter = painter,
        contentDescription = contentDescription,
        contentScale = contentScale,
    )
}