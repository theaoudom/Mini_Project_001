package com.example.mini_project_001.app_ui

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.mini_project_001.component.TopAppBars
import com.example.mini_project_001.model.UserData
import com.example.mini_project_001.view_model.UserViewModel

@Preview
@Composable
fun AppUI(){
//    val userViewModel: UserViewModel = viewModel()

    Scaffold(modifier = Modifier.fillMaxSize(), containerColor = Color(0xFF00468B),
        topBar = {
            TopAppBars()
        }
    ) {
        innerPadding ->
        Column (modifier = Modifier
            .padding(innerPadding)
            .padding(horizontal = 15.dp)
            .fillMaxSize()){
            Content()
        }
    }
}