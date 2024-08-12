package com.example.wbtechnoschool.utils.search

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.wbtechnoschool.utils.constants.MagicNumbers

@Composable
fun FixTextField() {
    val textState = remember { mutableStateOf(TextFieldValue()) }

    TextField(
        value = textState.value,
        onValueChange = { textState.value = it },
        label = { Text(text = "Имя и фамилия") },
        modifier = Modifier
            .fillMaxWidth()
            .clip(shape = RoundedCornerShape(MagicNumbers.FIX_TEXT_FIELD_SHAPE_RADIUS.dp))
    )
}

@Preview
@Composable
fun PrevFixTextField() {
    FixTextField()
}