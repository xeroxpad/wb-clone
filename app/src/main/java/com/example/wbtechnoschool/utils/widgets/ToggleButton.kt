package com.example.wbtechnoschool.utils.widgets

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import com.example.wbtechnoschool.R
import com.example.wbtechnoschool.ui.theme.LightColorTheme
import com.example.wbtechnoschool.utils.button.StatusButton
import com.example.wbtechnoschool.utils.button.StatusOutlinedButton

@Composable
fun ToggleButton(
    modifier: Modifier = Modifier,
    isSelected: (Boolean) -> Unit
) {
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
                contentText = stringResource(id = R.string.go_to_the_meetings),
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
                contentText = stringResource(id = R.string.go_another_time_meetings),
                modifier = modifier
            )
        }
    }
}
