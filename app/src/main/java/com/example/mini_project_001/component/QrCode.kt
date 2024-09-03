package com.example.mini_project_001.component

import android.graphics.Bitmap
import android.graphics.Color
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.asImageBitmap
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.google.zxing.BarcodeFormat
import com.google.zxing.WriterException
import com.google.zxing.common.BitMatrix
import com.google.zxing.qrcode.QRCodeWriter
import com.example.mini_project_001.R

// Function for generate QR Code
fun generateQrCode(text:String, size:Int): Bitmap? {
    val writer = QRCodeWriter()

    return try{
        val bitMatrix: BitMatrix = writer.encode(text, BarcodeFormat.QR_CODE, size, size)
        val width = bitMatrix.width
        val height = bitMatrix.height
        val bitmap = Bitmap.createBitmap(width, height, Bitmap.Config.RGB_565)
        for (x in 0 until width) {
            for (y in 0 until height) {
                bitmap.setPixel(x, y, if (bitMatrix[x, y]) Color.BLACK else Color.WHITE)
            }
        }
        bitmap
    }catch (e: WriterException){
        e.printStackTrace()
        null
    }
}

@Composable
fun QRImage(bitmap : Bitmap){
    Box(contentAlignment = Alignment.Center, modifier = Modifier.fillMaxSize()){
        Image(
            bitmap = bitmap.asImageBitmap(), contentDescription = "QR Code "
        )
        //Image Center of QRCode
        Box(
            modifier = Modifier
                .size(60.dp)
                .border(BorderStroke(3.dp, androidx.compose.ui.graphics.Color.White), CircleShape)
                .clip(CircleShape)
                .background(androidx.compose.ui.graphics.Color.Black)
                .padding(14.dp)
        ) {
            Box(modifier = Modifier.padding(vertical = 2.dp)){
                Image(
                    painter = painterResource(id = R.drawable.lgog_hrd),
                    contentDescription = null,
                    modifier = Modifier
                        .fillMaxSize()
                        .clip(CircleShape)
                )
            }
        }
    }
}

// Connect Image of QRCode with Link

@Preview
@Composable
fun PreviewQRCode(){
    val decodeFromQR = "00020101021129370009khqr@aclb011008847745150206ACLEDA392000118551414649701014520420005802KH53038405910Thea Oudom6010Phnom Penh62140210088477451563040CA7"
    MaterialTheme {
        Surface{
            val qrBitmap = generateQrCode(decodeFromQR, 712)
            qrBitmap?.let { QRImage(it) }
        }
    }
}