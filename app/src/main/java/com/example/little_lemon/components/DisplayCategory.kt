package com.example.little_lemon.components

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.little_lemon.ui.theme.LittleLemonColor

@Composable
fun DisplayCategory(categoryItem: String) {

    var selected by remember {
        mutableStateOf(false)
    }

    Text(
        categoryItem,
        modifier = Modifier
            .clip(RoundedCornerShape(12.dp))
            /*
            interactionSource: không biết :v, thêm vào cho đủ tham số,
            indication: là hiệu ứng ripple khi cái UI được click
            mà ở đây, tui không thích cái hiệu ứng đó, nên tui cho nó bằng null

            nếu muốn có hiệu ứng ripple khi click thì bỏ 2 cái interactionSource và indication này đi
             */
            .clickable(interactionSource = remember { MutableInteractionSource() }, indication = null) {
                selected = !selected
            }
            .background(if (selected) LittleLemonColor.green else Color(0xFFEFEFEF))
            .padding(horizontal = 10.dp, vertical = 8.dp),
        fontWeight = FontWeight.Bold,
        color = if (selected) Color(0xFFEFEFEF) else LittleLemonColor.green,
    )
}

@Preview(showBackground = true)
@Composable
fun DisplayCategoryPreview() {
    DisplayCategory("Desserts")
}