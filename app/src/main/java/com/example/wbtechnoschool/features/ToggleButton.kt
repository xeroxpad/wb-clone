package com.example.wbtechnoschool.features

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.wbtechnoschool.button.StatusButton
import com.example.wbtechnoschool.button.StatusOutlinedButton
import com.example.wbtechnoschool.ui.theme.LightColorTheme

@Composable
fun ToggleButton(isSelected: (Boolean) -> Unit, modifier: Modifier = Modifier) {
    var isGoing by remember { mutableStateOf(true) }

    when {
        isGoing -> {
            StatusButton(
                containerColor = LightColorTheme.brandColorDefault,
                enable = true,
                onClick = {
                    isGoing = !isGoing
                    isSelected(isGoing)
                },
                contentText = "Пойду на встречу!",
                modifier = modifier
            )
        }

        else -> {
            StatusOutlinedButton(
                contentColor = LightColorTheme.brandColorDefault,
                enable = true,
                onClick = {
                    isGoing = !isGoing
                    isSelected(isGoing)
                },
                contentText = "Схожу в другой раз",
                modifier = modifier
            )
        }
    }
}