package com.example.wbtechnoschool.screens.geodata

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.LocationOn
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.wbtechnoschool.R
import com.example.wbtechnoschool.navigation.Graph
import kotlinx.coroutines.delay

@Composable
fun ScreenGeoData(
    modifier: Modifier = Modifier,
    navController: NavController,
) {
    var showDialog by remember { mutableStateOf(false) }
    LaunchedEffect(Unit) {
        delay(1000)
        showDialog = true
    }
    Box(
        modifier = modifier
            .fillMaxSize()
    ) {
        Image(
            painter = painterResource(id = R.drawable.map_moscow),
            contentDescription = null,
            modifier = Modifier.fillMaxSize(),
            contentScale = ContentScale.Crop
        )
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .statusBarsPadding()
                .padding(horizontal = 15.dp),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Button(
                onClick = { navController.navigate(Graph.SelectedInterests.route) },
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color.White,
                    contentColor = Color.Black,
                    disabledContainerColor = Color.White,
                    disabledContentColor = Color.Black
                ),
                enabled = !showDialog
            ) {
                Icon(imageVector = Icons.AutoMirrored.Filled.ArrowBack, contentDescription = null)
            }
            Button(
                onClick = { showDialog = !showDialog }, colors = ButtonDefaults.buttonColors(
                    containerColor = Color.White,
                    contentColor = Color.Black,
                    disabledContainerColor = Color.White,
                    disabledContentColor = Color.Black
                ),
                enabled = !showDialog
            ) {
                Icon(imageVector = Icons.Default.LocationOn, contentDescription = null)
            }
        }
        if (showDialog) {
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .background(Color.Black.copy(alpha = 0.5f))
            )
            LocationPermissionDialog(
                onAllow = { navController.navigate(Graph.Events.route) },
                modifier = Modifier
                    .align(Alignment.BottomCenter)
                    .padding(horizontal = 15.dp)
                    .navigationBarsPadding()
            ) {
                showDialog = !showDialog
            }
        }
    }
}

@Composable
fun LocationPermissionDialog(
    modifier: Modifier = Modifier,
    onAllow: () -> Unit,
    onProhibit: () -> Unit
) {
    Box(
        modifier = modifier
            .clip(shape = RoundedCornerShape(20.dp))
            .fillMaxWidth()
            .background(Color.White)
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 10.dp)
        ) {
            Text(
                "Разрешить приложению WB Встречи доступ к геоданным?",
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 15.dp)
            )
            Spacer(modifier = Modifier.height(5.dp))
            Box(
                modifier = Modifier
                    .height(150.dp)
                    .fillMaxWidth(),
            ) {
                Image(
                    painter = painterResource(id = R.drawable.location),
                    contentDescription = null,
                    modifier = Modifier.fillMaxSize(),
                    contentScale = ContentScale.Crop
                )
                Row(
                    horizontalArrangement = Arrangement.Center,
                    modifier = Modifier
                        .fillMaxWidth()
                        .align(Alignment.TopCenter)
                        .padding(horizontal = 15.dp, vertical = 3.dp)
                ) {
                    Text(
                        "ТОЧНЫЕ ГЕОДАННЫЕ: ВКЛЮЧЕНО",
                        color = Color.Blue,
                    )
                }
            }
            Spacer(modifier = Modifier.height(15.dp))
            Column {
                TextButton(
                    onClick = { onAllow() }, modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 10.dp)
                ) {
                    Text("РАЗРЕШИТЬ ВО ВРЕМЯ ИСПОЛЬЗОВАНИЯ", color = Color.Blue, fontSize = 16.sp)
                }
                TextButton(
                    onClick = { onAllow() }, modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 10.dp)
                ) {
                    Text("РАЗРЕШИТЬ ТОЛЬКО СЕЙЧАС", color = Color.Blue, fontSize = 20.sp)
                }
            }
            TextButton(
                onClick = { onProhibit() }, modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 10.dp)
            ) {
                Text("ЗАПРЕТИТЬ", color = Color.Blue, fontSize = 20.sp)
            }
        }
    }
}
