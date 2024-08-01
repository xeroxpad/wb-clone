package com.example.wbtechnoschool.viewmodel.community_view_model

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.domain.entities.Community
import com.example.domain.usecases.GetAllCommunityUseCase
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class CommunityViewModel(
    private val getAllCommunityUseCase: GetAllCommunityUseCase
) : ViewModel() {
    private val _community = MutableStateFlow<List<Community>>(emptyList())
    val community: StateFlow<List<Community>> = _community

    init {
        loadCommunity()
    }

    private fun loadCommunity() {
        viewModelScope.launch {
            val communityList = getAllCommunityUseCase.execute()
            _community.update { communityList }
        }
    }
}
