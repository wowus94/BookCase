package com.vlyashuk.bookcase.network

import com.vlyashuk.bookcase.network.model.BookShelf
import retrofit2.http.GET
import retrofit2.http.Query

interface BookService {
    @GET("volumes")
    suspend fun bookSearch(
        @Query("q") seaQuery: String,
        @Query("maxResults") maxResult: Int
    ): BookShelf
}