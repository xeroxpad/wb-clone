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

@Composable
fun MainTopAppBar(
    title: String? = null,
    iconBack: (() -> Unit)? = null,
    actions: (() -> Unit)? = null,
    actionsIcon: Int? = null,
    actionsTint: Color = LightColorTheme.neutralActive,
) {
    Row(
        modifier = Modifier
            .padding(start = 10.dp, end = 10.dp)
            .fillMaxWidth()
            .height(36.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        if (iconBack != null) {
            IconButton(onClick = iconBack) {
                Icon(
                    painter = painterResource(id = R.drawable.arrow_back),
                    contentDescription = "Назад",
                    modifier = Modifier
                        .size(16.dp)
                )
            }
        }
        Spacer(modifier = Modifier.width(7.dp))
        if (title != null) {
            Text(
                text = title,
                fontSize = 24.sp,
                fontWeight = FontWeight.W600,
                color = LightColorTheme.neutralActive
            )
        }
        Spacer(modifier = Modifier.weight(1f))
        if (actions != null && actionsIcon != null) {
            IconButton(onClick = actions) {
                Icon(
                    painter = painterResource(id = actionsIcon),
                    contentDescription = "",
                    tint = actionsTint,
                    modifier = Modifier
                        .size(18.dp)
                )
            }
        }
    }
}