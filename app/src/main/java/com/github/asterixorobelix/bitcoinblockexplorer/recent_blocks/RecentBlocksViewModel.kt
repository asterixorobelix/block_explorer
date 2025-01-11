package com.github.asterixorobelix.bitcoinblockexplorer.recent_blocks

import androidx.lifecycle.ViewModel

class RecentBlocksViewModel(private val blocksRepository: BlocksRepository) : ViewModel() {
    suspend fun getRecentBlocks() = blocksRepository.getRecentBlocks()
}