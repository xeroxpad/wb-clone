package com.example.wbtechnoschool.screens.auth

import androidx.compose.foundation.background
import androidx.compose.foundation.gestures.detectTapGestures
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.wbtechnoschool.R
import com.example.wbtechnoschool.navigation.Graph
import com.example.wbtechnoschool.ui.theme.LightColorTheme
import com.example.wbtechnoschool.utils.button.GradientButtonDark
import com.example.wbtechnoschool.utils.constants.MagicNumbers
import com.example.wbtechnoschool.utils.search.FieldForNumber
import com.example.wbtechnoschool.viewmodel.auth_view_model.AuthorizationViewModel
import org.koin.androidx.compose.koinViewModel

@Composable
fun ScreenEnteringNumberForAppointment(
    modifier: Modifier = Modifier,
    navController: NavController,
    viewModel: AuthorizationViewModel = koinViewModel(),
) {
    val number by viewModel.number.observeAsState("")
    var currentPhoneNumber by remember { mutableStateOf("") }
    val textColor =
        if (currentPhoneNumber.isEmpty()) LightColorTheme.neutralDisabled else Color.Black
    val focusManager = LocalFocusManager.current
    LaunchedEffect(number) {
        viewModel.onNumberChange(number)
    }

    Scaffold(
        modifier =
        modifier
            .statusBarsPadding()
            .fillMaxSize()
            .pointerInput(Unit) {
                detectTapGestures(onTap = { focusManager.clearFocus() })
            },
        topBar = {},
        content = { innerPadding ->
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(innerPadding)
            ) {
                LazyColumn(
                    modifier = modifier
                        .padding(20.dp)
                ) {
                    item {
                        Row(
                            modifier = Modifier.fillMaxWidth(),
                            horizontalArrangement = Arrangement.SpaceBetween,
                            verticalAlignment = Alignment.Top
                        ) {
                            Column(
                                modifier = Modifier
                                    .weight(5f)
                                    .padding(top = 0.dp),
                                verticalArrangement = Arrangement.Top,
                                horizontalAlignment = Alignment.Start
                            ) {
                                Text(
                                    text = stringResource(id = R.string.log_in_and_make_an_appointment),
                                    fontWeight = FontWeight.W600,
                                    fontSize = 49.sp,
                                    color = LightColorTheme.black,
                                    lineHeight = 40.sp
                                )
                                Spacer(modifier = Modifier.height(10.dp))
                                Text(
                                    text = "Супертестировщики · 12 августа · Невский проспект, 11",
                                    fontWeight = FontWeight.W400,
                                    fontSize = 16.sp,
                                    color = LightColorTheme.black,
                                )
                            }
                            IconButton(
                                onClick = { navController.popBackStack() },
                                modifier = Modifier
                                    .size(28.dp)
                                    .align(Alignment.Top)
                            ) {
                                Icon(
                                    painter = painterResource(id = R.drawable.ic_close),
                                    contentDescription = "Закрыть",
                                    tint = Color.Gray
                                )
                            }
                        }
                        Spacer(modifier = Modifier.height(20.dp))
                        Row(
                            modifier =
                            Modifier
                                .fillMaxWidth()
                                .height(MagicNumbers.SCREEN_AUTH_HEIGHT_ROW_MODIFIER.dp),
                            verticalAlignment = Alignment.CenterVertically
                        ) {

                            Box(
                                modifier =
                                Modifier
                                    .clip(shape = RoundedCornerShape(MagicNumbers.FIX_TEXT_FIELD_SHAPE_RADIUS.dp))
                                    .background(
                                        LightColorTheme.neutralSecondaryBG,
                                        RoundedCornerShape(MagicNumbers.SCREEN_AUTH_BOX_ROUNDED_CORNER_SHAPE.dp)
                                    )
                                    .width(86.dp)
                                    .fillMaxHeight(),
                                contentAlignment = Alignment.Center,
                            ) {
                                PrefixNumberTextField(
                                    textColor = textColor,
                                )
                            }
                            Spacer(modifier = Modifier.width(MagicNumbers.SCREEN_AUTH_SPACER_WIDTH_TF.dp))
                            FieldForNumber(placeholder = R.string.placeholder_number) { newPhoneNumber ->
                                currentPhoneNumber = newPhoneNumber
                            }
                        }
                    }
                }
                Column(
                    horizontalAlignment = Alignment.CenterHorizontally,
                    modifier = Modifier
                        .align(Alignment.BottomCenter)
                        .padding(horizontal = 20.dp)
                        .padding(bottom = 15.dp)
                ) {
                    GradientButtonDark(
                        modifier = Modifier.height(56.dp),
                        textButton = "Получить код",
                        enable = viewModel.numberValid(currentPhoneNumber)
                    ) { navController.navigate(Graph.GetTheCode.route) }
                }
            }
        }
    )
}