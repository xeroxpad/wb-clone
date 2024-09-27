package com.example.wbtechnoschool.viewmodel.events_view_model

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.domain.entities.Community
import com.example.domain.entities.FixEvent
import com.example.domain.usecases.GetCommunityUseCase
import com.example.domain.usecases.GetMeetingsUseCase
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class EventsViewModel(
    private val getMeetingsUseCase: GetMeetingsUseCase,
    private val getCommunitiesUseCase: GetCommunityUseCase
) : ViewModel() {
    private val _meetings = MutableStateFlow<List<FixEvent>>(emptyList())
    val meetings: StateFlow<List<FixEvent>> = _meetings

    private val _community = MutableStateFlow<Community?>(null)
    val community: StateFlow<Community?> = _community

    private val _filteredMeetings = MutableStateFlow<List<FixEvent>>(emptyList())
    val filteredMeetings: StateFlow<List<FixEvent>> = _filteredMeetings

    init {
        fetchMeetings()
        fetchCommunity()
    }

    private fun fetchMeetings() {
        viewModelScope.launch {
            getMeetingsUseCase.execute().collect { meetings ->
                _meetings.value = meetings
                _filteredMeetings.value = meetings
            }
        }
    }

    private fun fetchCommunity() {
        viewModelScope.launch {
            getCommunitiesUseCase.execute().collect { community ->
                _community.value = community
            }
        }
    }

    fun searchMeetings(query: String) {
        _filteredMeetings.value = if (query.isEmpty()) {
            _meetings.value
        } else {
            meetings.value.filter { meeting ->
                meeting.title.contains(query, ignoreCase = true) || meeting.tagCityMeeting.contains(
                    query,
                    ignoreCase = true
                ) || meeting.tagDevelopmentLanguage.contains(
                    query,
                    ignoreCase = true
                ) || meeting.tagGradeDeveloper.contains(query, ignoreCase = true)
            }
        }
    }
}