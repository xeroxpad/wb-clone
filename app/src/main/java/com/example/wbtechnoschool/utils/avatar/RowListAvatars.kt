package com.example.wbtechnoschool.utils.avatar

import androidx.compose.foundation.background
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
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.zIndex
import com.example.wbtechnoschool.ui.theme.LightColorTheme
import com.example.wbtechnoschool.ui.theme.LightGrey
import com.example.wbtechnoschool.ui.theme.fontSFPro
import com.example.wbtechnoschool.utils.constants.MagicNumbers

const val take = 3
const val zIndex = 1F

@Composable
fun RowAvatars(
    modifier: Modifier = Modifier,
    arrayImage: List<String>
) {
    Row(
        horizontalArrangement =
        Arrangement.spacedBy(
            when (arrayImage.size) {
                1 -> 0.dp
                2 -> 5.dp
                3 -> 3.dp
                4 -> (-3).dp
                else -> (-15).dp
            }
        ),
        modifier =
        modifier
            .fillMaxWidth()
            .zIndex(-zIndex),
        verticalAlignment = Alignment.CenterVertically
    ) {
        for (i in arrayImage.withIndex().take(take)) {
            val zIndex = (arrayImage.size - i.index).toFloat()
            Box(
                modifier =
                Modifier
                    .zIndex(zIndex)
                    .padding(vertical = MagicNumbers.ROW_LIST_AVATAR_BOX_PADDING_VERTICAL.dp)
                    .size(MagicNumbers.ROW_LIST_AVATAR_BOX_SIZE.dp)
                    .border(
                        MagicNumbers.ROW_LIST_AVATAR_BOX_BORDER.dp,
                        LightGrey,
                        RoundedCornerShape(
                            MagicNumbers.ROW_LIST_AVATAR_BOX_BORDER_SHAPE
                        )
                    )
            ) {
                MyPreviewAvatar(
                    modifier =
                    Modifier
                        .fillMaxSize()
                        .align(Alignment.Center)
                        .clip(CircleShape)
                        .clickable {},
                    contentDescription = null,
                    contentScale = ContentScale.Crop,
                    model = "https://i.pinimg.com/originals/89/e5/8e/89e58e371fded01e2ccf40fdea5c2c4d.jpg"
                )
            }
        }
        if (arrayImage.size > take) {
            Text(
                text = "+ ${arrayImage.size - take}",
                fontSize = MagicNumbers.ROW_LIST_AVATAR_TEXT_FONT_SIZE.sp,
                fontFamily = fontSFPro,
                fontWeight = FontWeight.Bold,
                modifier = Modifier.padding(MagicNumbers.ROW_LIST_AVATAR_TEXT_PADDING.dp)
            )
        }
    }
}


@Composable
fun FixRowAvatars(
    modifier: Modifier = Modifier,
    arrayImage: List<String>
) {
    Row(
        horizontalArrangement =
        Arrangement.spacedBy(
            when (arrayImage.size) {
                1 -> 0.dp
                2 -> 5.dp
                3 -> 3.dp
                4 -> (-3).dp
                else -> (-15).dp
            }
        ),
        modifier =
        modifier
            .fillMaxWidth()
            .zIndex(-zIndex),
        verticalAlignment = Alignment.CenterVertically
    ) {
        for (i in arrayImage.withIndex().take(take)) {
            MyPreviewAvatar(
                modifier =
                Modifier
                    .size(MagicNumbers.ROW_LIST_AVATAR_SIZE_PREV_AVATAR.dp)
                    .clip(CircleShape)
                    .clickable {},
                contentDescription = null,
                contentScale = ContentScale.Crop,
                model = i.value
            )
        }
        if (arrayImage.size > take) {
            Box(
                modifier = Modifier
                    .size(MagicNumbers.ROW_LIST_AVATAR_SIZE_PREV_AVATAR.dp)
                    .clip(CircleShape)
                    .border(width = 3.dp, color = Color.White, shape = CircleShape)
                    .background(LightColorTheme.fixLavenderBlush),
                contentAlignment = Alignment.Center
            ){
                Text(
                    text = "+${arrayImage.size - take}",
                    fontSize = MagicNumbers.ROW_LIST_AVATAR_TEXT_FONT_SIZE.sp,
                    fontFamily = fontSFPro,
                    fontWeight = FontWeight.Bold,
                    color = LightColorTheme.fixVioletBlaze,
                )
            }
        }
    }
}
