package com.example.wbtechnoschool.avatar

import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.zIndex
import com.example.wbtechnoschool.R
import com.example.wbtechnoschool.ui.theme.LightGrey
import com.example.wbtechnoschool.ui.theme.fontSFPro


@Composable
fun TestRowAvatars() {
    val arrayImage = listOf(
        painterResource(id = R.drawable.avatars),
        painterResource(id = R.drawable.nature),
        painterResource(id = R.drawable.avatars),
        painterResource(id = R.drawable.nature),
        painterResource(id = R.drawable.avatars),
        painterResource(id = R.drawable.nature),
        painterResource(id = R.drawable.avatars),
        painterResource(id = R.drawable.avatars),
        painterResource(id = R.drawable.avatars),
        painterResource(id = R.drawable.avatars),
        painterResource(id = R.drawable.avatars),
        painterResource(id = R.drawable.avatars),
    )
    Row(
        horizontalArrangement = Arrangement.spacedBy(
            when (arrayImage.size) {
                1 -> 0.dp
                2 -> 5.dp
                3 -> 3.dp
                4 -> -3.dp
                else -> -15.dp
            }
        ),
        modifier = Modifier
            .fillMaxWidth()
            .zIndex(-1f),
        verticalAlignment = Alignment.CenterVertically,
    ) {
        for (i in arrayImage.withIndex().take(5)) {
            val zIndex = (arrayImage.size - i.index).toFloat()
            Box(
                modifier = Modifier
                    .zIndex(zIndex)
                    .padding(vertical = 5.dp)
                    .size(50.dp)
                    .border(2.dp, LightGrey, RoundedCornerShape(40))

            ) {
                MyPreviewAvatar(
                    painter = i.value,
                    modifier = Modifier
                        .fillMaxSize()
                        .align(Alignment.Center)
                        .clip(CircleShape)
                        .clickable {},
                    contentDescription = null,
                    contentScale = ContentScale.Crop,
                )
            }
        }
        if (arrayImage.size > 5) {
            Text(
                text = "+ ${arrayImage.size - 5}",
                fontSize = 14.sp,
                fontFamily = fontSFPro,
                fontWeight = FontWeight.Bold,
                modifier = Modifier.padding(20.dp)
            )
        }
    }
}



