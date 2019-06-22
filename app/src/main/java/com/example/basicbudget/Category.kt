package com.example.basicbudget

import android.widget.ImageView

data class Category (
    val image: Int,
    val main_category: String,
    val sub_categories: List<String>
)