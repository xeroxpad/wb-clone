package com.example.wbtechnoschool.navigation

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.wbtechnoschool.R
import com.example.wbtechnoschool.ui.theme.LightColorTheme
import com.example.wbtechnoschool.utils.constants.MagicNumbers

@Composable
fun MainTopAppBar(
    modifier: Modifier = Modifier,
    title: String? = null,
    iconBack: (() -> Unit)? = null,
    iconShare: Int? = R.drawable.icon_share,
    onIconShareOrIconEditClick: (() -> Unit)? = null
) {
    Row(
        modifier = modifier,
        verticalAlignment = Alignment.CenterVertically,
    ) {
        iconBack?.let {
            Box(
                modifier = Modifier
                    .clip(shape = RoundedCornerShape(16.dp))
                    .size(44.dp)
                    .weight(0.5f)
                    .clickable(onClick = iconBack),
                contentAlignment = Alignment.Center
            ) {
                Icon(
                    painter = painterResource(id = R.drawable.icon_back),
                    contentDescription = null,
                    tint = LightColorTheme.fixVioletBlaze,
                    modifier = Modifier
                        .size(24.dp)
                )
            }
        }
        title?.let {
            Box(
                contentAlignment = Alignment.Center,
                modifier = Modifier.weight(3f)
            ) {
                Text(
                    text = title,
                    fontSize = MagicNumbers.MAIN_TOP_BAR_TEXT_FONT_SIZE.sp,
                    fontWeight = FontWeight.W500,
                    color = LightColorTheme.neutralActive,
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis,
                )
            }
        } ?: Spacer(modifier = Modifier.size(44.dp))
        iconShare?.let {
            Box(
                modifier = Modifier
                    .clip(shape = RoundedCornerShape(16.dp))
                    .size(44.dp)
                    .weight(0.5f)
                    .clickable(onClick = { onIconShareOrIconEditClick?.invoke() }),
                contentAlignment = Alignment.Center
            ) {
                Icon(
                    painter = painterResource(iconShare),
                    contentDescription = null,
                    tint = LightColorTheme.fixVioletBlaze,
                    modifier = Modifier
                        .size(24.dp)
                )
            }
        }
    }
}

@Composable
fun ProfileTopAppBar(
    modifier: Modifier = Modifier,
    isEditing: Boolean,
    onBackClick: () -> Unit,
    onEditClick: () -> Unit,
    iconShareOrEdit: Int,
    onIconShareOrIconEditClick: () -> Unit,
) {
    Row(
        modifier = modifier,
        verticalAlignment = Alignment.CenterVertically,
    ) {
        Box(
            modifier = Modifier
                .clip(shape = RoundedCornerShape(16.dp))
                .size(44.dp)
                .weight(0.5f)
                .clickable(onClick = { onBackClick() }),
            contentAlignment = Alignment.Center
        ) {
            Icon(
                painter = if (!isEditing) painterResource(id = R.drawable.icon_back) else painterResource(
                    id = R.drawable.ic_close
                ),
                contentDescription = null,
                tint = LightColorTheme.fixVioletBlaze,
                modifier = Modifier
                    .size(24.dp)
            )
        }
        Box(
            contentAlignment = Alignment.Center,
            modifier = Modifier.weight(3f)
        ) {
            Text(
                text = "",
                fontSize = MagicNumbers.MAIN_TOP_BAR_TEXT_FONT_SIZE.sp,
                fontWeight = FontWeight.W500,
                color = LightColorTheme.neutralActive,
                maxLines = 1,
                overflow = TextOverflow.Ellipsis,
            )
        }
        Box(
            modifier = Modifier
                .clip(shape = RoundedCornerShape(16.dp))
                .size(44.dp)
                .weight(0.5f)
                .clickable(onClick = {
                    if (iconShareOrEdit == R.drawable.icon_share) {
                        onIconShareOrIconEditClick()
                    } else {
                        onEditClick()
                    }
                }),
            contentAlignment = Alignment.Center
        ) {
            Icon(
                painter = if (isEditing) painterResource(id = R.drawable.icon_bird) else painterResource(
                    id = iconShareOrEdit
                ),
                contentDescription = null,
                tint = LightColorTheme.fixVioletBlaze,
                modifier = Modifier
                    .size(24.dp)
            )
        }
    }
}

