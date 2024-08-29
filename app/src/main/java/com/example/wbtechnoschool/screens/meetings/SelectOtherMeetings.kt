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
    tags: List<String>,
    isSelectable: Boolean = true,
    onTagSelected: ((Set<String>) -> Unit)? = null
) {
    var selectedTags by remember { mutableStateOf(setOf<String>()) }
    FlowRow(
        modifier = modifier.fillMaxWidth()
    ) {
        tags.forEach { tag ->
            FixFilterTags(
                labelText = tag,
                isSelected = selectedTags.contains(tag),
                onSelectionChanged = if (isSelectable) { isSelected ->
                    selectedTags = if (tag == "Все категории" && isSelected) {
                        tags.toSet()
                    } else if (tag == "Все категории" && !isSelected) {
                        emptySet()
                    } else if (isSelected) {
                        selectedTags + tag
                    } else {
                        selectedTags - tag
                    }
                    onTagSelected?.invoke(selectedTags)
                } else null,
                isSelectable = isSelectable,
                modifier = Modifier.padding(end = 7.dp)
            )
        }
    }
}
