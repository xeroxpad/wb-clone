package com.example.wbtechnoschool.utils.widgets

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
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
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Dialog
import coil.compose.rememberAsyncImagePainter
import com.example.wbtechnoschool.utils.constants.MagicNumbers

@Composable
fun ShowImage(modifier: Modifier = Modifier, model: Any) {
    var showImage by remember { mutableStateOf(false) }
    Box(
        modifier = modifier
            .fillMaxWidth()
            .height(267.dp)
            .clip(RoundedCornerShape(MagicNumbers.SHOW_IMAGE_BOX_CLIP.dp))
    ) {
        Image(
            painter = rememberAsyncImagePainter(model = model),
            contentDescription = null,
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .fillMaxSize()
                .pointerInput(Unit) { detectTapGestures(onTap = { showImage = true }) }
        )
        when {
            showImage -> {
                Dialog(onDismissRequest = { showImage = false }) {
                    Box(
                        modifier = Modifier
                            .fillMaxSize()
                            .pointerInput(Unit) {
                                detectTapGestures(onTap = {
                                    showImage = false
                                })
                            },

                        ) {
                        Image(
                            painter = rememberAsyncImagePainter(model = model),
                            contentDescription = null,
                            modifier = Modifier
                                .fillMaxSize()
                                .pointerInput(Unit) {
                                    detectTransformGestures { _, _, _, _ ->
                                        showImage = false
                                    }
                                },
                        )
                    }
                }
            }
        }
    }
}

@Composable
fun ShowAvatar(modifier: Modifier = Modifier, model: Any, onClose: () -> Unit) {
    Box(
        modifier = modifier
            .clickable { onClose() },
        contentAlignment = Alignment.Center
    ) {
        Image(
            painter = rememberAsyncImagePainter(model = model),
            contentDescription = null,
            modifier = Modifier
                .fillMaxSize()
                .clip(RoundedCornerShape(MagicNumbers.SHOW_IMAGE_BOX_CLIP.dp))
        )
    }
}

