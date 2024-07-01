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
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.wbtechnoschool.R
import com.example.wbtechnoschool.navigation.SecondaryScreens.ScreenMyMeetings.route
import com.example.wbtechnoschool.ui.theme.LightColorTheme
import com.example.wbtechnoschool.ui.theme.fontSFPro
import okhttp3.Route

@Composable
fun ContainerToGo(
    icon: Int,
    title: String,
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .height(50.dp)
            .clickable(onClick = { })
            .clip(RoundedCornerShape(8.dp)),
        verticalAlignment = Alignment.CenterVertically,
    ) {
        Icon(painter = painterResource(id = icon), contentDescription = "иконка контейнера", modifier = Modifier
            .size(24.dp)
            .padding(start = 4.dp), tint = LightColorTheme.neutralActive)
        Spacer(modifier = Modifier.width(10.dp))
        Text(
            text = title,
            fontSize = 18.sp,
            fontFamily = fontSFPro,
            fontWeight = FontWeight.W600,
        )
        Spacer(modifier = Modifier.weight(1.8f))
        Icon(painter = painterResource(id = R.drawable.icon_go), contentDescription = "перейти", modifier = Modifier
            .size(18.dp)
            .padding(end = 4.dp))
    }
}