package com.example.mini_project_001.component

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.window.Dialog
import androidx.compose.ui.window.DialogProperties
import androidx.constraintlayout.compose.ConstraintLayout
import com.example.mini_project_001.R


@Preview(device = Devices.PIXEL, showBackground = true, backgroundColor = 0x00468B )
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TopAppBars(){
    val name = "Oudom"
    var dialogState by remember { mutableStateOf(false) }

    TopAppBar(
        navigationIcon = {
            IconButton(onClick = { /*TODO*/ }) {
                Image(painter = painterResource(id = R.drawable.profile_mini001), contentDescription = "Profile", modifier = Modifier.size(500.dp).border(BorderStroke(2.dp,Color.White), CircleShape).padding(0.dp).padding(0.dp))
            }
        },
        title = {
            Column {
                //UserName
                Text(text = "Hello, $name !" , color = Color.White, fontWeight = FontWeight.Medium, fontSize = 20.sp)
                Text(text = "View Profile", fontWeight = FontWeight.W300, fontSize = 15.sp, color = Color.White)
            }
        },
        actions = {
            // Notification
            Alignment.Center
            IconButton(onClick = { /*TODO*/ }, modifier = Modifier.padding(0.dp)) {
                Image(painter = painterResource(id = R.drawable.notification_mini001), contentDescription = "Notification",
                    modifier = Modifier.size(22.dp).padding(0.dp)
                )
            }
            // Qr code Button
            IconButton(onClick = { dialogState = !dialogState }) {
                Image(painter = painterResource(id = R.drawable.button_qrcode_mini001), contentDescription = null)
            }
        },
        modifier = Modifier
            .background(Color.Transparent)
            .padding(top = 20.dp)
            .padding(bottom = 10.dp),
        colors = TopAppBarDefaults.topAppBarColors(containerColor = Color.Transparent)
    )

    // Show Dialog QR Code
    if (dialogState){
        Dialog(onDismissRequest = { /*TODO*/ }, properties = DialogProperties(usePlatformDefaultWidth = false)){
            Box(modifier = Modifier.fillMaxSize()){
                Column(horizontalAlignment = Alignment.End, modifier = Modifier
                    .fillMaxSize()
                    .padding(15.dp)) {
                    IconButton(
                        onClick = { dialogState = false },
                        modifier = Modifier
                            .background(Color.Gray, CircleShape)
                            .size(30.dp)
                    ) {
                        Icon(imageVector = Icons.Default.Close, tint = Color.White, contentDescription = null)
                    }
                }
                // QR Code
                Box(contentAlignment = Alignment.Center, modifier = Modifier.fillMaxSize()){
                    ConstraintLayout {
                        val (image, qr,title) = createRefs()
                        Image(
                            painter = painterResource(id = R.drawable.qr_bg_mini001), contentDescription = null,
                            modifier = Modifier
                                .size(420.dp)
                                .constrainAs(image) {
                                    top.linkTo(parent.top)
                                    bottom.linkTo(parent.bottom)
                                    start.linkTo(parent.start)
                                    end.linkTo(parent.end)
                                }
                        )
                        Box(modifier = Modifier
                            .width(258.dp)
                            .height(256.dp)
                            .constrainAs(qr) {
                                end.linkTo(image.end, margin = 3.dp)
                                bottom.linkTo(image.bottom, margin = (16).dp)
                                start.linkTo(image.start, margin = 3.dp)
                            }
                        ){
                            PreviewQRCode()
                        }
                        Column (
                            modifier = Modifier.constrainAs(title){
                                start.linkTo(qr.start, margin = 22.dp)
                                top.linkTo(image.top, margin = 70.dp)
                            }
                        ){
                            Text(text = "Thea Oudom", fontSize = 15.sp, modifier = Modifier.padding(vertical = 5.dp))
                            Row (verticalAlignment = Alignment.CenterVertically){
                                Text(text = "0 ", fontWeight = FontWeight.Bold, fontSize = 20.sp)
                                Text(text = "USD", fontSize = 15.sp)
                            }
                        }
                    }
                }
            }
        }
    }
}