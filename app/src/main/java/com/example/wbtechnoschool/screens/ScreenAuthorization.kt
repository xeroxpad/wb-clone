package com.example.wbtechnoschool.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.wbtechnoschool.R
import com.example.wbtechnoschool.button.StatusButton
import com.example.wbtechnoschool.navigation.Graph
import com.example.wbtechnoschool.ui.theme.LightColorTheme
import com.example.wbtechnoschool.ui.theme.fontSFPro

@Composable
fun ScreenAuthorization(navController: NavController) {
    Column(
        modifier = Modifier
            .statusBarsPadding()
            .fillMaxSize()
            .padding(start = 20.dp, end = 20.dp),
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        var number by rememberSaveable { mutableStateOf("") }
        Spacer(modifier = Modifier.height(96.dp))
        Text(
            text = stringResource(id = R.string.enter_number_phone),
            fontWeight = FontWeight.W700,
            fontSize = 24.sp,
            fontFamily = fontSFPro,
            color = LightColorTheme.neutralActive
        )
        Spacer(modifier = Modifier.height(15.dp))
        Text(
            text = "Мы вышлем код подтверждения\nна указанный номер",
            fontWeight = FontWeight.W400,
            fontSize = 14.sp,
            fontFamily = fontSFPro,
            color = LightColorTheme.neutralActive,
            textAlign = TextAlign.Center,
            lineHeight = 20.sp
        )
        Spacer(modifier = Modifier.height(60.dp))
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .height(40.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Box(
                modifier = Modifier
                    .background(
                        LightColorTheme.neutralSecondaryBG,
                        RoundedCornerShape(5.dp)
                    )
                    .width(60.dp)
                    .fillMaxHeight()
            ) {
                Row(modifier = Modifier.padding(10.dp)) {
                    Image(
                        painter = painterResource(id = R.drawable.icon_flag_russian),
                        contentDescription = "flag",
                        modifier = Modifier
                            .size(16.dp)
                            .clip(RoundedCornerShape(5.dp))
                    )
                    BasicTextField(
                        value = "+7",
                        onValueChange = {},
                        singleLine = true,
                        keyboardOptions = KeyboardOptions.Default.copy(keyboardType = KeyboardType.Number),
                        modifier = Modifier.padding(start = 5.dp),
                        textStyle = TextStyle(
                            color = LightColorTheme.neutralDisabled,
                            fontWeight = FontWeight.W600,
                            fontSize = 14.sp,
                            fontFamily = fontSFPro
                        )
                    )
                }
            }
            Spacer(modifier = Modifier.width(10.dp))
            BasicTextField(
                value = number,
                onValueChange = { countNumber ->
                    when {
                        countNumber.length <= 10 && countNumber.all { it.isDigit() } -> {
                            number = countNumber
                        }
                    }
                },
                modifier = Modifier
                    .background(
                        LightColorTheme.neutralSecondaryBG,
                        RoundedCornerShape(5.dp)
                    )
                    .fillMaxHeight()
                    .weight(1f),
                decorationBox = { innerTextField ->
                    Box(
                        contentAlignment = Alignment.CenterStart,
                        modifier = Modifier.padding(horizontal = 8.dp, vertical = 0.dp)
                    ) {
                        if (number.isEmpty()) {
                            Text(
                                text = "000 000-00-00",
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
                    keyboardType = KeyboardType.Number
                ),
            )
        }
        Spacer(modifier = Modifier.height(60.dp))
        StatusButton(
            containerColor = LightColorTheme.brandColorDefault,
            enable = number.isNotEmpty(), // пока для показа тут пример перехода
            onClick = { navController.navigate(Graph.screenEntryCode) },
            contentText = "Продолжить",
            modifier = Modifier
                .fillMaxWidth()
                .height(52.dp)
        )
    }
}