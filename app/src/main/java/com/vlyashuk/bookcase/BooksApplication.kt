package com.vlyashuk.bookcase

import android.app.Application
import com.vlyashuk.bookcase.data.AppContainer
import com.vlyashuk.bookcase.data.DefaultAppContainer

class BooksApplication : Application() {

    lateinit var container: AppContainer
    override fun onCreate() {
        super.onCreate()
        container = DefaultAppContainer()
    }
}