package com.example.wbtechnoschool.features

import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.input.OffsetMapping
import androidx.compose.ui.text.input.TransformedText
import androidx.compose.ui.text.input.VisualTransformation

class PhoneNumberVisualTransformation : VisualTransformation {
    override fun filter(text: AnnotatedString): TransformedText {
        val originalText = text.text
        val transformedText = buildString {
            for (i in originalText.indices) {
                when (i) {
                    3 -> append(" ")
                    6, 8 -> append('-')
                }
                append(originalText[i])
                if (i == 10) break
            }
        }
        val offsetMapping = object : OffsetMapping {
            override fun originalToTransformed(offset: Int): Int {
                if (offset <= 3) return offset
                if (offset <= 6) return offset + 1
                if (offset <= 8) return offset + 2
                return offset + 3
            }

            override fun transformedToOriginal(offset: Int): Int {
                if (offset <= 3) return offset
                if (offset <= 7) return offset - 1
                if (offset <= 10) return offset - 2
                return offset - 3
            }
        }
        return TransformedText(AnnotatedString(transformedText), offsetMapping)
    }
}