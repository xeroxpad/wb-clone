package com.example.wbtechnoschool.viewmodel.auth_view_model

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.navigation.NavController
import com.example.wbtechnoschool.navigation.Graph
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class AuthorizationProfileViewModel: ViewModel() {
    private val _name = MutableStateFlow("")
    val name: StateFlow<String> = _name

    private val _surname = MutableStateFlow("")
    val surname: StateFlow<String> = _surname

    fun nameChange (newName: String) {
        _name.value = newName
    }

    fun surnameChange (newSurname: String) {
        _surname.value = newSurname
    }

    fun saveDataProfile (navController: NavController) {
        viewModelScope.launch {
            navController.navigate("${Graph.screenSplashHelloName}/${_name.value}")
        }
    }
}