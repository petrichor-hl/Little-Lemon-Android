package com.example.little_lemon.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import androidx.room.Room
import com.example.little_lemon.AppDatabase
import com.example.little_lemon.screens.home.HeroSection
import com.example.little_lemon.screens.home.LowerPanel
import com.example.little_lemon.screens.home.TopHomeBar

@Composable
fun Home(navController: NavHostController) {
    val context = LocalContext.current

    val database by lazy {
        Room.databaseBuilder(
            context,
            AppDatabase::class.java,
            "database"
        ).build()
    }

    val databaseMenuItems by database.menuItemDao().getAll().observeAsState(emptyList())

    var searchPhrase = remember {
        mutableStateOf("")
    }

    Column {
        TopHomeBar(navController)
        HeroSection(searchPhrase)
        LowerPanel(menuItems = databaseMenuItems, searchPhrase.value)
    }
}

@Preview(showBackground = true)
@Composable
fun HomePreview() {
    val navController = rememberNavController()
    Surface(modifier = Modifier.fillMaxSize()) {
        Home(navController)
    }
}