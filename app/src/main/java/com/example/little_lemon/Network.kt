package com.example.little_lemon

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class MenuNetwork(
    val menu: List<MenuItemNetwork>
)

@Serializable
data class MenuItemNetwork(
    val id: Int,
    val title: String,
    val description: String,
    val price: Double,
    @SerialName("image")
    val imageUrl: String,
    val category: String
) {
    fun toMenuItemRoom() = MenuItemRoom(id, title, description, price, imageUrl, category)
}

/*
   https://raw.githubusercontent.com/Meta-Mobile-Developer-PC/Working-With-Data-API/main/menu.json

   Bạn có thể thấy thuộc tính "image" trong JSON object bên dưới:

   {
      "id": 1,
      "title": "Greek Salad",
      "description": "The famous greek salad of crispy lettuce, peppers, olives, our Chicago.",
      "price": "10",
      "image": "https://github.com/Meta-Mobile-Developer-PC/Working-With-Data-API/blob/main/images/greekSalad.jpg?raw=true",
      "category": "starters"
    },

    Note: Nhưng tôi không thích đặt tên thuộc tính là "image" trong data class MenuItemNetwork của mình
    nên tôi quyết định đổi thành "val imageUrl: String" ở dòng 18
    và đặt một cái annotation "@SerialName("image")" ở trên
    để cho compiler biết thuộc tính "image" trong JSON object sẽ chuyển thành "imageURL" trong class
 */