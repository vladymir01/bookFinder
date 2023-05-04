package com.example.bookfinder

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.bookfinder.data.DataSource
import com.example.bookfinder.model.Book
import com.example.bookfinder.ui.theme.BookFinderTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            BookFinderTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    DoHomeScreen()
                }
            }
        }
    }
}

@Composable
fun DoHomeScreen(){
    BookFinderTheme {
        BookList(booklist = DataSource().loadBooks())
    }
}

@Composable
fun BookList(booklist:List<Book>, modifier: Modifier=Modifier){
    LazyColumn{
        items(booklist){ book ->
            BookCard(book)
        }
    }
}

@Composable
fun BookCard(book: Book, modifier: Modifier=Modifier){
    Card(modifier = Modifier.padding(8.dp)) {
        Column {
            Image(
                painter = painterResource(id = book.bookImageResourceId),
                contentDescription = stringResource(id = book.bookNameResourceId),
                modifier = Modifier
                    .fillMaxWidth()
                    .height(194.dp),
                contentScale = ContentScale.Crop
            )
            Text(
                text = LocalContext.current.getString(book.bookNameResourceId),
                modifier = Modifier.padding(16.dp),
                style = MaterialTheme.typography.headlineSmall

            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun BookCardPreview() {
    BookFinderTheme {
        BookCard(Book(R.string.seven_habits, R.drawable._habits))
    }
}