package com.example.wbtechnoschool.screens.meetings

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.wbtechnoschool.ui.theme.LightColorTheme
import com.example.wbtechnoschool.utils.tags.FixFilterTags

@OptIn(ExperimentalLayoutApi::class)
@Composable
fun SelectOtherMeetings(
    modifier: Modifier = Modifier,
    tags: List<String>
) {
    var selectedTags by remember { mutableStateOf(setOf<String>()) }
    Column(modifier = modifier) {
        Text(
            text = "Другие встречи",
            fontSize = 20.sp,
            fontWeight = FontWeight.Bold,
            color = LightColorTheme.black,
            modifier = Modifier.padding(bottom = 16.dp)
        )
        FlowRow(
            modifier = Modifier.fillMaxWidth()
        ) {
            tags.forEach { tag ->
                FixFilterTags(
                    labelText = tag,
                    isSelected = selectedTags.contains(tag),
                    onSelectionChanged = { isSelected ->
                        selectedTags = if (isSelected) {
                            selectedTags + tag
                        } else {
                            selectedTags - tag
                        }
                    },
                    modifier = Modifier.padding(end = 10.dp)
                )
            }
        }
    }
}