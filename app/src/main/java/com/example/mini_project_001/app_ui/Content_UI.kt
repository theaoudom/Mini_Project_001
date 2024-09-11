package com.example.mini_project_001.app_ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import com.example.mini_project_001.R
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.IconButton
import androidx.compose.material3.ModalBottomSheet
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.blur
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.mini_project_001.component.BackgroundTemplate
import com.example.mini_project_001.component.ChipButton
import com.example.mini_project_001.component.Slide
import com.example.mini_project_001.component.SmallCardComponent
import com.example.mini_project_001.language.DataStoreViewModelFactory
import com.example.mini_project_001.language.LanguageDataStore
import com.example.mini_project_001.model.FeatureData
import com.example.mini_project_001.view_model.BooleanDataVm
import com.example.mini_project_001.view_model.LanguageViewModel
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.res.stringResource
import com.example.mini_project_001.language.SetLanguage
import kotlinx.coroutines.launch

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Content(booleanData:BooleanDataVm){

    val viewModel: LanguageViewModel = viewModel(factory = DataStoreViewModelFactory(
        LanguageDataStore(
            LocalContext.current
        ))
    )

    val scope = rememberCoroutineScope()
    val currentLanguage = viewModel.language.observeAsState().value

    val hideMoney = booleanData.booleanData.value.hideMoney
    var showBottomSheet by remember { mutableStateOf(false)}
    val buttonItem = listOf(
        "Themes","Dark Mode", "Language"
    )
    val money = 82.07
    var selectedChip by remember { mutableStateOf<String?>("Themes") }
    // List of Feature
    val objectList =  listOf(
        FeatureData(icon = painterResource(id = R.drawable.ic_acc), title = stringResource(id = R.string.account), description = "Your balance"),
        FeatureData(icon = painterResource(id = R.drawable.ic_bills), title = stringResource(id = R.string.pay_bill), description = "School, Shop, etc"),
        FeatureData(icon = painterResource(id = R.drawable.ic_transfer), title = stringResource(id = R.string.transfer), description = "Send money"),
        FeatureData(icon = painterResource(id = R.drawable.ic_fav), title = stringResource(id = R.string.favorite), description = "User"),
        FeatureData(icon = painterResource(id = R.drawable.ic_scan), title = stringResource(id = R.string.aba_scan), description = "School, Shop, etc"),
        FeatureData(icon = painterResource(id = R.drawable.ic_service), title = stringResource(id = R.string.service), description = "Your balance"),
    )
    
    SetLanguage(lang = currentLanguage!!)
    LazyColumn {
        item {
            BackgroundTemplate{
                Column (
                    modifier = Modifier.padding(top = 5.dp)
                ){
                    Row (
                        verticalAlignment = Alignment.CenterVertically
                    ){
                        Text(
                            text = "$$money", fontSize = 20.sp, modifier = Modifier
                                .clip(RoundedCornerShape(5.dp))
                                .blur(if (hideMoney) 10.dp else 0.dp), fontWeight = FontWeight.Bold, color = Color.White)
                        IconButton(onClick = { /*TODO*/ },
                            modifier = Modifier
                                .padding(horizontal = 3.dp)
                                .size(30.dp)) {
                            Box(modifier = Modifier
                                .background(
                                    Color(0xFF00C2FF).copy(alpha = 0.38f),
                                    RoundedCornerShape(7.dp)
                                )
                                .size(24.dp)
                                , contentAlignment = Alignment.Center
                            ){
                                IconButton(onClick = { booleanData.setHideMoney(!hideMoney) }) {
                                    Image(painter = painterResource(id = if(hideMoney)  R.drawable.bx_show_mini001 else R.drawable.bx_hide_mini001), contentDescription =null,
                                        modifier = Modifier
                                            .size(15.dp)
                                    )
                                }
                            }
                        }
                    }
                    Column(
                        Modifier
                            .padding(top = 10.dp)
                            .height(80.dp),
                        verticalArrangement = Arrangement.SpaceBetween
                    ){
                        Row{
                            Text(text = "Default", color = Color.White, fontSize = 10.sp, modifier = Modifier
                                .background(Color(0xFF34C2FF), RoundedCornerShape(3.dp))
                                .padding(vertical = 2.dp)
                                .padding(horizontal = 6.dp)
                            )
                            Text(text = stringResource(id = R.string.saving), color = Color.White, fontSize = 10.sp, modifier = Modifier
                                .padding(horizontal = 8.dp)
                                .padding(vertical = 2.dp)
                            )
                        }
                        Row(verticalAlignment = Alignment.CenterVertically) {
                            Image(painter = painterResource(id = R.drawable.receive_moneymini001), contentDescription = "Send Money", modifier = Modifier.size(15.dp))
                            Text(text = stringResource(id = R.string.account), fontSize = 13.sp, modifier = Modifier
                                .padding(horizontal = 5.dp)
                                .padding(end = 10.dp)
                                , color = Color.White)
                            Image(painter = painterResource(id = R.drawable.send_moneymini001), contentDescription = "Send Money", modifier = Modifier.size(15.dp))
                            Text(text = stringResource(id = R.string.send_money), fontSize = 13.sp, modifier = Modifier.padding(horizontal = 5.dp), color = Color.White)
                        }
                    }
                }
            }
            Spacer(modifier = Modifier.height(19.dp))
            BackgroundTemplate {
                // Set Max height Because we use nested Lazy
                Box(Modifier.heightIn(max = 700.dp)) {
                    LazyVerticalGrid(
                        columns = GridCells.Fixed(3),
                        userScrollEnabled = false,
                        verticalArrangement = Arrangement.spacedBy(8.dp),
                        horizontalArrangement = Arrangement.spacedBy(10.dp)
                    ) {
                        items(objectList.size) {
                            SmallCardComponent(icon = objectList[it].icon ,title = objectList[it].title, description = objectList[it].description)
                        }
                    }
                }
            }
            Text(text = "News and Information", color = Color.White, fontSize = 20.sp, modifier = Modifier.padding(vertical = 20.dp))
            Row (modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 20.dp)){
                Slide()
            }
            Row (horizontalArrangement = Arrangement.Center, modifier = Modifier.fillMaxWidth()){
                Button(onClick = { showBottomSheet = true }, colors = ButtonDefaults.buttonColors(containerColor = Color.White)) {
                    Text(text = "Edit Home", color = Color.Black)
                }
            }
        }
    }
    if (showBottomSheet) {
        ModalBottomSheet(
            onDismissRequest = { showBottomSheet = false },
            shape = RoundedCornerShape(10.dp)
        ) {
            Column(
                modifier = Modifier
                    .height(350.dp)
                    .padding(20.dp)
            ) {
                Row {
                    Text(text = "Appearance", fontSize = 20.sp, fontWeight = FontWeight.Medium)
                }
                Row(modifier = Modifier.padding(vertical = 10.dp)) {
                    buttonItem.forEach {
                        ChipButton(
                            buttonType = it,
                            isSelected = it == selectedChip,
                            onClick = {
                                selectedChip = if (selectedChip == it) null else it
                            }
                        )
                    }
                }
                Column(modifier = Modifier.padding(top = 15.dp)) {
                    if (selectedChip === "Themes") {
                        Row {
                            LazyRow(horizontalArrangement = Arrangement.spacedBy(15.dp)) {
                                items(4) {
                                    Image(
                                        painter = painterResource(id = R.drawable.myui),
                                        modifier = Modifier
                                            .padding(4.dp)
                                            .height(130.dp)
                                            .width(70.dp)
                                            .clip(RoundedCornerShape(10.dp)),
                                        contentScale = ContentScale.Crop,
                                        contentDescription = null,
                                    )
                                }
                            }
                        }
                        Row(modifier = Modifier
                            .fillMaxWidth()
                            .padding(top = 5.dp), horizontalArrangement = Arrangement.End) {
                            Button(onClick = { showBottomSheet = false }) {
                                Text(text = "Save")
                            }
                        }
                    } else if (selectedChip === "Language") {
                        LazyColumn {
                            item {
                                Row (
                                    modifier = Modifier
                                        .fillMaxWidth()
                                        .background(Color.LightGray, RoundedCornerShape(5.dp))
                                        .clickable {
                                            scope.launch {
                                                viewModel.saveLanguage("km")
                                            }
                                            showBottomSheet = false
                                        }
                                ){
                                    Text(
                                        text = "Khmer",
                                        modifier = Modifier
                                            .padding(vertical = 8.dp)
                                            .padding(horizontal = 5.dp)
                                    )
                                }
                                Row (
                                    modifier = Modifier
                                        .fillMaxWidth()
                                        .background(Color.LightGray, RoundedCornerShape(5.dp))
                                        .clickable {
                                            scope.launch {
                                                viewModel.saveLanguage("en-rUS")
                                            }
                                            showBottomSheet = false
                                        }
                                ){
                                    Text(
                                        text = "English" ,
                                        modifier = Modifier
                                            .padding(vertical = 8.dp)
                                            .padding(horizontal = 5.dp)
                                    )
                                }

                            }
                        }

                    } else {
                        Text(text = "Language Option")
                    }
                }
            }
        }
    }
}