package com.example.wbtechnoschool.viewmodel.more_view_model.my_meetings_view_model

import androidx.lifecycle.ViewModel
import com.example.wbtechnoschool.R
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

class MyMeetingsViewModel : ViewModel() {
    private val _tabIndex = MutableStateFlow(0)
    val tabIndex: StateFlow<Int> = _tabIndex

    private val nameTabs =
        listOf(
            R.string.meetings_planned,
            R.string.meetings_past
        )

    fun getTabs(): List<Int> = nameTabs

    fun setTabIndex(index: Int) {
        _tabIndex.value = index
    }
}
