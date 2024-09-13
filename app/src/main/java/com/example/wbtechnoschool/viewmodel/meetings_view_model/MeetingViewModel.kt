package com.example.wbtechnoschool.viewmodel.meetings_view_model

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.domain.entities.FixEvent
import com.example.domain.usecases.GetMeetingsUseCase
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class MeetingViewModel(
    private val getMeetingsUseCase: GetMeetingsUseCase
) : ViewModel() {
    private val _meetings = MutableStateFlow(getMeetingsUseCase.repository.getMeetings())
    val meetings: StateFlow<FixEvent> get() = _meetings

    init {
        fetchMeetings()
    }

    private fun fetchMeetings() {
        viewModelScope.launch {
            getMeetingsUseCase.execute().collect() { result ->
                _meetings.value = result
            }
        }
    }
}
