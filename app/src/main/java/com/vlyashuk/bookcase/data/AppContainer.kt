package com.vlyashuk.bookcase.data

import com.vlyashuk.bookcase.network.BookService
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

interface AppContainer {
    val bookRepository: BooksRepository
}

class DefaultAppContainer : AppContainer {
    private val BASE_URL = "https://www.googleapis.com/books/v1/"

    private val retrofit: Retrofit = Retrofit.Builder()
        .addConverterFactory(GsonConverterFactory.create())
        .baseUrl(BASE_URL)
        .build()

    private val retrofitService: BookService by lazy {
        retrofit.create(BookService::class.java)
    }

    override val bookRepository: BooksRepository by lazy {
        NetworkBooksRepository(retrofitService)
    }
}