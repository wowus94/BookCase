package com.vlyashuk.bookcase.ui.screens

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.vlyashuk.bookcase.ui.theme.BooksUiState

@Composable
fun HomeScreen(
    booksUiState: BooksUiState,
    retryAction: () -> Unit,
    modifier: Modifier = Modifier
) {
    when (booksUiState) {
        is BooksUiState.Loading -> LoadingScreen(modifier)
        is BooksUiState.Success -> BooksGridScreen(
            books = booksUiState.bookSearch,
            modifier = modifier
        )

        is BooksUiState.Error -> ErrorScreen(retryAction = retryAction, modifier)
        else -> {}
    }
}