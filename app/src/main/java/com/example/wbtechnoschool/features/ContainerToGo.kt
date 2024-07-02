package com.example.wbtechnoschool.features

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.wbtechnoschool.R
import com.example.wbtechnoschool.ui.theme.LightColorTheme
import com.example.wbtechnoschool.ui.theme.fontSFPro

@Composable
fun ContainerToGo(
    icon: Int,
    title: String,
    onClick: () -> Unit,
    sizeIcon: Dp = 30.dp,
    paddingIcon: Dp = 4.dp
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .clip(RoundedCornerShape(10.dp))
            .height(60.dp)
            .clickable(onClick = { onClick() }),
        verticalAlignment = Alignment.CenterVertically,
    ) {
        Icon(
            painter = painterResource(id = icon),
            contentDescription = "иконка контейнера",
            modifier = Modifier
                .size(sizeIcon)
                .padding(start = paddingIcon),
            tint = LightColorTheme.neutralActive
        )
        Spacer(modifier = Modifier.width(10.dp))
        Text(
            text = title,
            fontSize = 18.sp,
            fontFamily = fontSFPro,
            fontWeight = FontWeight.W600,
        )
        Spacer(modifier = Modifier.weight(1.8f))
        Icon(
            painter = painterResource(id = R.drawable.icon_go),
            contentDescription = "перейти",
            modifier = Modifier
                .size(18.dp)
                .padding(end = 4.dp)
        )
    }
}