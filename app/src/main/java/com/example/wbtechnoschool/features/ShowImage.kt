package com.example.wbtechnoschool.features

import androidx.compose.foundation.Image
import androidx.compose.foundation.gestures.detectTapGestures
import androidx.compose.foundation.gestures.detectTransformGestures
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Dialog
import coil.compose.rememberAsyncImagePainter
import com.example.wbtechnoschool.R

@Composable
fun ShowImage(
    image: Int
) {
    var showImage by remember { mutableStateOf(false) }
    Box(
        modifier = Modifier
            .fillMaxSize()
            .clip(RoundedCornerShape(30.dp))
    ) {
        Image(
            painter = rememberAsyncImagePainter(model = image),
            contentDescription = "карта",
            modifier = Modifier
                .fillMaxWidth()
                .height(200.dp)
                .pointerInput(Unit) { detectTapGestures(onTap = { showImage = true }) }
        )
        if (showImage) {
            Dialog(onDismissRequest = { showImage = false }) {
                Box(modifier = Modifier
                    .fillMaxSize()
                    .pointerInput(Unit) { detectTapGestures(onTap = { showImage = false }) }
                ) {
                    Image(
                        painter = rememberAsyncImagePainter(model = R.drawable.map),
                        contentDescription = "карта",
                        modifier = Modifier
                            .fillMaxSize()
                            .pointerInput(Unit) {
                                detectTransformGestures { _, _, _, _ ->
                                    showImage = false
                                }
                            }
                    )
                }
            }
        }
    }
}