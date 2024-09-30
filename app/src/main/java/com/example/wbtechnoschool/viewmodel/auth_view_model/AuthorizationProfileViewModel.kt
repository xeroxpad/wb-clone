package com.example.wbtechnoschool.viewmodel.auth_view_model

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.navigation.NavController
import com.example.wbtechnoschool.navigation.Graph
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class AuthorizationProfileViewModel : ViewModel() {
    private val _name = MutableStateFlow("")
    val name: StateFlow<String> = _name

    private val _city = MutableStateFlow("")
    val city: StateFlow<String> = _city

    private val _infoAboutYourself = MutableStateFlow("")
    val infoAboutYourself: StateFlow<String> = _infoAboutYourself

    private val _surname = MutableStateFlow("")
    val surname: StateFlow<String> = _surname

    private val _selectedTags = MutableStateFlow<Set<String>>(emptySet())
    val selectedTags: StateFlow<Set<String>> = _selectedTags

    fun updateSelectedTags(tags: Set<String>) {
        _selectedTags.value = tags
    }

    fun nameChange(newName: String) {
        viewModelScope.launch {
            withContext(Dispatchers.Default) {
                _name.value = newName
            }
        }
    }

    fun surnameChange(newSurname: String) {
        _surname.value = newSurname
    }

    fun cityChange(newCity: String) {
        viewModelScope.launch {
            withContext(Dispatchers.Default) {
                _city.value = newCity
            }
        }
    }

    fun infoAboutNameChange(newInfo: String) {
        viewModelScope.launch {
            withContext(Dispatchers.Default) {
                _infoAboutYourself.value = newInfo
            }
        }
    }

    fun saveDataProfile(navController: NavController) {
        viewModelScope.launch {
            navController.navigate("${Graph.SplashHelloName.route}/${_name.value}")
        }
    }
}
