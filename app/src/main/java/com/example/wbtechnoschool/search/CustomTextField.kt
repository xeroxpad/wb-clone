package com.example.wbtechnoschool.search

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardCapitalization
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.wbtechnoschool.ui.theme.LightColorTheme
import com.example.wbtechnoschool.ui.theme.fontSFPro

@Composable
fun CustomTextFieldForProfile(textPlaceholder: String, textChange: (String) -> Unit, text: String) {
    BasicTextField(
        value = text,
        onValueChange = { textChange(it) },
        modifier = Modifier
            .background(
                LightColorTheme.neutralSecondaryBG,
                RoundedCornerShape(5.dp)
            )
            .fillMaxWidth(),
        decorationBox = { innerTextField ->
            Box(
                contentAlignment = Alignment.CenterStart,
                modifier = Modifier
                    .padding(horizontal = 8.dp)
                    .height(36.dp)
            ) {
                if (text.isEmpty()) {
                    Text(
                        text = textPlaceholder,
                        color = LightColorTheme.neutralDisabled,
                        fontWeight = FontWeight.W600,
                        fontSize = 14.sp,
                        fontFamily = fontSFPro,
                        letterSpacing = 1.sp
                    )
                }
                innerTextField()
            }
        },
        textStyle = TextStyle(
            fontWeight = FontWeight.W600,
            fontSize = 14.sp,
            fontFamily = fontSFPro,
            letterSpacing = 1.sp,
            color = LightColorTheme.neutralActive
        ),
        singleLine = true,
        cursorBrush = SolidColor(LightColorTheme.neutralActive),
        keyboardOptions = KeyboardOptions.Default.copy(
            keyboardType = KeyboardType.Text,
            capitalization = KeyboardCapitalization.Words
        ),
    )
}