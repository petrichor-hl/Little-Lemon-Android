package com.example.little_lemon.screens

import android.widget.ImageButton
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.IconButton
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.modifier.modifierLocalConsumer
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.little_lemon.Onboarding
import com.example.little_lemon.Profile
import com.example.little_lemon.R
import kotlinx.coroutines.launch

@Composable
fun Home(navController: NavHostController) {
    Column {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(20.dp),
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
}

@Preview(showBackground = true)
@Composable
fun HomePreview() {
    val navController = rememberNavController()
    Surface(modifier = Modifier.fillMaxSize()) {
        Home(navController)
    }
}