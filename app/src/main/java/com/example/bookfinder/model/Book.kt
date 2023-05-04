package com.example.bookfinder.model

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes

data class Book(
                    @StringRes val bookNameResourceId: Int,
                    @DrawableRes val bookImageResourceId: Int
)
