package com.example.wbtechnoschool.utils.search

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Icon
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
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardCapitalization
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.wbtechnoschool.R
import com.example.wbtechnoschool.ui.theme.LightColorTheme
import com.example.wbtechnoschool.ui.theme.fontSFPro
import com.example.wbtechnoschool.utils.constants.MagicNumbers


@Composable
fun FixTextField(placeholder: Int, text: String, textChange: (String) -> Unit) {
    var textState by remember { mutableStateOf(("")) }
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
                value = text,
                onValueChange = { textChange(it) },
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
                maxLines = 1,
                cursorBrush = SolidColor(LightColorTheme.fixVioletBlaze),
                keyboardOptions = KeyboardOptions(capitalization = KeyboardCapitalization.Words),
                decorationBox = { innerTextField ->
                    when {
                        text.isEmpty() -> {
                            Text(
                                text = stringResource(id = placeholder),
                                color = LightColorTheme.neutralDisabled,
                                style = TextStyle(lineHeight = MagicNumbers.FIX_TEXT_FIELD_DECORATION_BOX_TEXT_STYLE_LINE_HEIGHT.sp),
                                fontWeight = FontWeight.W500,
                                fontFamily = fontSFPro,
                                fontSize = MagicNumbers.FIX_TEXT_FIELD_DECORATION_BOX_TEXT_STYLE_FONT_SIZE.sp,
                                letterSpacing = MagicNumbers.FIX_TEXT_FIELD_DECORATION_BOX_LETTER_SPACING.sp,
                            )
                        }
                    }
                    innerTextField()
                }
            )
        }

    }
}

@Composable
fun TextFieldForCode(
    placeholder: Int,
    textChange: (String) -> Unit,
    onValueChange: (String) -> Unit
) {
    var textState by remember { mutableStateOf(("")) }
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
                value = textState,
//                onValueChange = { textState = it },
                onValueChange = {
                    val digitsOnly = it.filter { it.isDigit() }
                    if (digitsOnly.length <= MagicNumbers.CODE_MAX_LENGTH) {
                        textState = digitsOnly
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
                maxLines = 1,
                cursorBrush = SolidColor(LightColorTheme.fixVioletBlaze),
                keyboardOptions = KeyboardOptions.Default.copy(
                    capitalization = KeyboardCapitalization.None,
                    keyboardType = KeyboardType.Phone
                ),
                decorationBox = { innerTextField ->
                    when {
                        textState.isEmpty() -> {
                            Text(
                                text = stringResource(id = placeholder),
                                color = LightColorTheme.neutralDisabled,
                                style = TextStyle(lineHeight = MagicNumbers.FIX_TEXT_FIELD_DECORATION_BOX_TEXT_STYLE_LINE_HEIGHT.sp),
                                fontWeight = FontWeight.W500,
                                fontFamily = fontSFPro,
                                fontSize = MagicNumbers.FIX_TEXT_FIELD_DECORATION_BOX_TEXT_STYLE_FONT_SIZE.sp,
                                letterSpacing = MagicNumbers.FIX_TEXT_FIELD_DECORATION_BOX_LETTER_SPACING.sp,
                            )
                        }
                    }
                    innerTextField()
                }
            )
        }

    }
}

@Composable
fun FixSearchTextField(modifier: Modifier = Modifier, placeholder: Int, onClick: () -> Unit) {
    var textState by remember { mutableStateOf(("")) }
    var isFocused by remember { mutableStateOf(false) }
    Row(verticalAlignment = Alignment.CenterVertically) {
        Box(
            modifier = modifier
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
                Icon(
                    painter = painterResource(id = R.drawable.search),
                    contentDescription = null,
                    tint = LightColorTheme.indigoTwilight,
                    modifier = Modifier
                        .size(25.dp)
                )
                Spacer(modifier = Modifier.width(5.dp))
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
                        fontSize = 16.sp,
                        letterSpacing = 1.sp,
                    ),
                    cursorBrush = SolidColor(LightColorTheme.fixVioletBlaze),
                    keyboardOptions = KeyboardOptions(capitalization = KeyboardCapitalization.Sentences),
                    decorationBox = { innerTextField ->
                        if (textState.isEmpty()) {
                            Text(
                                text = stringResource(id = placeholder),
                                color = LightColorTheme.indigoTwilight,
                                style = TextStyle(lineHeight = MagicNumbers.FIX_TEXT_FIELD_DECORATION_BOX_TEXT_STYLE_LINE_HEIGHT.sp),
                                fontWeight = FontWeight.W500,
                                fontFamily = fontSFPro,
                                fontSize = 16.sp,
                                letterSpacing = 1.sp,
                                maxLines = 1,
                                overflow = TextOverflow.Ellipsis,
                            )
                        }
                        innerTextField()
                    }
                )
            }
        }
        Spacer(
            modifier = Modifier
                .width(10.dp)
        )
        Box(modifier = Modifier
            .size(44.dp)
            .clip(shape = RoundedCornerShape(16.dp))
            .clickable { onClick() },
            contentAlignment = Alignment.Center
        ) {
            Icon(
                painter = painterResource(id = R.drawable.icon_user),
                contentDescription = null,
                tint = LightColorTheme.fixVioletBlaze,
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
