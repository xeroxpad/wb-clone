package com.example.wbtechnoschool.features

import android.graphics.drawable.Icon
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Icon
import androidx.compose.material3.Tab
import androidx.compose.material3.TabRow
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.wbtechnoschool.screens.ActiveMeetings
import com.example.wbtechnoschool.screens.AllMeetings
import com.example.wbtechnoschool.ui.theme.LightColorTheme
import com.example.wbtechnoschool.ui.theme.fontSFPro

@Composable
fun SwitchRow() {
    var tabIndex by remember { mutableStateOf(0) }
    val tabs = listOf("ВСЕ ВСТРЕЧИ", "АКТИВНЫЕ")
    TabRow(selectedTabIndex = tabIndex, modifier = Modifier.fillMaxWidth()) {
        tabs.forEachIndexed { index, title ->
            Tab(
                text = {
                    Text(
                        title,
                        fontSize = 18.sp,
                        fontWeight = FontWeight.W500,
                        fontFamily = fontSFPro
                    )
                },
                selected = tabIndex == index,
                onClick = { tabIndex = index },
                selectedContentColor = LightColorTheme.brandColorDefault,
                unselectedContentColor = LightColorTheme.accentGrey
            )
        }
    }
    when (tabIndex) {
        0 -> AllMeetings()
        1 -> ActiveMeetings()
    }
}