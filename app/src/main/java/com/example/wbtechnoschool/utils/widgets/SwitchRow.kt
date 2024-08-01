package com.example.wbtechnoschool.utils.widgets

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Tab
import androidx.compose.material3.TabRow
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.wbtechnoschool.screens.meetings.ActiveMeetings
import com.example.wbtechnoschool.screens.meetings.AllMeetings
import com.example.wbtechnoschool.ui.theme.LightColorTheme
import com.example.wbtechnoschool.ui.theme.fontSFPro
import com.example.wbtechnoschool.utils.constants.MagicNumbers

@Composable
fun SwitchRow(
    modifier: Modifier = Modifier,
    titleRow: List<String>,
    navController: NavController
) {
    var tabIndex by remember { mutableIntStateOf(0) }
    TabRow(selectedTabIndex = tabIndex, modifier = modifier.fillMaxWidth()) {
        titleRow.forEachIndexed { index, title ->
            Tab(
                text = {
                    Text(
                        title,
                        fontSize = MagicNumbers.SWITCH_ROW_TAB_TEXT_FONT_SIZE.sp,
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
        0 -> AllMeetings(navController)
        1 -> ActiveMeetings(navController)
    }
}
