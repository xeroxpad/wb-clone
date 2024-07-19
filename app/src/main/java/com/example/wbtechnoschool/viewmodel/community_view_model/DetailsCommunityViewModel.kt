package com.example.wbtechnoschool.viewmodel.community_view_model

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.domain.entities.Meetings
import com.example.wbtechnoschool.R
import com.thedeanda.lorem.Lorem
import com.thedeanda.lorem.LoremIpsum
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class DetailsCommunityViewModel : ViewModel() {
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
        viewModelScope.launch {
            _meetings.value = List(18) {
                Meetings(
                    icon = R.drawable.avatar_preview,
                    title = "Designa",
                    date = R.string.date_meeting,
                    city = R.string.location_meeting,
                    tagDevelopmentLanguage = "Kotlin",
                    tagGradeDeveloper = "Junior",
                    tagCityMeeting = "Moscow",
                )
            }
        }
    }

    init {
        loadLoremText()
        loadMeetings()
    }
}