package com.example.wbtechnoschool.screens.meetings

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateMapOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.wbtechnoschool.utils.tags.FixFilterTags

@OptIn(ExperimentalLayoutApi::class)
@Composable
fun SelectOtherMeetings(
    modifier: Modifier = Modifier,
    tags: List<String> = listOf(
        "Дизайн", "Разработка", "Продакт менеджмент", "Проджект менеджмент",
        "Backend", "Frontend", "Mobile", "Тестирование", "Продажи",
        "Бизнес", "Безопасность", "Web", "Девопс", "Маркетинг", "Аналитика", "Все категории",
    ),
) {
    val selectedTags = remember { mutableStateMapOf<String, Boolean>() }
    tags.forEach { tag ->
        if (!selectedTags.contains(tag)) {
            selectedTags[tag] = false
        }
    }
    FlowRow(
        modifier = modifier.fillMaxWidth(),
        verticalArrangement = Arrangement.spacedBy((-5).dp)
    ) {
        tags.forEach { tag ->
            FixFilterTags(
                labelText = tag,
                isSelected = selectedTags[tag] == true,
                onTagClick = {
                    if (tag == "Все категории") {
                        val newState = !(selectedTags["Все категории"] ?: false)
                        tags.forEach { t ->
                            selectedTags[t] = newState
                        }
                    } else {
                        selectedTags[tag] = !(selectedTags[tag] ?: false)
                        selectedTags["Все категории"] = selectedTags.all { it.value }
                    }
                },
                modifier = Modifier.padding(end = 7.dp)
            )
        }
    }
}
