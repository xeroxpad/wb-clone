package com.example.wbtechnoschool.utils.search

import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.PaddingValues
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
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp
import com.example.wbtechnoschool.R
import com.example.wbtechnoschool.ui.theme.LightColorTheme
import com.example.wbtechnoschool.utils.constants.MagicNumbers

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
                placeholder = {
                    Text(
                        stringResource(id = R.string.text_placeholder_search),
                        color = LightColorTheme.neutralDisabled
                    )
                },
                visualTransformation = VisualTransformation.None,
                singleLine = true,
                leadingIcon = {
                    Icon(
                        Icons.Filled.Search,
                        contentDescription = null,
                        tint = LightColorTheme.neutralDisabled
                    )
                },
                trailingIcon = {
                    when {
                        text.isNotEmpty() ->
                            IconButton(onClick = {
                                text = ""
                            }) {
                                Icon(
                                    imageVector = Icons.Filled.Clear,
                                    contentDescription = null
                                )
                            }
                    }
                },
                colors =
                TextFieldDefaults.colors(
                    unfocusedTextColor = Color.Transparent,
                    unfocusedIndicatorColor = Color.Transparent,
                    focusedIndicatorColor = Color.Transparent,
                    cursorColor = LightColorTheme.neutralActive,
                    focusedLeadingIconColor = LightColorTheme.neutralActive,
                    focusedTextColor = LightColorTheme.neutralActive,
                    unfocusedContainerColor = LightColorTheme.neutralSecondaryBG,
                    focusedContainerColor = LightColorTheme.neutralSecondaryBG
                ),
                shape = RoundedCornerShape(MagicNumbers.APP_SEARCH_BAR_SHAPE.dp),
                contentPadding = PaddingValues(MagicNumbers.APP_SEARCH_CONTENT_PADDING.dp)
            )
        }
    )
}
