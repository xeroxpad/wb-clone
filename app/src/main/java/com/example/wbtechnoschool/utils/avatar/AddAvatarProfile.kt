package com.example.wbtechnoschool.utils.avatar

import android.net.Uri
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
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
import androidx.compose.ui.unit.dp
import com.example.wbtechnoschool.R
import com.example.wbtechnoschool.ui.theme.LightColorTheme
import com.example.wbtechnoschool.utils.constants.MagicNumbers

@Composable
fun AddAvatarProfile(
    modifier: Modifier = Modifier,
) {
    var avatarOpen by remember { mutableStateOf(false) }
    var imageUri by remember { mutableStateOf<Uri?>(null) }
    val launcher = rememberLauncherForActivityResult(contract = ActivityResultContracts.GetContent()) { uri: Uri? -> imageUri = uri }
    Box(
        modifier =
        modifier
            .size(MagicNumbers.ADD_AVATAR_PROFILE_BOX_SIZE.dp)
            .background(LightColorTheme.neutralSecondaryBG),
    ) {
        MyMainAvatar(
            model = imageUri,
            contentDescription = null,
            modifier =
            Modifier
                .clip(CircleShape)
                .fillMaxSize()
                .clickable { avatarOpen = true }
        )
        Icon(
            Icons.Filled.AddCircle,
            contentDescription = null,
            modifier =
            Modifier
                .clickable { launcher.launch("image/*") }
                .align(Alignment.BottomEnd)
                .shadow(MagicNumbers.ADD_AVATAR_ICON_SHADOW_ELEVATION.dp, CircleShape)
        )
    }
}
