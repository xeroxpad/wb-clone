package com.example.wbtechnoschool.viewmodel.auth_view_model

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class EntryCodeViewModel : ViewModel() {
    private val _codeText = MutableLiveData("")
    val codeText: LiveData<String> get() = _codeText

    fun onCodeChange(newCode: String) {
        viewModelScope.launch {
            withContext(Dispatchers.Default) {
                if (newCode.length <= 4) {
                    _codeText.postValue(newCode)
                }
            }
        }
    }
}
