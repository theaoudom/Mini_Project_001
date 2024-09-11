package com.example.mini_project_001.app_ui

import android.util.Log
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.mini_project_001.component.TopAppBars
import com.example.mini_project_001.language.DataStoreViewModelFactory
import com.example.mini_project_001.language.LanguageDataStore
import com.example.mini_project_001.model.BooleanData
import com.example.mini_project_001.view_model.BooleanDataVm
import com.example.mini_project_001.view_model.LanguageViewModel

@Preview
@Composable
fun AppUI(){
    val booleanData = viewModel<BooleanDataVm>()

    // view model language


    Scaffold(modifier = Modifier.fillMaxSize(), containerColor = Color(0xFF00468B),
        topBar = {
            TopAppBars(booleanData)
        }
    ) {
        innerPadding ->
        Column (modifier = Modifier
            .padding(innerPadding)
            .padding(horizontal = 15.dp)
            .fillMaxSize()){
            Content(booleanData)
        }
    }
}