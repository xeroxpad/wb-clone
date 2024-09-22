package com.example.wbtechnoschool.viewmodel.community_view_model

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.domain.entities.Community
import com.example.domain.usecases.GetCommunityUseCase
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class CommunityViewModel(
    private val getAllCommunityUseCase: GetCommunityUseCase
) : ViewModel() {
    private val _community =
        MutableStateFlow(getAllCommunityUseCase.repository.getAllCommunity())
    val community: StateFlow<Community> get() = _community

    init {
        loadCommunity()
    }

    private fun loadCommunity() {
        viewModelScope.launch {
            getAllCommunityUseCase.execute().collect() { result ->
                _community.value = result
            }
        }
    }
}
