package com.example.wbtechnoschool.screens

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.wbtechnoschool.R
import com.example.wbtechnoschool.avatar.AddAvatarProfile
import com.example.wbtechnoschool.avatar.MyMainAvatar
import com.example.wbtechnoschool.avatar.MyPreviewAvatar
import com.example.wbtechnoschool.avatar.TestRowAvatars
import com.example.wbtechnoschool.button.AllButton
import com.example.wbtechnoschool.chips.FilterChips
import com.example.wbtechnoschool.events.CardCommunity
import com.example.wbtechnoschool.events.Events
import com.example.wbtechnoschool.search.AppSearchBar
import com.example.wbtechnoschool.typography.AllTypography
import com.example.wbtechnoschool.ui.theme.BlueViolet
import com.example.wbtechnoschool.ui.theme.BlueVioletDark
import com.example.wbtechnoschool.ui.theme.fontSFPro

//наполнение экрана из 1 и 2 задания, для показа
@Composable
fun ScreenCommunity() {
    val state = rememberScrollState()
    LaunchedEffect(Unit) { state.animateScrollTo(100) }
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.SpaceEvenly,
        modifier = Modifier
            .fillMaxSize()
            .padding(top = 50.dp, start = 20.dp, end = 20.dp, bottom = 70.dp)
            .verticalScroll(state)
    ) {
        Text(
            text = "Урок 1",
            fontSize = 20.sp,
            fontFamily = fontSFPro,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.padding(vertical = 10.dp)
        )
        Column {
            AllButton(
                containerColor = BlueViolet,
                modifier = Modifier.padding(start = 3.dp, end = 3.dp),
                enable = true,
                onClick = {}
            )
            AllButton(
                containerColor = BlueVioletDark,
                modifier = Modifier.padding(start = 3.dp, end = 3.dp),
                enable = true,
                onClick = {}
            )
            AllButton(
                containerColor = BlueViolet.copy(alpha = 0.5f),
                modifier = Modifier.padding(start = 3.dp, end = 3.dp),
                enable = false,
                onClick = {}
            )
        }
        AllTypography()
        MyMainAvatar(
            painter = painterResource(id = R.drawable.avatar_main),
            contentDescription = null,
            modifier = Modifier.size(200.dp)
        )
        MyPreviewAvatar(
            painter = painterResource(id = R.drawable.avatar_preview),
            contentDescription = null,
            modifier = Modifier
                .size(48.dp)
                .clickable { }
        )
        AppSearchBar(modifier = Modifier.fillMaxWidth())
        Row(
            modifier = Modifier
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            FilterChips(labelText = "Python")
            FilterChips(labelText = "Junior")
            FilterChips(labelText = "Moscow")
        }
        Text(
            text = "Урок 2",
            fontSize = 20.sp,
            fontFamily = fontSFPro,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.padding(vertical = 10.dp)
        )
        for (i in 1..10) {
            Events(true)
        }
        TestRowAvatars()
        CardCommunity()
        AddAvatarProfile()
    }
}
