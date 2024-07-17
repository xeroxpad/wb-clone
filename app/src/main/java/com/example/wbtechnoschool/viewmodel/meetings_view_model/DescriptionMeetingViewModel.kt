package com.example.wbtechnoschool.viewmodel.meetings_view_model

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.thedeanda.lorem.Lorem
import com.thedeanda.lorem.LoremIpsum
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class DescriptionMeetingViewModel : ViewModel() {
    private val _showMoreText = MutableStateFlow(false)
    val showMoreText: StateFlow<Boolean> = _showMoreText

    private val _loremText = MutableStateFlow("")
    val loremText: StateFlow<String> = _loremText

    private val _isGoing = MutableStateFlow(true)
    val isGoing: StateFlow<Boolean> = _isGoing

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

    init {
        loadLoremText()
    }
}