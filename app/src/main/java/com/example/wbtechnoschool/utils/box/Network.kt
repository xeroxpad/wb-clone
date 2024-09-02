package com.example.wbtechnoschool.utils.box

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.wbtechnoschool.ui.theme.LightColorTheme

@Composable
fun Network(modifier: Modifier = Modifier, icon: Int) {
    Box(
        modifier = Modifier
            .clip(shape = RoundedCornerShape(16.dp))
            .clickable { }
            .size(52.dp)
            .background(LightColorTheme.fixBrandColorDark),
        contentAlignment = Alignment.Center
    ) {
        Image(painter = painterResource(id = icon), contentDescription = null)
    }
}