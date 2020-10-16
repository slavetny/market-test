package com.slavetny.market

import android.app.Application
import com.slavetny.market.di.modules.databaseModule
import com.slavetny.market.di.modules.networkModule
import com.slavetny.market.di.modules.viewModelModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin

class MarketApp : Application() {
    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidContext(this@MarketApp)
            androidLogger()
            modules(
                listOf(
                    viewModelModule, networkModule, databaseModule
                )
            )
        }
    }
}