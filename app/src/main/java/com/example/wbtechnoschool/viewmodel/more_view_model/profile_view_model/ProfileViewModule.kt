package com.example.wbtechnoschool.viewmodel.more_view_model.profile_view_model

import androidx.lifecycle.ViewModel
import com.example.domain.usecases.GetDataProfileUseCase
import com.example.wbtechnoschool.R
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

class ProfileViewModule(
    getDataProfileUseCase: GetDataProfileUseCase
) : ViewModel() {
    private val person = getDataProfileUseCase.execute()

    private val _name = MutableStateFlow(person.name)
    val name: StateFlow<String> = _name

    private val _phoneNumber = MutableStateFlow(person.numberPhone)
    val phoneNumber: StateFlow<String> = _phoneNumber

    private val _avatar = MutableStateFlow(person.avatarUrl ?: "")
    val avatar: StateFlow<String> = _avatar

    private val _socialMediaIcons =
        MutableStateFlow(
            listOf(
                R.drawable.icon_twitter,
                R.drawable.icon_inst,
                R.drawable.icon_linkedin,
                R.drawable.icon_meta
            )
        )
    val socialMediaIcons: StateFlow<List<Int>> = _socialMediaIcons
}
