package com.example.wbtechnoschool.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextRange
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.wbtechnoschool.R
import com.example.wbtechnoschool.button.StatusTextButton
import com.example.wbtechnoschool.ui.theme.LightColorTheme
import com.example.wbtechnoschool.ui.theme.fontSFPro

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ScreenEntryCode() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(20.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = stringResource(id = R.string.enter_code),
            fontWeight = FontWeight.W700,
            fontSize = 24.sp,
            fontFamily = fontSFPro,
            color = LightColorTheme.neutralActive
        )
        Spacer(modifier = Modifier.height(15.dp))
        Text(
            text = "Отправили код на номер\n+7 999 99-99-99",
            fontWeight = FontWeight.W400,
            fontSize = 14.sp,
            fontFamily = fontSFPro,
            color = LightColorTheme.neutralActive,
            textAlign = TextAlign.Center,
            lineHeight = 20.sp
        )
        Spacer(modifier = Modifier.height(60.dp))
        var codeText by remember { mutableStateOf("") }
        val onNumberEntered: (String, Boolean) -> Unit = { text, isComplete ->
            codeText = text
            isComplete
        }
        EntryCode(
            codeText = codeText,
            countNumber = 4,
            numberEnter = onNumberEntered
        )
        Spacer(modifier = Modifier.height(60.dp))
        StatusTextButton(
            contentColor = LightColorTheme.brandColorDefault,
            containerColor = Color.Transparent,
            enable = true,
            onClick = { /*TODO*/ },
            contentText = "Запросить код повторно",
            modifier = Modifier.fillMaxWidth()
        )
    }
}

@Composable
fun NumberView(
    index: Int,
    text: String,
) {
    val char = text.getOrNull(index)?.toString() ?: ""
    val contentColor = LightColorTheme.neutralActive
    Box(
        contentAlignment = Alignment.Center,
        modifier = Modifier
            .height(50.dp)
            .width(30.dp)
            .background(Color.Transparent)
    ) {
        if (char.isNotEmpty()) {
            Text(
                text = char,
                color = contentColor,
                fontSize = 30.sp,
                fontWeight = FontWeight.W700
            )
        } else {
            Box(
                modifier = Modifier
                    .clip(CircleShape)
                    .size(24.dp)
                    .background(LightColorTheme.neutralLine)
            )
        }
    }
}

@Composable
fun EntryCode(
    codeText: String,
    countNumber: Int = 4,
    numberEnter: (String, Boolean) -> Unit,
) {
    BasicTextField(
        value = TextFieldValue(codeText, selection = TextRange(codeText.length)),
        onValueChange = {
            if (it.text.length <= countNumber) {
                numberEnter.invoke(it.text, it.text.length == countNumber)
            }
        },
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
        decorationBox = {
            Row(
                horizontalArrangement = Arrangement.SpaceBetween, modifier = Modifier
                    .fillMaxWidth()
                    .padding(50.dp)
            ) {
                repeat(countNumber) { index ->
                    NumberView(
                        index = index,
                        text = codeText
                    )
                }
            }
        }
    )
}





