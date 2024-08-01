package com.example.wbtechnoschool.utils.search

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
import com.example.wbtechnoschool.utils.constants.MagicNumbers

@Composable
fun CustomTextFieldForProfile(
    modifier: Modifier = Modifier,
    textPlaceholder: String,
    textChange: (String) -> Unit,
    text: String
) {
    BasicTextField(
        value = text,
        onValueChange = { textChange(it) },
        modifier =
        modifier
            .background(
                LightColorTheme.neutralSecondaryBG,
                RoundedCornerShape(MagicNumbers.CUSTOM_TF_FOR_PROFILE_BASIC_TF_SHAPE.dp)
            ).fillMaxWidth(),
        decorationBox = { innerTextField ->
            Box(
                contentAlignment = Alignment.CenterStart,
                modifier =
                Modifier
                    .padding(horizontal = MagicNumbers.CUSTOM_TF_FOR_PROFILE_DECORATION_BOX_PADDING_HORIZONTAL.dp)
                    .height(MagicNumbers.CUSTOM_TF_FOR_PROFILE_DECORATION_BOX_PADDING_HEIGHT.dp)
            ) {
                when {
                    text.isEmpty() -> {
                        Text(
                            text = textPlaceholder,
                            color = LightColorTheme.neutralDisabled,
                            fontWeight = FontWeight.W600,
                            fontSize = MagicNumbers.CUSTOM_TF_FOR_PROFILE_DECORATION_BOX_TEXT_FONT_SIZE.sp,
                            fontFamily = fontSFPro,
                            letterSpacing = MagicNumbers.CUSTOM_TF_FOR_PROFILE_DECORATION_BOX_TEXT_LETTER_SPACING.sp
                        )
                    }
                }
                innerTextField()
            }
        },
        textStyle =
        TextStyle(
            fontWeight = FontWeight.W600,
            fontSize = MagicNumbers.CUSTOM_TF_FOR_PROFILE_DECORATION_BOX_TEXT_STYLE_FONT_SIZE.sp,
            fontFamily = fontSFPro,
            letterSpacing = MagicNumbers.CUSTOM_TF_FOR_PROFILE_DECORATION_BOX_TEXT_STYLE_LETTER_SPACING.sp,
            color = LightColorTheme.neutralActive
        ),
        singleLine = true,
        cursorBrush = SolidColor(LightColorTheme.neutralActive),
        keyboardOptions =
        KeyboardOptions.Default.copy(
            keyboardType = KeyboardType.Text,
            capitalization = KeyboardCapitalization.Words
        )
    )
}
