package com.example.mini_project_001.component

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.FilterChip
import androidx.compose.material3.FilterChipDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

//@Preview(device = Devices.PIXEL)
@Composable
fun ChipButton(
    buttonType: String,
    isSelected: Boolean,
    onClick: () -> Unit
) {
    FilterChip(
        selected = isSelected,
        onClick = onClick,
        label = {
            Text(text = buttonType, fontSize = 16.sp)
        },
        colors = FilterChipDefaults.filterChipColors(
            containerColor = if (isSelected) Color(0xFF6200EE) else Color(0xFFE4E4E4).copy(alpha = 0.6f),
        ),
        modifier = Modifier.padding(end = 10.dp),
        border = FilterChipDefaults.filterChipBorder(
            borderColor = Color.Transparent,
            disabledBorderColor = Color.Transparent,
            selectedBorderColor = Color.Transparent,
            disabledSelectedBorderColor = Color.Transparent,
            enabled = false,
            selected = false
        )
    )
}