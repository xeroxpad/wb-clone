package com.example.wbtechnoschool.events

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.wbtechnoschool.R
import com.example.wbtechnoschool.avatar.MyPreviewAvatar
import com.example.wbtechnoschool.navigation.Graph
import com.example.wbtechnoschool.ui.theme.LightColorTheme
import com.example.wbtechnoschool.ui.theme.SpaceGreyLight

@Composable
fun CardCommunity(onClick: () -> Unit, community: Community) {
    Card(
        onClick = { onClick() }, modifier = Modifier
            .fillMaxWidth()
            .padding( start = 5.dp),
        colors = CardDefaults.cardColors(Color.Transparent)
    ) {
        Row {
            MyPreviewAvatar(
                painter = painterResource(id = community.icon),
                contentDescription = "",
                modifier = Modifier
                    .padding(end = 10.dp, bottom = 10.dp)
                    .size(56.dp)
            )
            Column {
                Text(
                    text = community.title,
                    fontWeight = FontWeight.Bold,
                    fontSize = 14.sp
                )
                Text(
                    text = community.countPersons,
                    fontWeight = FontWeight.Light,
                    fontSize = 12.sp,
                    color = LightColorTheme.neutralDisabled
                )
            }
        }
        HorizontalDivider(color = SpaceGreyLight)
    }
}