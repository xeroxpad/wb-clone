package com.example.wbtechnoschool.viewmodel.community_view_model

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.wbtechnoschool.R
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import com.example.domain.entities.Community

class CommunityViewModel: ViewModel(

) {
    private val _community = MutableStateFlow<List<Community>>(emptyList())
    val community: StateFlow<List<Community>> = _community

    private fun loadCommunity() {
        viewModelScope.launch {
            _community.value = List(size = 18) /*для примера*/ {
                Community(
                    icon = R.drawable.avatar_meeting,
                    title = "Designa", /*для примера*/
                    countPersons = "10 000 человек" /*для примера*/
                )
            }
        }
    }

    init {
        loadCommunity()
    }
}