package com.example.wbtechnoschool.viewmodel.meetings_view_model

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.domain.entities.MeetingsDescription
import com.example.domain.usecases.GetDescriptionMeetingsUseCase
import com.thedeanda.lorem.Lorem
import com.thedeanda.lorem.LoremIpsum
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class DescriptionMeetingViewModel(private val getDescriptionMeetingsUseCase: GetDescriptionMeetingsUseCase) : ViewModel() {
    private val _showMoreText = MutableStateFlow(false)
    val showMoreText: StateFlow<Boolean> = _showMoreText

    private val _loremText = MutableStateFlow("")
    val loremText: StateFlow<String> = _loremText

    private val _isGoing = MutableStateFlow(true)
    val isGoing: StateFlow<Boolean> = _isGoing

    private val _meetingDescription = MutableStateFlow<MeetingsDescription?>(null)
    val meetingDescription: StateFlow<MeetingsDescription?> get() = _meetingDescription

    fun toggleShowMoreText() {
        _showMoreText.value = !_showMoreText.value
    }

    fun toggleIsGoing() {
        _isGoing.value = !_isGoing.value
    }

    private fun loadLoremText() {
        viewModelScope.launch {
            val lorem: Lorem = LoremIpsum()
            _loremText.value = lorem.getWords(200)
        }
    }

    private fun loadMeetingDescription() {
        viewModelScope.launch {
            val description = getDescriptionMeetingsUseCase.execute()
            _meetingDescription.update { description }
        }
    }

    init {
        loadLoremText()
        loadMeetingDescription()
    }
}