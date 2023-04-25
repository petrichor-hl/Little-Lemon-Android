package com.example.little_lemon.screens.home

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.little_lemon.ui.theme.LittleLemonColor
import com.example.little_lemon.R

@Composable
fun HeroSection(searchPhrase: MutableState<String>) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .background(LittleLemonColor.green)
            .padding(start = 12.dp, end = 12.dp, top = 16.dp, bottom = 16.dp)

    ) {
        Text(
            text = "Little Lemon",
            fontSize = 40.sp,
            fontWeight = FontWeight.Bold,
            color = LittleLemonColor.yellow
        )
        Text(
            text = "Chicago",
            modifier = Modifier.padding(bottom = 10.dp),
            fontSize = 24.sp,
            color = LittleLemonColor.cloud
        )
        Row(
            horizontalArrangement = Arrangement.SpaceBetween,
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 14.dp)
        ) {
            Text(
                text = "We are a family-owned Mediterranean restaurant, focused on traditional recipes served with a modern twist",
                fontSize = 18.sp,
                modifier = Modifier
                    .fillMaxWidth(0.6f),
                color = LittleLemonColor.cloud
            )
            Image(
                painter = painterResource(id = R.drawable.hero_image),
                contentDescription = "Upper Panel Image",
                modifier = Modifier
                    .size(120.dp)
                    .clip(RoundedCornerShape(8.dp)),
                contentScale = ContentScale.Crop
            )
        }

        val focusManager = LocalFocusManager.current

        TextField(
            value = searchPhrase.value,
            onValueChange = {
                searchPhrase.value = it
            },
            modifier = Modifier.fillMaxWidth(),
            leadingIcon = {
                Icon(
                    imageVector = ImageVector.vectorResource(id = R.drawable.baseline_search_24),
                    contentDescription = "search icon"
                )
            },
            placeholder = {
                Text("Enter search phrase")
            },
            keyboardOptions = KeyboardOptions(imeAction = ImeAction.Done),
            keyboardActions = KeyboardActions(
                onDone = {
                    focusManager.clearFocus()
                }
            ),
            shape = RoundedCornerShape(10.dp),
            colors = TextFieldDefaults.textFieldColors(
                /*
                 Set màu nền:
                 Khi set màu nền ở đây (trong thuộc tính "colors") thay vì "modifier" ở trên
                 thì cái màu sẽ nằm gọn trong cái "shape" mà không bị tràn ra ngoài

                 -> Thử set màu nền ở "modifier" thì sẽ thấy 4 góc được bo nó bị tràn màu
                 */
                backgroundColor = LittleLemonColor.cloud,
                /*
                 Tui không thích cái gạch chân ở dưới cái TextField nên tui muốn bỏ
                 Trick: Bỏ gạch chân ở dưới TextField
                 */
                focusedIndicatorColor = Color(0x00000000),
                unfocusedIndicatorColor = Color(0x00000000)
            )
        )
    }
}

@Preview(showBackground = true)
@Composable
fun HeroSectionPreview() {
    var searchPhrase = remember {
        mutableStateOf("")
    }

    HeroSection(searchPhrase)
}