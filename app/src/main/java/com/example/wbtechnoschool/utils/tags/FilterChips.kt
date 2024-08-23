package com.example.wbtechnoschool.utils.tags

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.AssistChip
import androidx.compose.material3.AssistChipDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.wbtechnoschool.ui.theme.LightColorTheme
import com.example.wbtechnoschool.utils.constants.MagicNumbers

@Composable
fun FilterChips(
    modifier: Modifier = Modifier,
    labelText: String
) {
    Box(
        modifier =
        modifier
            .padding(
                end = MagicNumbers.FILTER_CHIPS_BOX_PADDING_END.dp,
                top = MagicNumbers.FILTER_CHIPS_BOX_PADDING_TOP.dp,
                bottom = MagicNumbers.FILTER_CHIPS_BOX_PADDING_BOTTOM.dp
            )
            .height(MagicNumbers.FILTER_CHIPS_BOX_HEIGHT.dp)
            .clip(RoundedCornerShape(MagicNumbers.FILTER_CHIPS_BOX_CLIP.dp))
            .background(LightColorTheme.fixLavenderBlush),
        contentAlignment = Alignment.Center
    ) {
        Text(
            text = labelText,
            color = LightColorTheme.brandColorDark,
            fontSize = MagicNumbers.FILTER_CHIPS_BOX_TEXT_FONT_SIZE.sp,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.padding(horizontal = MagicNumbers.FILTER_CHIPS_BOX_TEXT_PADDING_HORIZONTAL.dp)
        )
    }
}

@Composable
fun FixTags(
    modifier: Modifier = Modifier,
    labelText: String
) {
    Box(
        modifier = modifier
            .clip(RoundedCornerShape(10.dp))
            .background(LightColorTheme.fixLavenderBlushDark),
        contentAlignment = Alignment.Center
    ) {
        Text(
            text = labelText,
            color = LightColorTheme.brandColorDark,
            fontSize = MagicNumbers.FILTER_CHIPS_BOX_TEXT_FONT_SIZE.sp,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.padding(horizontal = MagicNumbers.FILTER_CHIPS_BOX_TEXT_PADDING_HORIZONTAL.dp)
        )
    }
}

@Composable
fun FixFilterTags(
    modifier: Modifier = Modifier,
    labelText: String,
    isSelected: Boolean,
    onSelectionChanged: (Boolean) -> Unit
) {
    AssistChip(
        onClick = { onSelectionChanged(!isSelected) },
        label = { Text(labelText) },
        colors = AssistChipDefaults.assistChipColors(
            containerColor = if (isSelected) LightColorTheme.fixVioletBlaze else LightColorTheme.fixLavenderBlushDark,
            labelColor = if (isSelected) LightColorTheme.fixLavenderBlush else LightColorTheme.fixVioletBlaze
        ),
        modifier = modifier,
        border = null
    )
}