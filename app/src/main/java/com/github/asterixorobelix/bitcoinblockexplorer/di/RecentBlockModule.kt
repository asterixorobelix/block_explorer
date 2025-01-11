package com.github.asterixorobelix.bitcoinblockexplorer.di

import androidx.room.Room
import com.github.asterixorobelix.bitcoinblockexplorer.db.BlockExplorerDatabase
import com.github.asterixorobelix.bitcoinblockexplorer.network.MempoolClient
import com.github.asterixorobelix.bitcoinblockexplorer.recent_blocks.BlocksRepository
import com.github.asterixorobelix.bitcoinblockexplorer.recent_blocks.RecentBlocksViewModel
import io.ktor.client.HttpClient
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.serialization.kotlinx.json.json
import kotlinx.serialization.json.Json
import org.koin.android.ext.koin.androidContext
import org.koin.core.module.dsl.viewModel
import org.koin.dsl.module

val recentBlockModule = module {
    single { MempoolClient(get()) }
    viewModel { RecentBlocksViewModel(get(), get ()) }
    single { BlocksRepository(get()) }
    single {
        HttpClient {
            install(ContentNegotiation) {
                json(Json {
                    prettyPrint = true
                    isLenient = true
                    ignoreUnknownKeys = true
                })
            }
        }
    }
    single<BlockExplorerDatabase> {
        Room.databaseBuilder(
            androidContext(),
            BlockExplorerDatabase::class.java, "block_explorer_database"
        ).build()
    }
}