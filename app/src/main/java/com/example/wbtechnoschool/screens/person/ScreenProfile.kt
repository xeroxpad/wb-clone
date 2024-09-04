package com.example.wbtechnoschool.screens.person

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.gestures.detectTapGestures
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.domain.entities.Community
import com.example.domain.entities.FixEvent
import com.example.wbtechnoschool.R
import com.example.wbtechnoschool.navigation.Graph
import com.example.wbtechnoschool.navigation.MainTopAppBar
import com.example.wbtechnoschool.screens.meetings.SelectOtherMeetings
import com.example.wbtechnoschool.ui.theme.LightColorTheme
import com.example.wbtechnoschool.utils.avatar.FixMyAvatar
import com.example.wbtechnoschool.utils.box.Network
import com.example.wbtechnoschool.utils.button.FixButton
import com.example.wbtechnoschool.utils.button.StatusTextButton
import com.example.wbtechnoschool.utils.events.FixCardCommunity
import com.example.wbtechnoschool.utils.events.FixCardMeetingMini
import com.example.wbtechnoschool.utils.search.FieldForNumber
import com.example.wbtechnoschool.utils.search.FieldForNumberCountryCode
import com.example.wbtechnoschool.utils.search.FixSearchTextField
import com.example.wbtechnoschool.utils.search.FixTextField
import com.example.wbtechnoschool.utils.search.FixTextFieldWide
import com.example.wbtechnoschool.utils.tags.FixTags
import com.example.wbtechnoschool.utils.toggle.FixToggleSwitch
import com.example.wbtechnoschool.viewmodel.auth_view_model.AuthorizationProfileViewModel
import com.example.wbtechnoschool.viewmodel.community_view_model.CommunityViewModel
import com.example.wbtechnoschool.viewmodel.meetings_view_model.MeetingViewModel
import org.koin.androidx.compose.koinViewModel

@Composable
fun ScreenProfile(
    modifier: Modifier = Modifier,
    navController: NavController,
    fromScreen: String,
    viewModelMeeting: MeetingViewModel = koinViewModel(),
    viewModelCommunity: CommunityViewModel = koinViewModel(),
) {
    val events by viewModelMeeting.meetings.collectAsState()
    val community by viewModelCommunity.community.collectAsState()
    val focusManager = LocalFocusManager.current
    var isEditing by remember { mutableStateOf(false) }
    val iconShareOrEdit = when (fromScreen) {
        Graph.MakeAnAppointmentDone.route -> R.drawable.icon_share
        else -> R.drawable.icon_edit
    }
    Scaffold(
        modifier =
        modifier
            .statusBarsPadding()
            .pointerInput(Unit) {
                detectTapGestures(onTap = { focusManager.clearFocus() })
            }
            .fillMaxSize(),
        topBar = {
            MainTopAppBar(
                modifier = Modifier
                    .padding(start = 10.dp, end = 10.dp)
                    .background(Color.Transparent),
                title = "",
                iconBack = { navController.popBackStack() },
                iconShare = iconShareOrEdit,
                onIconShareOrIconEditClick = {
                    isEditing = !isEditing
                }
            )
        },
        content = { innerPadding ->
            LazyColumn(
                modifier =
                Modifier
                    .fillMaxSize(),
                horizontalAlignment = Alignment.Start,
            ) {
                item {
                    Box(modifier = Modifier
                        .offset(y = (-innerPadding.calculateTopPadding()).coerceAtLeast(0.dp))
                        .fillMaxWidth()
                        .clickable { }
                        .height(375.dp)) {
                        FixMyAvatar(
                            model = R.drawable.avatars,
                            contentDescription = null,
                            modifier = Modifier.fillMaxSize(),
                        )
                        if (isEditing) {
                            FixButton(
                                containerColor = LightColorTheme.fixBrandColorDark.copy(alpha = 0.5f),
                                enable = true,
                                onClick = { /*TODO*/ },
                                modifier = Modifier
                                    .align(Alignment.BottomCenter)
                                    .padding(bottom = 15.dp)
                            )
                        }
                    }
                    if (isEditing) {
                        ProfileEditContent(
                            events = events,
                            community = community
                        )
                    } else {
                        ProfileViewContent(
                            navController = navController,
                            events = events,
                            community = community,
                        )
                    }
                    Spacer(modifier = Modifier.height(30.dp))
                }
            }

        }
    )
}

@OptIn(ExperimentalLayoutApi::class)
@Composable
fun ProfileViewContent(
    modifier: Modifier = Modifier,
    events: List<FixEvent>,
    community: List<Community>,
    navController: NavController
) {
    Column(modifier = modifier.padding(start = 20.dp)) {
        Spacer(modifier = Modifier.height(10.dp))
        Text(
            text = "Михаил",
            fontSize = 49.sp,
            fontWeight = FontWeight.W600,
        )
        Text(
            text = "Москва",
            fontSize = 14.sp,
            fontWeight = FontWeight.W600,
        )
        Row(modifier = Modifier.padding(end = 20.dp)) {
            Text(
                text = "Занимаюсь разрабокой мобильных приложений. Учусь в техношколе Wildberries. Изучаю язык Kotlin",
                fontSize = 14.sp,
                fontWeight = FontWeight.W600,
                lineHeight = 18.sp,
            )
        }
        Spacer(modifier = Modifier.height(15.dp))
        FlowRow(
            modifier = modifier.fillMaxWidth(),
            verticalArrangement = Arrangement.spacedBy(10.dp)
        ) {
            FixTags(
                labelText = "Разработка",
                modifier = Modifier.padding(end = 5.dp)
            )
            FixTags(
                labelText = "Безопасность",
                modifier = Modifier.padding(end = 5.dp)
            )
            FixTags(
                labelText = "Девопс",
                modifier = Modifier.padding(end = 5.dp)
            )
            FixTags(
                labelText = "Backend",
                modifier = Modifier.padding(end = 5.dp)
            )
            FixTags(
                labelText = "Mobile",
                modifier = Modifier.padding(end = 5.dp)
            )
            FixTags(
                labelText = "Тестирование",
                modifier = Modifier.padding(end = 5.dp)
            )
            FixTags(
                labelText = "Аналитика",
                modifier = Modifier.padding(end = 5.dp)
            )
        }
        Spacer(modifier = Modifier.height(15.dp))
        Row(horizontalArrangement = Arrangement.spacedBy(10.dp)) {
            Network(icon = R.drawable.icon_habr)
            Network(icon = R.drawable.icon_telegram)
        }
        Spacer(modifier = Modifier.height(30.dp))
        Text(
            text = "Мои встречи",
            fontSize = 24.sp,
            fontWeight = FontWeight.W600,
        )
        Spacer(modifier = Modifier.height(10.dp))
        LazyRow {
            items(events) { event ->
                FixCardMeetingMini(
                    event = event,
                    onClick = { navController.navigate(Graph.DescriptionMeeting.route) },
                )
                Spacer(modifier = Modifier.width(10.dp))
            }
        }
        Spacer(modifier = Modifier.height(30.dp))
        Text(
            text = "Мои сообщества",
            fontSize = 24.sp,
            fontWeight = FontWeight.W600,
            modifier = Modifier.padding(end = 20.dp)
        )
        Spacer(modifier = Modifier.height(10.dp))
        LazyRow {
            items(community) { communities ->
                FixCardCommunity(
                    community = communities,
                    onClick = { navController.navigate(Graph.DetailsCommunity.route) },
                )
                Spacer(modifier = Modifier.width(10.dp))
            }
        }
        Spacer(modifier = Modifier.height(30.dp))
        Row(
            modifier = Modifier
                .padding(end = 20.dp)
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.Center
        ) {
            StatusTextButton(
                contentColor = LightColorTheme.indigoTwilight,
                containerColor = Color.Transparent,
                enable = true,
                onClick = { /*TODO*/ },
                contentText = stringResource(id = R.string.log_out)
            )
        }
    }
}

@Composable
fun ProfileEditContent(
    modifier: Modifier = Modifier,
    events: List<FixEvent>,
    community: List<Community>,
    viewModel: AuthorizationProfileViewModel = koinViewModel(),
) {
    val name by viewModel.name.collectAsState()
    val city by viewModel.city.collectAsState()
    val infoAboutYourself by viewModel.infoAboutYourself.collectAsState()
    var currentPhoneNumber by remember { mutableStateOf("") }
    Column(modifier = modifier.padding(horizontal = 20.dp)) {
        Spacer(modifier = Modifier.height(20.dp))
        FixTextField(
            placeholder = R.string.name_and_second_name,
            text = name,
            textChange = { viewModel.nameChange(it) }
        )
        Spacer(modifier = Modifier.height(7.dp))
        FieldForNumberCountryCode(placeholder = R.string.placeholder_number) { newPhoneNumber ->
            currentPhoneNumber = newPhoneNumber
        }
        Spacer(modifier = Modifier.height(7.dp))
        FixTextField(
            placeholder = R.string.city,
            text = city,
            textChange = { viewModel.cityChange(it) }
        )
        Spacer(modifier = Modifier.height(7.dp))
        FixTextFieldWide(
            placeholder = R.string.tell_about_yourself,
            text = infoAboutYourself,
            textChange = { viewModel.infoAboutNameChange(it) },
        )
        Spacer(modifier = Modifier.height(30.dp))
        Text(
            text = "Интересы",
            fontSize = 24.sp,
            fontWeight = FontWeight.W600,
        )
        Spacer(modifier = Modifier.height(10.dp))
        SelectOtherMeetings(
            tags = listOf(
                "Разработка",
                "Безопасность",
                "Девопс",
                "Backend",
                "Frontend",
                "+ Добавить",
            )
        )
        Spacer(modifier = Modifier.height(30.dp))
        Text(
            text = "Социальные сети",
            fontSize = 24.sp,
            fontWeight = FontWeight.W600,
        )
        Spacer(modifier = Modifier.height(10.dp))
        FixSearchTextField(placeholder = R.string.habr, leadingIcon = R.drawable.icon_habr)
        Spacer(modifier = Modifier.height(7.dp))
        FixSearchTextField(placeholder = R.string.telegram, leadingIcon = R.drawable.icon_telegram)
        Spacer(modifier = Modifier.height(30.dp))
        Row(
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.fillMaxWidth()
        ) {
            Text(
                text = "Показывать мои сообщества",
                color = LightColorTheme.fixBrandColorDark,
                fontWeight = FontWeight.W500,
                fontSize = 18.sp
            )
            FixToggleSwitch()
        }
        Spacer(modifier = Modifier.height(10.dp))
        Row(
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.fillMaxWidth()
        ) {
            Text(
                text = "Показывать мои встречи",
                color = LightColorTheme.fixBrandColorDark,
                fontWeight = FontWeight.W500,
                fontSize = 18.sp
            )
            FixToggleSwitch()
        }
        Spacer(modifier = Modifier.height(20.dp))
        Row(
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.fillMaxWidth()
        ) {
            Text(
                text = "Включить уведомления",
                color = LightColorTheme.fixBrandColorDark,
                fontWeight = FontWeight.W500,
                fontSize = 18.sp
            )
            FixToggleSwitch()
        }
        Spacer(modifier = Modifier.height(30.dp))
        Row(
            modifier = Modifier
                .padding(end = 20.dp)
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.Center
        ) {
            StatusTextButton(
                contentColor = LightColorTheme.red,
                containerColor = Color.Transparent,
                enable = true,
                onClick = { /*TODO*/ },
                contentText = stringResource(id = R.string.delete_profile)
            )
        }
    }
}


   