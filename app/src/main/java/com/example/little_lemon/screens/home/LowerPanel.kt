package com.example.little_lemon.screens.home

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Divider
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.little_lemon.MenuItemRoom
import com.example.little_lemon.components.DisplayCategory
import com.example.little_lemon.components.DisplayMenuItem

@Composable
fun LowerPanel(menuItems: List<MenuItemRoom>, searchPhrase: String) {
    CategoryList()
    DisplayMenu(menuItems.filter { it.title.contains(searchPhrase, ignoreCase = true) })
}

@Composable
fun CategoryList() {
    Column(
        modifier = Modifier.padding(horizontal = 20.dp)
    ) {
        Text(
            text = "ORDER FOR DELIVERY!",
            fontWeight = FontWeight.Bold,
            fontSize = 22.sp,
            modifier = Modifier.padding(top = 20.dp, bottom = 14.dp)
        )

        val categoryList = listOf("Starters", "Mains", "Desserts", "Drinks")

        LazyRow(
            horizontalArrangement = Arrangement.spacedBy(30.dp),
            modifier = Modifier.padding(bottom = 16.dp)
        ) {
            items(categoryList) {
                DisplayCategory(categoryItem = it)
            }
        }

        Divider()

    }
}

@Composable
fun DisplayMenu(menuItems: List<MenuItemRoom>) {
    LazyColumn {
        items(menuItems) {menuItem ->
            DisplayMenuItem(menuItem)
        }
    }
}

