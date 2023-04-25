package com.example.little_lemon.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Divider
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.bumptech.glide.integration.compose.ExperimentalGlideComposeApi
import com.bumptech.glide.integration.compose.GlideImage
import com.example.little_lemon.MenuItemRoom
import com.example.little_lemon.ui.theme.LittleLemonColor


@OptIn(ExperimentalGlideComposeApi::class)
@Composable
fun DisplayMenuItem(menuItem: MenuItemRoom) {

    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 20.dp)
            .padding(vertical = 10.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Column {
            Text(
                menuItem.title,
                fontSize = 16.sp,
                fontWeight = FontWeight.Bold,
            )
            Text(
                menuItem.description,
                color = Color.Gray,
                modifier = Modifier
                    .fillMaxWidth(0.64f)
                    .padding(vertical = 5.dp),
                overflow = TextOverflow.Ellipsis,
                maxLines = 2
            )

            Text(
                "$ ${"%.2f".format(menuItem.price)}",
                fontWeight = FontWeight.Bold,
                fontFamily = FontFamily.Monospace
            )
        }

        Spacer(modifier = Modifier.weight(1f))

        GlideImage(
            model = menuItem.imageUrl,
            contentDescription = "menu image",
            modifier = Modifier.size(100.dp).clip(RoundedCornerShape(8.dp)),
            contentScale = ContentScale.Crop
        )
    }

    Divider(
        modifier = Modifier.padding(horizontal = 20.dp),
        thickness = 1.dp,
        color = Color(0xFFDFDFDF)
    )
}

@Preview(showBackground = true)
@Composable
fun DisplayMenuItemPreview() {
    val menuItemPreview = MenuItemRoom(
        id = 3,
        title = "Grilled Fish",
        description = "Our Bruschetta is made from grilled bread that has been smeared with garlic and seasoned with salt and olive oil.",
        price = 10.00,
        imageUrl = "https://github.com/Meta-Mobile-Developer-PC/Working-With-Data-API/blob/main/images/grilledFish.jpg?raw=true",
        category = "mains"
    )
    DisplayMenuItem(menuItemPreview)
}