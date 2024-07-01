package com.example.wbtechnoschool.ui.theme

import androidx.compose.material3.Typography
import androidx.compose.runtime.Immutable
import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.LineHeightStyle
import androidx.compose.ui.unit.sp
import com.example.wbtechnoschool.R

val Typography = Typography(
    bodyLarge = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.Normal,
        fontSize = 16.sp,
        lineHeight = 24.sp,
        letterSpacing = 0.5.sp
    )
)

val fontSFPro = FontFamily(
    Font(R.font.sf_pro_display_black, FontWeight.Black),
    Font(R.font.sf_pro_display_black_italic, FontWeight.Black, FontStyle.Italic),
    Font(R.font.sf_pro_display_bold, FontWeight.Bold),
    Font(R.font.sf_pro_display_bold_italic, FontWeight.Bold, FontStyle.Italic),
    Font(R.font.sf_pro_display_heavy, FontWeight.Bold),
    Font(R.font.sf_pro_display_heavy_italic, FontWeight.Bold, FontStyle.Italic),
    Font(R.font.sf_pro_display_light, FontWeight.Light),
    Font(R.font.sf_pro_display_light_italic, FontWeight.Light, FontStyle.Italic),
    Font(R.font.sf_pro_display_medium, FontWeight.Normal),
    Font(R.font.sf_pro_display_medium_italic, FontWeight.Normal, FontStyle.Italic),
    Font(R.font.sf_pro_display_regular, FontWeight.Normal),
    Font(R.font.sf_pro_display_regular_italic, FontWeight.Normal, FontStyle.Italic),
    Font(R.font.sf_pro_display_semibold, FontWeight.SemiBold),
    Font(R.font.sf_pro_display_semibold_italic, FontWeight.SemiBold, FontStyle.Italic),
    Font(R.font.sf_pro_display_thin, FontWeight.ExtraLight),
    Font(R.font.sf_pro_display_thin_italic, FontWeight.ExtraLight, FontStyle.Italic),
    Font(R.font.sf_pro_display_ultra_light_italic, FontWeight.ExtraLight, FontStyle.Italic),
    Font(R.font.sf_pro_display_ultralight, FontWeight.ExtraLight),
)

@Immutable
data class TypographyThemeWB(
    val heading1: TextStyle,
    val heading2: TextStyle,
    val subheading1: TextStyle,
    val subheading2: TextStyle,
    val bodyText1: TextStyle,
    val bodyText2: TextStyle,
    val metadata1: TextStyle,
    val metadata2: TextStyle,
    val metadata3: TextStyle,
)

val SetTypographyTheme = TypographyThemeWB(
    heading1 = TextStyle(
        fontFamily = fontSFPro, fontWeight = FontWeight.Bold, fontSize = 32.sp,
        lineHeight = 30.sp,
        lineHeightStyle = LineHeightStyle(
            alignment = LineHeightStyle.Alignment.Center,
            trim = LineHeightStyle.Trim.None
        )
    ),
    heading2 = TextStyle(
        fontFamily = fontSFPro, fontWeight = FontWeight.Bold, fontSize = 24.sp,
        lineHeight = 29.sp,
        lineHeightStyle = LineHeightStyle(
            alignment = LineHeightStyle.Alignment.Center,
            trim = LineHeightStyle.Trim.None
        )
    ),
    subheading1 = TextStyle(
        fontFamily = fontSFPro, fontWeight = FontWeight.SemiBold, fontSize = 18.sp,
        lineHeight = 30.sp,
        lineHeightStyle = LineHeightStyle(
            alignment = LineHeightStyle.Alignment.Center,
            trim = LineHeightStyle.Trim.None
        )
    ),
    subheading2 = TextStyle(
        fontFamily = fontSFPro, fontWeight = FontWeight.SemiBold, fontSize = 16.sp,
        lineHeight = 28.sp,
        lineHeightStyle = LineHeightStyle(
            alignment = LineHeightStyle.Alignment.Center,
            trim = LineHeightStyle.Trim.None
        )
    ),
    bodyText1 = TextStyle(
        fontFamily = fontSFPro, fontWeight = FontWeight.SemiBold, fontSize = 14.sp,
        lineHeight = 24.sp,
        lineHeightStyle = LineHeightStyle(
            alignment = LineHeightStyle.Alignment.Center,
            trim = LineHeightStyle.Trim.None
        )
    ),
    bodyText2 = TextStyle(
        fontFamily = fontSFPro, fontWeight = FontWeight.Normal, fontSize = 14.sp,
        lineHeight = 24.sp,
        lineHeightStyle = LineHeightStyle(
            alignment = LineHeightStyle.Alignment.Center,
            trim = LineHeightStyle.Trim.None
        )
    ),
    metadata1 = TextStyle(
        fontFamily = fontSFPro, fontWeight = FontWeight.Normal, fontSize = 12.sp,
        lineHeight = 20.sp,
        lineHeightStyle = LineHeightStyle(
            alignment = LineHeightStyle.Alignment.Center,
            trim = LineHeightStyle.Trim.None
        )
    ),
    metadata2 = TextStyle(
        fontFamily = fontSFPro, fontWeight = FontWeight.Normal, fontSize = 10.sp,
        lineHeight = 16.sp,
        lineHeightStyle = LineHeightStyle(
            alignment = LineHeightStyle.Alignment.Center,
            trim = LineHeightStyle.Trim.None
        )
    ),
    metadata3 = TextStyle(
        fontFamily = fontSFPro, fontWeight = FontWeight.SemiBold, fontSize = 10.sp,
        lineHeight = 16.sp,
        lineHeightStyle = LineHeightStyle(
            alignment = LineHeightStyle.Alignment.Center,
            trim = LineHeightStyle.Trim.None
        )
    ),
)

val TypographyTheme = staticCompositionLocalOf {
    SetTypographyTheme
}