package com.example.wbtechnoschool.screens.community

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation.NavController
import com.example.wbtechnoschool.R
import com.example.wbtechnoschool.navigation.Graph
import com.example.wbtechnoschool.navigation.MainTopAppBar
import com.example.wbtechnoschool.utils.constants.MagicNumbers
import com.example.wbtechnoschool.utils.events.CardCommunity
import com.example.wbtechnoschool.utils.search.AppSearchBar
import com.example.wbtechnoschool.viewmodel.community_view_model.CommunityViewModel
import org.koin.androidx.compose.koinViewModel

@Composable
fun ScreenCommunity(
    modifier: Modifier = Modifier,
    navController: NavController,
    viewModel: CommunityViewModel = koinViewModel()
) {
    val community by viewModel.community.collectAsStateWithLifecycle()
    Scaffold(
        modifier =
        modifier
            .statusBarsPadding()
            .fillMaxSize(),
        topBar = {
            MainTopAppBar(
                title = stringResource(id = R.string.top_bar_community)
            )
        },
        content = { innerPadding ->
            AppSearchBar(
                modifier =
                Modifier
                    .padding(horizontal = MagicNumbers.SCREEN_COMMUNITY_SEARCH_BAR_PADDING_HORIZONTAL.dp)
                    .padding(
                        top = MagicNumbers.SCREEN_COMMUNITY_SEARCH_BAR_PADDING_TOP.dp,
                        bottom = innerPadding.calculateBottomPadding()
                    )
                    .fillMaxWidth()
                    .height(MagicNumbers.SCREEN_COMMUNITY_SEARCH_BAR_HEIGHT.dp)
            )
            LazyColumn(
                modifier =
                Modifier
                    .padding(horizontal = MagicNumbers.SCREEN_COMMUNITY_LAZY_PADDING_HORIZONTAL.dp)
                    .padding(innerPadding)
                    .padding(top = MagicNumbers.SCREEN_COMMUNITY_LAZY_PADDING_TOP.dp)
                    .navigationBarsPadding()
                    .fillMaxSize(),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                items(25) {
                    CardCommunity(
                        onClick = { navController.navigate(Graph.DetailsCommunity.route) },
                        community = community,
                        modifier = Modifier.padding(vertical = MagicNumbers.SCREEN_COMMUNITY_LAZY_CARD_COMMUNITY_PADDING_VERTICAL.dp)
                    )
                }
            }
        }
    )
}
