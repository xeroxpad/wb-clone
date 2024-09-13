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
