package com.example.wbtechnoschool.viewmodel.meetings_view_model

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.domain.entities.FixMeetingsDescription
import com.example.domain.entities.MeetingsDescription
import com.example.domain.usecases.GetDescriptionMeetingsUseCase
import com.thedeanda.lorem.Lorem
import com.thedeanda.lorem.LoremIpsum
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class DescriptionMeetingViewModel(
    private val getDescriptionMeetingsUseCase: GetDescriptionMeetingsUseCase
) : ViewModel() {
    private val _meetingDescription = MutableStateFlow<FixMeetingsDescription?>(null)
    val meetingDescription: StateFlow<FixMeetingsDescription?> = _meetingDescription

    init {
        fetchMeetingDescription()
    }

    private fun fetchMeetingDescription() {
        viewModelScope.launch {
            val description = getDescriptionMeetingsUseCase.execute()
            _meetingDescription.value = description
        }
    }
}
