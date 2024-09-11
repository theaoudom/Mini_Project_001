package com.example.mini_project_001.language

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.mini_project_001.view_model.LanguageViewModel

class DataStoreViewModelFactory(private val dataStorePreferenceRepository: LanguageDataStore) : ViewModelProvider.Factory{

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(LanguageViewModel::class.java)){
            return LanguageViewModel(dataStorePreferenceRepository) as T
        }
        throw IllegalArgumentException()
    }
}