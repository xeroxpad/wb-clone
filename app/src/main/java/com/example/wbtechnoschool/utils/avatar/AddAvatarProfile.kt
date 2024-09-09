package com.example.wbtechnoschool.utils.avatar

import android.net.Uri
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AddCircle
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Dialog
import com.example.wbtechnoschool.R
import com.example.wbtechnoschool.ui.theme.LightColorTheme
import com.example.wbtechnoschool.utils.button.FixButton
import com.example.wbtechnoschool.utils.constants.MagicNumbers
import com.example.wbtechnoschool.utils.widgets.ShowAvatar

@Composable
fun AddAvatarProfile(
    modifier: Modifier = Modifier,
) {
    var showAvatar by remember { mutableStateOf(false) }
    var imageUri by remember { mutableStateOf<Uri?>(null) }
    val launcher =
        rememberLauncherForActivityResult(contract = ActivityResultContracts.GetContent()) { uri: Uri? ->
            imageUri = uri
        }
    Box(modifier = modifier.size(MagicNumbers.ADD_AVATAR_PROFILE_BOX_SIZE.dp)) {
        Box(
            modifier =
            Modifier
                .clip(CircleShape)
                .size(MagicNumbers.ADD_AVATAR_PROFILE_BOX_SIZE.dp)
                .background(LightColorTheme.neutralSecondaryBG),
            contentAlignment = Alignment.Center
        ) {
            if (imageUri == null) {
                Image(
                    painter = painterResource(id = R.drawable.default_icon),
                    contentDescription = null,
                )
            } else {
                MyMainAvatar(
                    model = imageUri,
                    contentDescription = null,
                    modifier = Modifier
                        .fillMaxSize()
                        .clickable { showAvatar = true }
                )
            }
        }
        Box(
            modifier = Modifier
                .align(Alignment.BottomEnd)
                .shadow(
                    MagicNumbers.ADD_AVATAR_ICON_SHADOW_ELEVATION.dp,
                    CircleShape,
                    spotColor = Color.Transparent
                )
        ) {
            Icon(
                Icons.Filled.AddCircle,
                contentDescription = null,
                modifier =
                Modifier
                    .clickable { launcher.launch("image/*") }
            )
        }
    }
    if (showAvatar) {
        Dialog(onDismissRequest = { showAvatar = false }) {
            ShowAvatar(
                model = imageUri.toString(),
                onClose = { showAvatar = false }
            )
        }
    }
}


@Composable
fun FixAddAvatarProfile(
    modifier: Modifier = Modifier,
    isEditing: Boolean,
) {
    var showAvatar by remember { mutableStateOf(false) }
    var imageUri by remember { mutableStateOf<Uri?>(null) }
    var selectedImageUri by remember { mutableStateOf<Uri?>(null) }
//    val launcher =
//        rememberLauncherForActivityResult(contract = ActivityResultContracts.GetContent()) { uri: Uri? ->
//            imageUri = uri
//        }
    val launcher =
        rememberLauncherForActivityResult(contract = ActivityResultContracts.GetContent()) { uri: Uri? ->
            selectedImageUri = uri
            showAvatar = true
        }
    Box(modifier = modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
        if (imageUri == null) {
            Image(
                painter = painterResource(id = R.drawable.default_icon),
                contentDescription = null,
                modifier = Modifier
                    .align(Alignment.Center)
                    .size(100.dp)
            )
        } else {
            MyMainAvatar(
                model = imageUri,
                contentDescription = null,
                modifier = Modifier
                    .fillMaxSize()
                    .clickable { showAvatar = true }
                    .align(Alignment.Center)
            )
        }
        if (isEditing) {
            FixButton(
                containerColor = LightColorTheme.fixBrandColorDark.copy(alpha = 0.5f),
                enable = true,
                onClick = { launcher.launch("image/*") },
                modifier = Modifier
                    .align(Alignment.BottomCenter)
                    .padding(bottom = 15.dp)
            )
        }
    }
    if (showAvatar && selectedImageUri != null) {
//        Dialog(onDismissRequest = { showAvatar = false }) {
//            ShowAvatar(
//                model = imageUri.toString(),
//                onClose = { showAvatar = false }
//            )
//        }
        AvatarMask(
            imageUri = selectedImageUri,
            onImageChange = { launcher.launch("image/*") },
            onConfirm = {
                imageUri = selectedImageUri
                showAvatar = false
            },
        )
    }
}
