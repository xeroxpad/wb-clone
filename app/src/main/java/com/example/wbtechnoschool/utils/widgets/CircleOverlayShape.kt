package com.example.wbtechnoschool.utils.widgets

import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Rect
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Outline
import androidx.compose.ui.graphics.Path
import androidx.compose.ui.graphics.PathFillType
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.unit.Density
import androidx.compose.ui.unit.LayoutDirection

class CircleOverlayShape : Shape {
    override fun createOutline(
        size: Size,
        layoutDirection: LayoutDirection,
        density: Density
    ): Outline {
        val circleRadius = size.minDimension / 2.1f
        val circleCenter = Offset(size.width / 2, size.height / 2)

        return Outline.Generic(Path().apply {
            addRect(Rect(Offset.Zero, size))
            addOval(Rect(center = circleCenter, radius = circleRadius))
            fillType = PathFillType.EvenOdd
        })
    }
}