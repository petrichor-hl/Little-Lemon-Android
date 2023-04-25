package com.example.little_lemon

import android.content.SharedPreferences
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.gestures.detectTapGestures
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.core.content.edit
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.little_lemon.ui.theme.LittleLemonColor

@Composable
fun Onboarding(navController: NavHostController) {
    val context = LocalContext.current
    val sharedPreferences = context.getSharedPreferences("LittleLemon", ComponentActivity.MODE_PRIVATE)
    val focusManager = LocalFocusManager.current
    Column(
        modifier = Modifier.pointerInput(Unit) {
            detectTapGestures(
                onTap = {
                    focusManager.clearFocus()
                }
            )
        }
    ) {
        Image(
            painter = painterResource(id = R.drawable.little_lemon_logo),
            contentDescription = "logo",
            modifier = Modifier
                .fillMaxWidth(0.4F)
                .align(Alignment.CenterHorizontally)
                .padding(vertical = 20.dp)
        )

        Text(
            "Let's get to known you",
            modifier = Modifier
                .fillMaxWidth()
                .background(LittleLemonColor.green)
                .padding(vertical = 36.dp),
            color = Color.White,
            fontSize = 22.sp,
            textAlign = TextAlign.Center
        )

        Text (
            "Personal information",
            modifier = Modifier
                .padding(start = 20.dp)
                .padding(vertical = 50.dp),
            fontSize = 18.sp,
            fontWeight = FontWeight.Bold
        )

        Column(
            modifier = Modifier.padding(horizontal = 20.dp),
            verticalArrangement = Arrangement.spacedBy(30.dp)
        ) {

            var firstNameInput = remember {
                mutableStateOf("")
            }
            CustomTextField(inputText = firstNameInput, labelText = "First name", placeholderText = "Tilly", focusManager = focusManager)


            var lastNameInput = remember {
                mutableStateOf("")
            }
            CustomTextField(inputText = lastNameInput, labelText = "Last name", placeholderText = "Doe", focusManager = focusManager)

            var emailInput = remember {
                mutableStateOf("")
            }
            CustomTextField(inputText = emailInput, labelText = "Email", placeholderText = "tillydoe@example.com", imeAction = ImeAction.Done, focusManager = focusManager)

           var informText by remember {
               mutableStateOf("")
           }

            Box(
                modifier = Modifier
                    .weight(1F)
                    .fillMaxWidth(),
                contentAlignment = Alignment.Center
            ) {
                Text(
                    text = informText,
                    textAlign = TextAlign.Center
                )
            }

            Button(
                onClick = {
                    if (firstNameInput.value.isEmpty() || lastNameInput.value.isEmpty() || emailInput.value.isEmpty()) {
                        informText = """Registration unsuccessful
                            |Please enter all data.
                            """.trimMargin()
                    } else {
                        sharedPreferences.edit(commit = true) {
                            putBoolean("isLoggedin", true)
                            putString("firstName", firstNameInput.value)
                            putString("lastName", lastNameInput.value)
                            putString("email", emailInput.value)
                        }
                        Toast.makeText(context, "Registration successful!", Toast.LENGTH_SHORT)
                            .show()

                        navController.navigate(Home.route)
                    }
                },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(bottom = 20.dp),
                shape = RoundedCornerShape(8.dp),
                colors = ButtonDefaults.buttonColors(LittleLemonColor.yellow)
            ) {
                Text(text = "Register")
            }
        }

    }
}

@Preview(showBackground = true)
@Composable
fun OnboardingPreview() {
    val navController = rememberNavController()
    Onboarding(navController = navController)
}