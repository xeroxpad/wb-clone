package com.example.wbtechnoschool.typography

import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.wbtechnoschool.R
import com.example.wbtechnoschool.ui.theme.fontSFPro

@Composable
fun AllTypography() {
    Row(
        modifier = Modifier
            .fillMaxWidth()
    ) {
        Column {
            FontTypography(
                subheading = "Heading 1",
                body = "SF Pro Display/32/Bold",
                fontSize = 34.sp,
                fontWeight = FontWeight.Bold
            )
            FontTypography(
                subheading = "Heading 2",
                body = "SF Pro Display24/Bold",
                fontSize = 24.sp,
                fontWeight = FontWeight.Bold
            )
            FontTypography(
                subheading = "Subheading 1",
                body = "SF Pro Display18/SemiBold",
                fontSize = 28.sp,
                fontWeight = FontWeight.SemiBold
            )
            FontTypography(
                subheading = "Subheading 2",
                body = "SF Pro Display16/SemiBold",
                fontSize = 26.sp,
                fontWeight = FontWeight.SemiBold
            )
            FontTypography(
                subheading = "Body Text 1",
                body = "SF Pro Display/14/SemiBold",
                fontSize = 14.sp,
                fontWeight = FontWeight.SemiBold
            )
            FontTypography(
                subheading = "Body Text 2",
                body = "SF Pro Display14/Regular",
                fontSize = 14.sp,
                fontWeight = FontWeight.Normal
            )
            FontTypography(
                subheading = "Metadata 1",
                body = "SF Pro Display12/Regular",
                fontSize = 12.sp,
                fontWeight = FontWeight.Normal
            )
            FontTypography(
                subheading = "Metadata 2",
                body = "SF Pro Display10/Regular",
                fontSize = 10.sp,
                fontWeight = FontWeight.Normal
            )
            FontTypography(
                subheading = "Metadata 3",
                body = "SF Pro Display10/SemiBold",
                fontSize = 10.sp,
                fontWeight = FontWeight.SemiBold
            )
        }
    }
}

@Composable
fun FontTypography(
    subheading: String,
    body: String,
    fontSize: TextUnit,
    fontWeight: FontWeight
) {
    val scrollHorizontal = rememberScrollState(0)
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(end = 20.dp)
    ) {
        Column {
            Text(
                text = subheading,
                fontFamily = fontSFPro,
                fontWeight = FontWeight.Bold,
                fontSize = 18.sp
            )
            Text(
                text = body,
                fontSize = 14.sp,
                color = colorResource(id = R.color.gray),
                fontWeight = FontWeight.Light
            )
        }
        Text(
            text = "The quick brown fox jumps over the lazy dog",
            fontFamily = fontSFPro,
            fontWeight = fontWeight,
            fontSize = fontSize,
            modifier = Modifier
                .horizontalScroll(scrollHorizontal)
                .padding(start = 20.dp)
        )

    }
}