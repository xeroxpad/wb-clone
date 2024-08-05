package com.example.wbtechnoschool.utils.avatar

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
import androidx.compose.ui.unit.dp
import com.example.wbtechnoschool.utils.constants.MagicNumbers
import com.example.wbtechnoschool.viewmodel.auth_view_model.AddAvatarProfileViewModel
import org.koin.androidx.compose.koinViewModel

@Composable
fun AddAvatarProfile(modifier: Modifier = Modifier, viewModel: AddAvatarProfileViewModel = koinViewModel()) {
    var avatarOpen by remember {
        mutableStateOf(false)
    }
    Box(
        modifier =
        modifier
            .size(MagicNumbers.ADD_AVATAR_PROFILE_BOX_SIZE.dp)
    ) {
        MyMainAvatar(
            painter = "https://i.pinimg.com/originals/89/e5/8e/89e58e371fded01e2ccf40fdea5c2c4d.jpg",
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
                .clickable { viewModel.openGallery() }
                .align(Alignment.BottomEnd)
        )
    }
}
