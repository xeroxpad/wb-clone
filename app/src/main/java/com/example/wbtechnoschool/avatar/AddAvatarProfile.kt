package com.example.wbtechnoschool.avatar

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
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.wbtechnoschool.R


@Composable
fun AddAvatarProfile() {
    var avatarOpen by remember {
        mutableStateOf(false)
    }

    Box(
        modifier = Modifier
            .size(100.dp)
            .clickable { avatarOpen = true }
    ) {
        MyMainAvatar(
            painter = painterResource(id = R.drawable.avatars),
            contentDescription = null,
            modifier = Modifier
                .clip(CircleShape)
                .fillMaxSize()
        )
        Icon(
            Icons.Filled.AddCircle,
            contentDescription = "Добавить фото",
            modifier = Modifier
                .clickable { }
                .align(Alignment.BottomEnd)
        )
    }
}