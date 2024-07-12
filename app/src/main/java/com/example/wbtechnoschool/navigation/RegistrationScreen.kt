package com.example.wbtechnoschool.navigation

import android.net.Uri
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import coil.compose.rememberAsyncImagePainter
import coil.compose.rememberImagePainter
import com.example.wbtechnoschool.R
import com.example.wbtechnoschool.avatar.MyMainAvatar

@Composable
fun RegistrationScreen(navController: NavHostController) {
    var avatarUri by remember { mutableStateOf<Uri?>(null) }
    Column(modifier = Modifier.fillMaxSize()) {
        avatarUri?.let {
            MyMainAvatar(painter = rememberAsyncImagePainter(it), contentDescription = "")
        }
        Button(onClick = {
            avatarUri = Uri.parse("android.resource://your.package.name/drawable/your_avatar_image")
        }) {
            Text("Pick Avatar")
        }
        Button(onClick = {
            navController.navigate("profile/${avatarUri.toString()}")
        }) {
            Text("Complete Registration")
        }
    }
}