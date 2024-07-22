package com.example.wbtechnoschool.utils.avatar

import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.zIndex
import com.example.wbtechnoschool.R
import com.example.wbtechnoschool.ui.theme.LightGrey
import com.example.wbtechnoschool.utils.constants.MagicNumbers

@Composable
fun MyMainAvatar(
    modifier: Modifier = Modifier,
    painter: Painter,
    contentDescription: String?,
    contentScale: ContentScale = ContentScale.Crop,
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
    contentDescription: String?,
    contentScale: ContentScale = ContentScale.Crop,
) {
    Box(
        modifier = Modifier
            .size(MagicNumbers.ROW_LIST_AVATAR_BOX_SIZE.dp)
            .clip(RoundedCornerShape(MagicNumbers.ROW_LIST_AVATAR_BOX_BORDER_SHAPE))
    ) {
        Image(
            modifier = modifier,
            painter = painterResource(id = R.drawable.avatars),
            contentDescription = contentDescription,
            contentScale = contentScale,
        )
    }
}