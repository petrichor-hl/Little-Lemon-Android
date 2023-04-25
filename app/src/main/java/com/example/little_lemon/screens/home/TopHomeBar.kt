package com.example.little_lemon.screens.home

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.IconButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.little_lemon.Profile
import com.example.little_lemon.R

@Composable
fun TopHomeBar(navController: NavHostController) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 20.dp, vertical = 16.dp),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Spacer(modifier = Modifier.size(50.dp))

        Image(
            painter = painterResource(id = R.drawable.little_lemon_logo),
            contentDescription = "logo",
            modifier = Modifier
                .fillMaxWidth(0.5F)
        )

        IconButton(
            onClick = {
                navController.navigate(Profile.route)
            },
            modifier = Modifier.size(50.dp)
        ) {
            Image(
                painter = painterResource(id = R.drawable.profile_avatar),
                contentDescription = "avatar",
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun TopHomeBarPreview() {
    val navController = rememberNavController()
    TopHomeBar(navController)
}