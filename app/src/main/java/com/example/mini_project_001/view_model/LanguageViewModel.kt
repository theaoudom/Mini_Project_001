package com.example.mini_project_001.view_model

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.mini_project_001.language.LanguageDataStore
import kotlinx.coroutines.launch

class LanguageViewModel(private val dataStore: LanguageDataStore): ViewModel() {

    private val _language = MutableLiveData("en")
    var language : LiveData<String>  =_language

    init {
        viewModelScope.launch {
            viewModelScope.launch {
                dataStore.getLanguage.collect{
                    _language.value = it
                }
            }
        }
    }

    suspend fun saveLanguage(lang:String){
        dataStore.setLanguage(lang)
    }
}