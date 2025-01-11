package com.github.asterixorobelix.bitcoinblockexplorer.di

import com.github.asterixorobelix.bitcoinblockexplorer.network.MempoolClient
import com.github.asterixorobelix.bitcoinblockexplorer.recent_blocks.BlocksRepository
import com.github.asterixorobelix.bitcoinblockexplorer.recent_blocks.RecentBlocksViewModel
import io.ktor.client.HttpClient
import org.koin.core.module.dsl.bind
import org.koin.core.module.dsl.singleOf
import org.koin.core.module.dsl.viewModel
import org.koin.dsl.module

val recentBlockModule = module {
    single { MempoolClient(get()) }
    viewModel { RecentBlocksViewModel(get()) }
    single { BlocksRepository(get()) }
    single{ HttpClient()}
}