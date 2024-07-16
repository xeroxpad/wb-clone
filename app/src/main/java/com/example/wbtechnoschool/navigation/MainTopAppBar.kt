package com.example.wbtechnoschool.navigation

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.wbtechnoschool.R
import com.example.wbtechnoschool.ui.theme.LightColorTheme
import com.example.wbtechnoschool.utils.MagicNumbers
import com.example.wbtechnoschool.utils.SPACER

@Composable
fun MainTopAppBar(
    modifier: Modifier = Modifier,
    title: String? = null,
    actionsIcon: Int? = null,
    actionsTint: Color = LightColorTheme.neutralActive,
    iconBack: (() -> Unit)? = null,
    actions: (() -> Unit)? = null,
) {
    Row(
        modifier = modifier
            .padding(horizontal = MagicNumbers.MAIN_TOP_BAR_ROW_PADDING_HORIZONTAL.dp)
            .fillMaxWidth()
            .height(MagicNumbers.MAIN_TOP_BAR_ROW_HEIGHT.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        iconBack?.let {
            IconButton(onClick = iconBack) {
                Icon(
                    painter = painterResource(id = R.drawable.arrow_back),
                    contentDescription = null,
                    modifier = Modifier
                        .size(MagicNumbers.MAIN_TOP_BAR_ICON_SIZE.dp)
                )
            }
        }
        Spacer(modifier = Modifier.width(SPACER.SPACER_5.value.dp))
        title?.let {
            Text(
                text = title,
                fontSize = MagicNumbers.MAIN_TOP_BAR_TEXT_FONT_SIZE.sp,
                fontWeight = FontWeight.W600,
                color = LightColorTheme.neutralActive
            )
        }
        Spacer(modifier = Modifier.weight(MagicNumbers.MAIN_TOP_BAR_SPACER_WEIGHT))
        if (actions != null && actionsIcon != null) {
            IconButton(onClick = actions) {
                Icon(
                    painter = painterResource(id = actionsIcon),
                    contentDescription = null,
                    tint = actionsTint,
                    modifier = Modifier
                        .size(MagicNumbers.MAIN_TOP_BAR_ICON_SIZE.dp)
                )
            }
        }
    }
}