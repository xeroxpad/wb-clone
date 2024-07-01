package com.example.wbtechnoschool.search

import androidx.compose.foundation.border
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Clear
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.focusModifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp
import com.example.wbtechnoschool.ui.theme.LightColorTheme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AppSearchBar(modifier: Modifier = Modifier) {
    var text by rememberSaveable { mutableStateOf("") }
    val interactionSource = remember { MutableInteractionSource() }

    BasicTextField(
        value = text,
        onValueChange = { text = it },
        modifier = modifier,
        decorationBox = { innerTextField ->
            TextFieldDefaults.TextFieldDecorationBox(
                value = text,
                innerTextField = innerTextField,
                enabled = true,
                interactionSource = interactionSource,
                placeholder = { Text("Поиск", color = LightColorTheme.neutralDisabled) },
                visualTransformation = VisualTransformation.None,
                singleLine = true,
                leadingIcon = {
                    Icon(
                        Icons.Filled.Search,
                        contentDescription = "Поиск",
                        tint = LightColorTheme.neutralDisabled
                    )
                },
                trailingIcon = {
                    when {
                        text.isNotEmpty() -> IconButton(onClick = {
                            text = ""
                        }) {
                            Icon(
                                imageVector = Icons.Filled.Clear,
                                contentDescription = "Clear"
                            )
                        }
                    }
                },
                colors = TextFieldDefaults.colors(
                    unfocusedTextColor = Color.Transparent,
                    unfocusedIndicatorColor = Color.Transparent,
                    focusedIndicatorColor = Color.Transparent,
                    cursorColor = LightColorTheme.neutralActive,
                    focusedLeadingIconColor = LightColorTheme.neutralActive,
                    focusedTextColor = LightColorTheme.neutralActive,
                    ),
                shape = RoundedCornerShape(8.dp),
            )
        }
    )


}