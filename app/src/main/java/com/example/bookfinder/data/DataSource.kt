package com.example.bookfinder.data

import com.example.bookfinder.R
import com.example.bookfinder.model.Book

class DataSource() {
    fun loadBooks():List<Book>{
        return listOf<Book>(
            Book(bookNameResourceId = R.string.am_club, bookImageResourceId = R.drawable._amclub ),
            Book(bookNameResourceId = R.string.seven_habits, bookImageResourceId = R.drawable._habits ),
            Book(bookNameResourceId = R.string.laws_of_power, bookImageResourceId = R.drawable._8lawsofpower ),
            Book(bookNameResourceId = R.string.crucial_conversations, bookImageResourceId = R.drawable.crucialconversations ),
            Book(bookNameResourceId = R.string.dei, bookImageResourceId = R.drawable.dei )
        )
    }
}