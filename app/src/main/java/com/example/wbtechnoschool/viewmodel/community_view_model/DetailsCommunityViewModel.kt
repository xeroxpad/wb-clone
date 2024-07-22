package com.example.wbtechnoschool.viewmodel.community_view_model

import androidx.compose.ui.res.stringResource
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.domain.entities.Community
import com.example.domain.entities.Meetings
import com.example.domain.repository.CommunityRepository
import com.example.domain.usecases.GetAllCommunityUseCase
import com.example.domain.usecases.GetDetailsCommunityUseCase
import com.example.wbtechnoschool.R
import com.thedeanda.lorem.Lorem
import com.thedeanda.lorem.LoremIpsum
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class DetailsCommunityViewModel(
    private val getDetailsCommunityUseCase: GetDetailsCommunityUseCase
): ViewModel() {
    private val _showMoreText = MutableStateFlow(false)
    val showMoreText: StateFlow<Boolean> = _showMoreText

    private val _loremText = MutableStateFlow("")
    val loremText: StateFlow<String> = _loremText

    private val _meetings = MutableStateFlow<List<Meetings>>(emptyList())
    val meetings: StateFlow<List<Meetings>> = _meetings

    fun toggleShowMoreText() {
        _showMoreText.value = !_showMoreText.value
    }

    private fun loadLoremText() {
        viewModelScope.launch {
            val lorem: Lorem = LoremIpsum()
            _loremText.value = lorem.getWords(100, 200)
        }
    }

    private fun loadMeetings() {
        val details = getDetailsCommunityUseCase.execute()
        viewModelScope.launch {
            _meetings.value = details.meetingsCommunity
        }
    }

    init {
        loadLoremText()
        loadMeetings()
    }
}