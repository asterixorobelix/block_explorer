package com.github.asterixorobelix.bitcoinblockexplorer.di

import com.github.asterixorobelix.bitcoinblockexplorer.network.MempoolClient
import com.github.asterixorobelix.bitcoinblockexplorer.recent_blocks.BlocksRepository
import com.github.asterixorobelix.bitcoinblockexplorer.recent_blocks.RecentBlocksViewModel
import org.koin.core.module.dsl.bind
import org.koin.core.module.dsl.singleOf
import org.koin.core.module.dsl.viewModel
import org.koin.dsl.module

val recentBlockModule = module {
    singleOf(::MempoolClient) { bind<MempoolClient>() }
    viewModel { RecentBlocksViewModel(get()) }
    single { BlocksRepository(get()) }
}