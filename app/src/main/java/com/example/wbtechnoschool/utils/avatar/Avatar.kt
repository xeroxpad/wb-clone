package com.example.wbtechnoschool.utils.avatar

import android.net.Uri
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.example.wbtechnoschool.R
import com.example.wbtechnoschool.utils.constants.MagicNumbers

@Composable
fun MyMainAvatar(
    modifier: Modifier = Modifier,
    model: Any?,
    contentDescription: String?,
    contentScale: ContentScale = ContentScale.Crop
) {
    AsyncImage(
        modifier = modifier,
        model = model ?: R.drawable.default_icon,
        contentDescription = contentDescription,
        contentScale = contentScale
    )
}

@Composable
fun MyPreviewAvatar(
    modifier: Modifier = Modifier,
    model: String,
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
            model = model,
            contentDescription = contentDescription,
            contentScale = contentScale
        )
    }
}
