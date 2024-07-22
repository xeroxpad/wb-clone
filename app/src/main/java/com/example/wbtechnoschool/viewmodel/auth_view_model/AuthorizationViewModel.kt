package com.example.wbtechnoschool.viewmodel.auth_view_model

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

const val lengthNumber = 10

class AuthorizationViewModel : ViewModel() {
    private val _number = MutableLiveData("")
    val number: LiveData<String> get() = _number

    fun onNumberChange(newNumber: String) {
        if (newNumber.length <= lengthNumber && newNumber.all { it.isDigit() }) {
            _number.value = newNumber
        }
    }

    fun numberValid(number: String): Boolean {
        return number.length == lengthNumber && number.all { it.isDigit() }
    }
}