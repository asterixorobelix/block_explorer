package com.github.asterixorobelix.bitcoinblockexplorer

import android.app.Application
import com.github.asterixorobelix.bitcoinblockexplorer.di.recentBlockModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.GlobalContext.startKoin

class BlockExplorerApplication : Application() {
    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidLogger()
            androidContext(this@BlockExplorerApplication)
            modules(recentBlockModule)
        }
    }
}