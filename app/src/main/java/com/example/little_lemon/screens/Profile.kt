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
import androidx.navigation.NavOptions
import androidx.navigation.compose.rememberNavController
import com.example.little_lemon.Home
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
                navController.navigate(
                    Onboarding.route,
                    navOptions = NavOptions.Builder()
                        .setPopUpTo(Onboarding.route, inclusive = true)
                        .build()
                        /*
                         Rê chuột vào "setPopUpTo" đọc kĩ document

                         Note cho tương lai:
                         Mục đích của Button này là Log out tài khoản và chuyển người dùng về Onboarding Screen
                         Khi đã về Onboaring Screen thì sau đó chỉ cần nhấn backbutton trên điện thoại là thoát app luôn

                         parameter 1: Là cái destination mà sẽ được pop-up đến trong back stack navigaiton
                         parameter 2: inclusive
                            - Nếu là "true" thì tức là pop-up luôn destination được gán là parameter 1
                            - Ngược lại, "false" thì không pop-up destination parameter 1

                         Đọc thêm note bên dưới cùng là hiểu nhé, tui của tương lai
                         */
                )
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

/*
 Thêm 1 ví dụ về setPopUpTo cho dễ hiểu:
 For example, suppose we have a navigation stack with destinations A, B, C, and D in that order.
 -  If we call navigate with popUpTo set to B and inclusive set to true,
    then the navigation stack will be cleared, and only destination A will be left on the stack.
    (tức là nếu nhấn "back button" hoặc thực hiện "navigate up" thì từ destination B sẽ chuyển về destination A)
 -  If inclusive was set to false, then only destinations C and D would be removed,
    and the user could still navigate back to destination B.
    (tức là nếu nhấn "back button" hoặc thực hiện "navigate up" thì từ destination B sẽ chuyển về destination B =)))
 => Lười đọc thì set inclusive = true :) cho lẹ
 */