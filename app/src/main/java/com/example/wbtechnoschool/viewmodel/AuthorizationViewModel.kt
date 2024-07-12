package com.example.wbtechnoschool.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class AuthorizationViewModel: ViewModel() {
    private val _number = MutableLiveData("")
    val number: LiveData<String> get() = _number

    fun onNumberChange(newNumber: String){
        if (newNumber.length <= 10 && newNumber.all { it.isDigit() }) {
            _number.value = newNumber
        }
    }

    fun numberValid(number: String): Boolean {
        return number.length == 10 && number.all { it.isDigit() }
    }
 }