package com.example.mini_project_001.view_model

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import com.example.mini_project_001.model.UserData

class UserViewModel: ViewModel(){
    val userData = mutableStateOf(UserData())

    fun getUserName (){
        userData.value = userData.value.copy(
            userName = "Oudom"
        )
    }

    fun getMoney(){
        userData.value = userData.value.copy(
            money = 2999.99f
        )
    }
}