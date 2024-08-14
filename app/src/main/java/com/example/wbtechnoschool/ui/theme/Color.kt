package com.example.wbtechnoschool.ui.theme

import androidx.compose.runtime.Immutable
import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.graphics.Color

val Purple80 = Color(0xFFD0BCFF)
val PurpleGrey80 = Color(0xFFCCC2DC)
val Pink80 = Color(0xFFEFB8C8)

val Purple40 = Color(0xFF6650a4)
val PurpleGrey40 = Color(0xFF625b71)
val Pink40 = Color(0xFF7D5260)
val BlueVioletLight = Color(0xFFF5ECFF)
val BlueViolet = Color(0xFF9A41FE)
val BlueVioletDark = Color(0xFF660EC8)
val VioletLight = Color(0xFFF7F7FC)
val SpaceGreyLight = Color(0xFFEDEDED)
val Neutral = Color(0xFFA4A4A4)
val LightGrey = Color(0xFFD2D5F9)

@Immutable
data class ColorThemeWB(
    val brandColorDark: Color,
    val brandColorDefault: Color,
    val brandColorDarkMode: Color,
    val brandColorLight: Color,
    val brandColorBG: Color,
    val neutralActive: Color,
    val neutralDark: Color,
    val neutralBody: Color,
    val neutralWeak: Color,
    val neutralDisabled: Color,
    val neutralLine: Color,
    val neutralSecondaryBG: Color,
    val neutralWhite: Color,
    val accentDanger: Color,
    val accentWarning: Color,
    val accentSuccess: Color,
    val accentSafe: Color,
    val accentGrey: Color,
    val fixBrandColorDark: Color,
    val fixBlushPink: Color,
    val fixFuchsiaGlow: Color,
    val fixVividViolet: Color,
    val fixElectricViolet: Color,
    val fixRadiantMagenta: Color,
    val fixVioletBlaze: Color,
    val fixNeonLavender: Color,
    val fixRoyalIndigo: Color,
    val fixLavenderBlush: Color,
    val fixLightGray: Color,
)

val LightColorTheme =
    ColorThemeWB(
        brandColorDark = Color(0xFF660EC8),
        brandColorDefault = Color(0xFF9A41FE),
        brandColorDarkMode = Color(0xFF8207E8),
        brandColorLight = Color(0xFFECDAFF),
        brandColorBG = Color(0xFFF5ECFF),
        neutralActive = Color(0xFF29183B),
        neutralDark = Color(0xFF190E26),
        neutralBody = Color(0xFF1D0835),
        neutralWeak = Color(0xFFA4A4A4),
        neutralDisabled = Color(0xFFADB5BD),
        neutralLine = Color(0xFFEDEDED),
        neutralSecondaryBG = Color(0xFFF7F7FC),
        neutralWhite = Color(0xFFFFFFFF),
        accentDanger = Color(0xFFE94242),
        accentWarning = Color(0xFFFDCF41),
        accentSuccess = Color(0xFF2CC069),
        accentSafe = Color(0xFF7BCBCF),
        accentGrey = Color(0xFF666666),
        fixBrandColorDark = Color(0xFF9A10F0),
        fixBlushPink = Color(0xFFED3CCA),
        fixFuchsiaGlow = Color(0xFFDF34D2),
        fixVividViolet = Color(0xFFD02BD9),
        fixElectricViolet = Color(0xFFBF22E1),
        fixRadiantMagenta = Color(0xFFAE1AE8),
        fixVioletBlaze = Color(0xFF9A10F0),
        fixNeonLavender = Color(0xFF8306F7),
        fixRoyalIndigo = Color(0xFF6600FF),
        fixLavenderBlush = Color(0xFFF6F6FA),
        fixLightGray = Color(0xFFEFEFEF)
        )

val ColorTheme =
    staticCompositionLocalOf {
        LightColorTheme
    }
