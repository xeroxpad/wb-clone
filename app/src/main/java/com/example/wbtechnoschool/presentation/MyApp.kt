package com.example.wbtechnoschool.presentation

import android.app.Application
import com.example.data.repository.di.dataModule
import com.example.domain.di.domainModule
import com.example.wbtechnoschool.di.presentationModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.GlobalContext.startKoin
import org.koin.core.logger.Level

class MyApp : Application() {
    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidLogger(Level.INFO)
            androidContext(this@MyApp)
            modules(listOf(presentationModule, domainModule, dataModule))
        }
    }
}
