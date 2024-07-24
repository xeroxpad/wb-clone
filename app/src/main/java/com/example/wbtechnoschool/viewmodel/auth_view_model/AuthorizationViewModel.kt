package com.example.wbtechnoschool.viewmodel.auth_view_model

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.google.i18n.phonenumbers.PhoneNumberUtil

const val lengthNumber = 10

class AuthorizationViewModel : ViewModel() {
    private val _number = MutableLiveData("")
    val number: LiveData<String> get() = _number

//    private val phoneNumberUtil = PhoneNumberUtil.getInstance()
//
//    fun onNumberChange(newNumber: String) {
//        if (newNumber.all { it.isDigit() }) {
//            _number.value = formatPhoneNumber(newNumber)
//        }
//    }
//
//    private fun formatPhoneNumber(number: String): String {
//        return try {
//            val phoneNumber = phoneNumberUtil.parse(number, "RU")
//            phoneNumberUtil.format(phoneNumber, PhoneNumberUtil.PhoneNumberFormat.INTERNATIONAL)
//        } catch (e: Exception) {
//            number
//        }
//    }
//
//    fun numberValid(number: String): Boolean {
//        return try {
//            val phoneNumber = phoneNumberUtil.parse(number, "RU")
//            phoneNumberUtil.isValidNumber(phoneNumber)
//        } catch (e: Exception) {
//            false
//        }
//    }

    fun onNumberChange(newNumber: String) {
        if (newNumber.length <= lengthNumber && newNumber.all { it.isDigit() }) {
            _number.value = newNumber
        }
    }

    fun numberValid(number: String): Boolean {
        return number.length == lengthNumber && number.all { it.isDigit() }
    }
}