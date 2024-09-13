package com.example.wbtechnoschool.utils.box

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.wbtechnoschool.R
import com.example.wbtechnoschool.ui.theme.LightColorTheme
import com.example.wbtechnoschool.ui.theme.inter

@Composable
fun InterestSelectionCard(modifier: Modifier = Modifier, onClick: () -> Unit) {
    val gradient = Brush.horizontalGradient(
        colors = listOf(
            LightColorTheme.fixBlushPink,
            LightColorTheme.fixFuchsiaGlow,
            LightColorTheme.fixVividViolet,
            LightColorTheme.fixElectricViolet,
            LightColorTheme.fixRadiantMagenta,
            LightColorTheme.fixVioletBlaze,
            LightColorTheme.fixNeonLavender,
            LightColorTheme.fixRoyalIndigo
        )
    )
    Box(
        modifier = modifier
            .clip(shape = RoundedCornerShape(16.dp))
            .fillMaxWidth()
            .background(gradient)
            .clickable { onClick() }
    ) {
        Row(modifier = Modifier.fillMaxWidth()) {
            Column(
                modifier = Modifier
                    .padding(vertical = 10.dp)
                    .padding(start = 10.dp)
                    .width(250.dp)
            ) {
                Text(
                    text = "Расскажите о своих интересах, чтобы мы рекомендовали полезные встречи",
                    color = Color.White,
                    fontWeight = FontWeight.W500,
                    fontFamily = inter,
                    fontSize = 14.sp,
                    letterSpacing = 1.sp
                )
                Spacer(modifier = Modifier.height(10.dp))
                Box(
                    modifier = Modifier
                        .clip(shape = RoundedCornerShape(12.dp))
                        .background(Color.White),
                    contentAlignment = Alignment.Center
                ) {
                    Text(
                        text = "Выбрать интересы",
                        modifier = Modifier.padding(10.dp),
                        color = LightColorTheme.fixBrandColorDark
                    )
                }
            }
        }
        Row(
            modifier = Modifier.align(Alignment.CenterEnd)
        ) {
            Image(painter = painterResource(id = R.drawable.tag_open), contentDescription = "")
            Image(
                painter = painterResource(id = R.drawable.tag_close),
                contentDescription = "",
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun InterestPrev() {
    InterestSelectionCard(onClick = {})
}