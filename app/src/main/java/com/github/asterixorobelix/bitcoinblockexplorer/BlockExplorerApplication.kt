package com.github.asterixorobelix.bitcoinblockexplorer

import android.app.Application
import com.github.asterixorobelix.bitcoinblockexplorer.di.recentBlockModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.GlobalContext.startKoin
import org.koin.core.logger.Level
import org.koin.logger.SLF4JLogger

class BlockExplorerApplication : Application() {
    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidLogger(Level.INFO)
            androidContext(this@BlockExplorerApplication)
            modules(recentBlockModule)
        }
    }
}