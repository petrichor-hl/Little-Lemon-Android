package com.example.little_lemon

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusManager
import androidx.compose.ui.focus.onFocusChanged
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@OptIn(ExperimentalComposeUiApi::class)
@Composable
fun CustomTextField(
    inputText: MutableState<String>,
    labelText: String,
    placeholderText: String,
    imeAction: ImeAction = ImeAction.Next,
    focusManager: FocusManager
) {


    Column {
        Text(
            labelText,
            modifier = Modifier.padding(bottom = 6.dp),
            color = Color(0xFF8D8D8D),
            fontSize = 12.sp,
            fontWeight = FontWeight.Bold
        )

        OutlinedTextField(
            value = inputText.value,
            onValueChange = {
                inputText.value = it
            },
            modifier = Modifier.fillMaxWidth(),
            placeholder = {
                Text(placeholderText)
            },
            keyboardOptions = KeyboardOptions(imeAction = imeAction),
            keyboardActions = KeyboardActions(
                onDone = {
                    focusManager.clearFocus()
                }
            ),
            shape = RoundedCornerShape(8.dp)
        )
    }

}