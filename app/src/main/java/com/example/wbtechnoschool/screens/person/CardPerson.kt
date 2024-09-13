package com.example.wbtechnoschool.screens.person

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImagePainter
import coil.compose.rememberAsyncImagePainter
import coil.request.ImageRequest
import com.example.domain.entities.FixPerson
import com.example.wbtechnoschool.utils.avatar.FixMyAvatar
import com.example.wbtechnoschool.utils.constants.MagicNumbers.Companion.DEFAULT_AVATAR
import com.example.wbtechnoschool.utils.tags.FixTags

@Composable
fun CardPerson(user: FixPerson) {
    val painter = rememberAsyncImagePainter(
        ImageRequest.Builder(LocalContext.current).data(data = user.avatarUrl ?: DEFAULT_AVATAR)
            .apply(block = fun ImageRequest.Builder.() {
                crossfade(true)
            }).build()
    )
    Column(
        horizontalAlignment = Alignment.Start,
        modifier = Modifier
            .clip(shape = RoundedCornerShape(16.dp))
            .width(104.dp)
            .clickable { }
            .padding(5.dp)
    ) {
        Box(
            modifier = Modifier
                .height(104.dp)
                .clip(shape = RoundedCornerShape(16.dp)),
            contentAlignment = Alignment.Center
        ) {
            if (painter.state is AsyncImagePainter.State.Loading) {
                CircularProgressIndicator()
            }
            FixMyAvatar(
                model = user.avatarUrl
                    ?: "",
                contentDescription = null,
                modifier = Modifier
                    .clip(CircleShape)
                    .fillMaxSize()
            )
        }
        Text(
            text = user.name,
            fontWeight = FontWeight.W500,
            fontSize = 18.sp,
            color = Color.Black,
            maxLines = 1,
            overflow = TextOverflow.Ellipsis,
        )
        FixTags(
            labelText = user.interests,
        )
    }
}