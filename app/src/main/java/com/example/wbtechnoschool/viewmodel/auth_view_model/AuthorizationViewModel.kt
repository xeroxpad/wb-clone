package com.example.wbtechnoschool.viewmodel.auth_view_model

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

const val lengthNumber = 10

class AuthorizationViewModel() : ViewModel() {
    private val _number = MutableLiveData("")
    val number: LiveData<String> get() = _number

    fun onNumberChange(newNumber: String) {
        viewModelScope.launch {
            withContext(Dispatchers.Default) {
                if (newNumber.length <= lengthNumber && newNumber.all { it.isDigit() }) {
                    _number.postValue(newNumber)
                }
            }
        }
    }

    fun numberValid(number: String): Boolean =
        number.length == lengthNumber && number.all { it.isDigit() }
}
