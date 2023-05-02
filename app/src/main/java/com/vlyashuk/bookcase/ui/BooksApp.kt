@file:OptIn(ExperimentalMaterial3Api::class)

package com.vlyashuk.bookcase.ui

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.lifecycle.viewmodel.compose.viewModel
import com.vlyashuk.bookcase.R
import com.vlyashuk.bookcase.ui.screens.HomeScreen
import com.vlyashuk.bookcase.ui.theme.BooksViewModel

@Composable
fun BookApp(
    modifier: Modifier = Modifier
) {
    val booksViewModel: BooksViewModel = viewModel(factory = BooksViewModel.Factory)

    Scaffold(
        modifier = modifier.fillMaxSize(),
        topBar = {
            TopAppBar(
                title = {
                    Text(text = stringResource(id = R.string.app_name))
                }
            )
        }

    ) {
        Surface(
            modifier = modifier
                .fillMaxSize()
                .padding(it)
        ) {
            HomeScreen(
                booksUiState = booksViewModel.booksUiState,
                retryAction = { booksViewModel.getBooks() },
                modifier = modifier
            )
        }
    }
}