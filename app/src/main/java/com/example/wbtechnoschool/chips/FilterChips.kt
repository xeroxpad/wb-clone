package com.example.wbtechnoschool.chips

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.wbtechnoschool.ui.theme.LightColorTheme

@Composable
fun FilterChips(labelText: String) {
    Box(
        modifier = Modifier
            .padding(end = 10.dp, top = 5.dp, bottom = 5.dp)
            .height(25.dp)
            .clip(RoundedCornerShape(40.dp))
            .background(LightColorTheme.brandColorBG),
        contentAlignment = Alignment.Center,
    ) {
        Text(
            text = labelText,
            color = LightColorTheme.brandColorDark,
            fontSize = 10.sp,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.padding(horizontal = 10.dp),
        )
    }
}