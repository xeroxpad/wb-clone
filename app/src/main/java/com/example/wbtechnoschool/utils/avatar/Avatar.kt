package com.example.wbtechnoschool.utils.avatar

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.example.wbtechnoschool.utils.constants.MagicNumbers

@Composable
fun MyMainAvatar(
    modifier: Modifier = Modifier,
    painter: String,
    contentDescription: String?,
    contentScale: ContentScale = ContentScale.Crop
) {
    AsyncImage(
        modifier = modifier,
        model = painter,
        contentDescription = contentDescription,
        contentScale = contentScale
    )
}

@Composable
fun MyPreviewAvatar(
    modifier: Modifier = Modifier,
    painter: String,
    contentDescription: String?,
    contentScale: ContentScale = ContentScale.Crop
) {
    Box(
        modifier =
        Modifier
            .size(MagicNumbers.ROW_LIST_AVATAR_BOX_SIZE.dp)
            .clip(RoundedCornerShape(MagicNumbers.ROW_LIST_AVATAR_BOX_BORDER_SHAPE))
    ) {
        AsyncImage(
            modifier = modifier,
            model = painter,
            contentDescription = contentDescription,
            contentScale = contentScale
        )
    }
}
