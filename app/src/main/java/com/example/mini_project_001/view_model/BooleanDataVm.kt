package com.example.mini_project_001.view_model

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import com.example.mini_project_001.model.BooleanData

class BooleanDataVm: ViewModel(){
    val booleanData = mutableStateOf(BooleanData())

    fun setHideMoney(input :Boolean){
        booleanData.value = booleanData.value.copy(
            hideMoney = input
        )
    }

    fun setShowDialogQrCode(input :Boolean){
        booleanData.value = booleanData.value.copy(
            showDialogQRCode = input
        )
    }
}