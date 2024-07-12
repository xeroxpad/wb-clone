package com.example.wbtechnoschool.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class EntryCodeViewModel: ViewModel() {
    private val _codeText = MutableLiveData("")
    val codeText: LiveData<String> get() = _codeText

    fun onCodeChange(newCode: String) {
        if (newCode.length <= 4) {
            _codeText.value = newCode
        }
    }
}