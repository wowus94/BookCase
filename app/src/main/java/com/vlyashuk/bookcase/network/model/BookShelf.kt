package com.vlyashuk.bookcase.network.model

data class BookShelf(
    val items: List<Item>,
    val kind: String,
    val totalItems: Int
)