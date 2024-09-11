package com.example.mini_project_001.language

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.stringPreferencesKey
import androidx.datastore.preferences.preferencesDataStore
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class LanguageDataStore(private val context: Context) {

    private val Context.dataStore : DataStore<Preferences> by preferencesDataStore("language")

    companion object{
        val LANG_KEY = stringPreferencesKey("language")
    }

    suspend fun setLanguage(inputLang:String){
        context.dataStore.edit { language ->
            language[LANG_KEY] = inputLang
        }
    }

    val getLanguage:Flow<String> = context.dataStore.data.map { preference ->
        preference[LANG_KEY] ?: "No Data Found"
    }
}