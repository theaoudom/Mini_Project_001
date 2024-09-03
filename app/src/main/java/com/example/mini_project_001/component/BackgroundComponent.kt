package com.example.mini_project_001.component

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.geometry.CornerRadius
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.TileMode
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.unit.dp

@Composable
fun BackgroundTemplate(content: @Composable () -> Unit){
    Row (modifier = Modifier
        .fillMaxWidth()
        .padding(3.dp)
        .background(
            Brush.linearGradient(
                colors = listOf(
                    Color.White.copy(alpha = 0.40f),
                    Color.White.copy(alpha = 0.04f)
                )
            ), RoundedCornerShape(17.dp)
        )
        .drawBehind {
            val brush = Brush.linearGradient(
                colors = listOf(
                    Color(0xFFFF2D7C).copy(alpha = 0.48f),
                    Color(0xFFD027B5).copy(alpha = 0.45f),
                    Color(0xFFB623D5).copy(alpha = 0.79f),
                    Color(0xFF941FFF).copy(alpha = 0.38f)
                ),
                start = Offset(0f, 1f),
                end = Offset(size.width, size.height),
                tileMode = TileMode.Clamp
            )

            // Draw the border with rounded corners
            drawRoundRect(
                brush = brush,
                size = Size(size.width, size.height),
                cornerRadius = CornerRadius(50f, 50f),
                style = Stroke(5f)
            )
        }
    ){
        Box(modifier = Modifier
            .fillMaxSize()
            .clip(RoundedCornerShape(24.dp))
            .padding(15.dp)
        ){
            content()
        }
    }
}