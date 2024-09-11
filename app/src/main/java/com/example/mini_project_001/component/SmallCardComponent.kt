package com.example.mini_project_001.component

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun SmallCardComponent(
    icon: Painter, title:String, description:String
){
    Card(modifier = Modifier
        .fillMaxWidth()
        .height(85.dp), shape = RoundedCornerShape(16.dp), colors = CardDefaults.cardColors(
        containerColor = Color.White
    )){
        Box(modifier = Modifier.padding(8.dp)){
            Row (Modifier.fillMaxSize(), horizontalArrangement = Arrangement.End){
                Icon(painter = icon, contentDescription = null, tint = Color.Unspecified, modifier = Modifier.size(30.dp))
            }
            Column(modifier = Modifier.fillMaxSize(), verticalArrangement = Arrangement.Center){
                Text(text = title, fontSize = (11.5).sp, fontWeight = FontWeight.Medium, color = Color(0xFF202F45))
                Text(text = description, fontSize = 9.sp, fontWeight = FontWeight.W300, color = Color(0xFF31456A), modifier = Modifier.padding(top = 2.dp))
            }
        }
    }
}
