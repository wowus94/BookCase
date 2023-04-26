package com.vlyashuk.bookcase.data

import com.vlyashuk.bookcase.network.BookService

interface BooksRepository {
    suspend fun getBooks(query: String, maxResult: Int): List<Book>
}

class NetworkBooksRepository(
    private val bookService: BookService
) : BooksRepository {
    override suspend fun getBooks(
        query: String,
        maxResult: Int
    ): List<Book> = bookService.bookSearch(query, maxResult).items.map { items ->
        Book(
            title = items.volumeInfo?.title,
            previewLink = items.volumeInfo?.imageLinks?.thumbnail,
            imageLink = items.volumeInfo?.imageLinks?.thumbnail
        )
    }
}