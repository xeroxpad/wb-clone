package com.example.wbtechnoschool.viewmodel.meetings_view_model

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.domain.entities.Meetings
import com.example.domain.usecases.GetMeetingsUseCase
import com.example.wbtechnoschool.R
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class MeetingViewModel(private val getMeetingsUseCase: GetMeetingsUseCase) : ViewModel() {
    private val _meetings = MutableStateFlow<List<Meetings>>(emptyList())
    val meetings: StateFlow<List<Meetings>> get() = _meetings

    private val _tabIndex = MutableStateFlow(0)
    val tabIndex: StateFlow<Int> = _tabIndex

    private val nameTabs = listOf(
        R.string.all_meetings,
        R.string.active_meetings,
    )

    fun getTabs(): List<Int> = nameTabs

    fun setTabIndex(index: Int) {
        _tabIndex.value = index
    }

    init {
        fetchMeetings()
    }

    private fun fetchMeetings() {
        viewModelScope.launch {
            val meetingsList = getMeetingsUseCase.execute()
            _meetings.value = meetingsList
        }
    }
}