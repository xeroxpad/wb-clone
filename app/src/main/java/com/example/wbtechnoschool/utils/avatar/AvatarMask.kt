package com.example.wbtechnoschool.utils.avatar

import android.net.Uri
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.asPaddingValues
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.navigationBars
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.statusBars
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Dialog
import androidx.compose.ui.window.DialogProperties
import coil.compose.rememberAsyncImagePainter
import com.example.wbtechnoschool.R
import com.example.wbtechnoschool.ui.theme.LightColorTheme
import com.example.wbtechnoschool.utils.button.GradientButtonDark
import com.example.wbtechnoschool.utils.button.StatusTextButton
import com.example.wbtechnoschool.utils.widgets.CircleOverlayShape

@Composable
fun AvatarMask(
    modifier: Modifier = Modifier,
    imageUri: Uri?,
    onImageChange: () -> Unit,
    onConfirm: () -> Unit
) {
    Dialog(
        onDismissRequest = { onImageChange() },
        properties = DialogProperties(usePlatformDefaultWidth = false)
    ) {
        Box(
            modifier = modifier
                .background(Color.Black)
                .fillMaxHeight()
                .fillMaxWidth()
                .padding(0.dp),
            contentAlignment = Alignment.Center
        ) {
            Box(
                modifier = Modifier
                    .background(Color.Black)
                    .height(375.dp)
                    .fillMaxWidth(),
                contentAlignment = Alignment.Center
            ) {
                Image(
                    painter = rememberAsyncImagePainter(model = imageUri),
                    contentDescription = null,
                    modifier = Modifier.fillMaxSize(),
                    contentScale = ContentScale.Crop
                )
                Box(
                    modifier = Modifier
                        .clip(CircleOverlayShape())
                        .background(Color.Black.copy(alpha = 0.2f))
                        .height(375.dp)
                        .fillMaxWidth(),
                )
            }
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier
                    .align(Alignment.BottomCenter)
                    .padding(horizontal = 20.dp)
                    .padding(bottom = 15.dp)
            ) {
                StatusTextButton(
                    contentColor = LightColorTheme.indigoTwilight,
                    containerColor = Color.Transparent,
                    enable = true,
                    onClick = { onImageChange() },
                    contentText = stringResource(id = R.string.choose_another_photo),
                    modifier = Modifier.fillMaxWidth()
                )
                Spacer(modifier = Modifier.height(10.dp))
                GradientButtonDark(
                    modifier = Modifier
                        .height(49.dp)
                        .fillMaxWidth(),
                    enable = true,
                    textButton = "Сохранить",
                ) { onConfirm() }
            }
        }
    }
}