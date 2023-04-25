package com.example.little_lemon.screens

import androidx.activity.ComponentActivity
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.core.content.edit
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.little_lemon.Onboarding
import com.example.little_lemon.R
import com.example.little_lemon.ui.theme.LittleLemonColor

@Composable
fun Profile(navController: NavHostController) {

    val context = LocalContext.current
    val sharedPreferences = context.getSharedPreferences("LittleLemon", ComponentActivity.MODE_PRIVATE)

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 20.dp)
    ) {
        Image(
            painter = painterResource(id = R.drawable.little_lemon_logo),
            contentDescription = "logo",
            modifier = Modifier
                .fillMaxWidth(0.4F)
                .align(Alignment.CenterHorizontally)
                .padding(vertical = 20.dp)
        )

        Text (
            "Personal information",
            modifier = Modifier
                .padding(vertical = 60.dp),
            fontSize = 18.sp,
            fontWeight = FontWeight.Bold
        )

        Text(
            "First name",
            modifier = Modifier.padding(bottom = 6.dp),
            color = Color(0xFF8D8D8D),
            fontSize = 12.sp,
            fontWeight = FontWeight.Bold
        )
        OutlinedTextField(
            value = sharedPreferences.getString("firstName", "")!!,
            onValueChange = {},
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 40.dp),
            enabled = false,
            shape = RoundedCornerShape(8.dp)
        )

        Text(
            "Last name",
            modifier = Modifier.padding(bottom = 6.dp),
            color = Color(0xFF8D8D8D),
            fontSize = 12.sp,
            fontWeight = FontWeight.Bold
        )
        OutlinedTextField(
            value = sharedPreferences.getString("lastName", "")!!,
            onValueChange = {},
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 40.dp),
            enabled = false,
            shape = RoundedCornerShape(8.dp)
        )

        Text(
            "Email",
            modifier = Modifier.padding(bottom = 6.dp),
            color = Color(0xFF8D8D8D),
            fontSize = 12.sp,
            fontWeight = FontWeight.Bold
        )
        OutlinedTextField(
            value = sharedPreferences.getString("email", "")!!,
            onValueChange = {},
            modifier = Modifier.fillMaxWidth(),
            enabled = false,
            shape = RoundedCornerShape(8.dp)
        )

        Spacer(modifier = Modifier.weight(1F))

        Button(
            onClick = {
                sharedPreferences.edit(commit = true) {
                    clear()
                }
                navController.navigate(Onboarding.route)
            },
            modifier = Modifier.fillMaxWidth()
                .padding(bottom = 20.dp),
            shape = RoundedCornerShape(8.dp),
            colors = ButtonDefaults.buttonColors(LittleLemonColor.yellow)
        ) {
            Text("Log out")
        }

    }
}

@Preview(showBackground = true)
@Composable
fun ProfilePreview() {

    val navController = rememberNavController()

    Surface(modifier = Modifier.fillMaxSize()) {
        Profile(navController)
    }
}