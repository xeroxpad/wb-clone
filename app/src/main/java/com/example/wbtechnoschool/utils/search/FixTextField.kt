package com.example.wbtechnoschool.utils.search

import android.telephony.PhoneNumberUtils
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.focus.onFocusChanged
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardCapitalization
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.wbtechnoschool.R
import com.example.wbtechnoschool.ui.theme.LightColorTheme
import com.example.wbtechnoschool.ui.theme.fontSFPro
import com.example.wbtechnoschool.utils.constants.MagicNumbers
import com.google.i18n.phonenumbers.AsYouTypeFormatter
import com.google.i18n.phonenumbers.NumberParseException
import com.google.i18n.phonenumbers.PhoneNumberUtil


@Composable
fun FixTextField() {
    var textState by remember { mutableStateOf(("")) }
    var isFocused by remember { mutableStateOf(false) }
    val focusManager = LocalFocusManager.current
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .clip(shape = RoundedCornerShape(MagicNumbers.FIX_TEXT_FIELD_SHAPE_RADIUS.dp))
            .background(LightColorTheme.fixLavenderBlush)
            .border(
                width = MagicNumbers.FIX_TEXT_FIELD_BOX_BORDER_WIDTH.dp,
                color = if (isFocused) LightColorTheme.brandColorDefault else Color.Transparent,
                shape = RoundedCornerShape(MagicNumbers.FIX_TEXT_FIELD_SHAPE_RADIUS.dp)
            )
            .padding(horizontal = MagicNumbers.FIX_TEXT_FIELD_BOX_PADDING_HORIZONTAL.dp)
            .height(MagicNumbers.FIX_TEXT_FIELD_BOX_HEIGHT.dp),
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .fillMaxHeight()
        ) {
            BasicTextField(
                value = textState,
                onValueChange = { textState = it },
                modifier = Modifier
                    .fillMaxWidth()
                    .onFocusChanged { focusState ->
                        isFocused = focusState.isFocused
                    },
                textStyle = TextStyle(
                    textAlign = TextAlign.Start,
                    color = Color.Black,
                    lineHeight = MagicNumbers.FIX_TEXT_FIELD_TEXT_STYLE_LINE_HEIGHT.sp,
                    fontWeight = FontWeight.W500,
                    fontFamily = fontSFPro,
                    fontSize = MagicNumbers.FIX_TEXT_FIELD_TEXT_STYLE_FONT_SIZE.sp,
                    letterSpacing = MagicNumbers.FIX_TEXT_FIELD_TEXT_STYLE_LETTER_SPACING.sp
                ),
                cursorBrush = SolidColor(LightColorTheme.fixVioletBlaze),
                keyboardOptions = KeyboardOptions(capitalization = KeyboardCapitalization.Words),
                decorationBox = { innerTextField ->
                    if (textState.isEmpty()) {
                        Text(
                            text = stringResource(id = R.string.name_and_second_name),
                            color = LightColorTheme.neutralDisabled,
                            style = TextStyle(lineHeight = MagicNumbers.FIX_TEXT_FIELD_DECORATION_BOX_TEXT_STYLE_LINE_HEIGHT.sp),
                            fontWeight = FontWeight.W500,
                            fontFamily = fontSFPro,
                            fontSize = MagicNumbers.FIX_TEXT_FIELD_DECORATION_BOX_TEXT_STYLE_FONT_SIZE.sp,
                            letterSpacing = MagicNumbers.FIX_TEXT_FIELD_DECORATION_BOX_LETTER_SPACING.sp,
                        )
                    }
                    innerTextField()
                }
            )
        }

    }
}

@Composable
fun FieldForNumber(onValueChange: (String) -> Unit) {
    var phoneNumber by remember { mutableStateOf("") }
    var isFocused by remember { mutableStateOf(false) }
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .clip(shape = RoundedCornerShape(MagicNumbers.FIX_TEXT_FIELD_SHAPE_RADIUS.dp))
            .background(LightColorTheme.fixLavenderBlush)
            .border(
                width = MagicNumbers.FIX_TEXT_FIELD_BOX_BORDER_WIDTH.dp,
                color = if (isFocused) LightColorTheme.brandColorDefault else Color.Transparent,
                shape = RoundedCornerShape(MagicNumbers.FIX_TEXT_FIELD_SHAPE_RADIUS.dp)
            )
            .padding(horizontal = MagicNumbers.FIX_TEXT_FIELD_BOX_PADDING_HORIZONTAL.dp)
            .height(MagicNumbers.FIX_TEXT_FIELD_BOX_HEIGHT.dp),
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .fillMaxHeight()
        ) {
            BasicTextField(
                value = phoneNumber,
                onValueChange = {
                    val digitsOnly = it.filter { it.isDigit() }
                    if (digitsOnly.length <= MagicNumbers.PHONE_MAX_LENGTH) {
                        phoneNumber = digitsOnly
                        onValueChange(digitsOnly)
                    }
                },
                modifier = Modifier
                    .fillMaxWidth()
                    .onFocusChanged { focusState ->
                        isFocused = focusState.isFocused
                    },
                textStyle = TextStyle(
                    textAlign = TextAlign.Start,
                    color = Color.Black,
                    lineHeight = MagicNumbers.FIX_TEXT_FIELD_TEXT_STYLE_LINE_HEIGHT.sp,
                    fontWeight = FontWeight.W500,
                    fontFamily = fontSFPro,
                    fontSize = MagicNumbers.FIX_TEXT_FIELD_TEXT_STYLE_FONT_SIZE.sp,
                    letterSpacing = MagicNumbers.FIX_TEXT_FIELD_TEXT_STYLE_LETTER_SPACING.sp
                ),
                cursorBrush = SolidColor(LightColorTheme.fixVioletBlaze),
                keyboardOptions = KeyboardOptions.Default.copy(
                    capitalization = KeyboardCapitalization.None,
                    keyboardType = KeyboardType.Phone
                ),
                visualTransformation = FormatPhoneNumber(),
                decorationBox = { innerTextField ->
                    if (phoneNumber.isEmpty()) {
                        Text(
                            text = stringResource(id = R.string.placeholder_number),
                            color = LightColorTheme.neutralDisabled,
                            style = TextStyle(
                                lineHeight = MagicNumbers.FIX_TEXT_FIELD_DECORATION_BOX_TEXT_STYLE_LINE_HEIGHT.sp,
                                fontWeight = FontWeight.W500,
                                fontFamily = fontSFPro,
                                fontSize = MagicNumbers.FIX_TEXT_FIELD_DECORATION_BOX_TEXT_STYLE_FONT_SIZE.sp,
                                letterSpacing = MagicNumbers.FIX_TEXT_FIELD_DECORATION_BOX_LETTER_SPACING.sp
                            )
                        )
                    }
                    innerTextField()
                }
            )
        }
    }
}
