package com.github.asterixorobelix.bitcoinblockexplorer.utilities

import com.github.asterixorobelix.bitcoinblockexplorer.db.BlockEntity
import com.github.asterixorobelix.bitcoinblockexplorer.recent_blocks.RecentBlock

fun List<BlockEntity>.toRecentBLock(): List<RecentBlock> {
    return this.map {
        RecentBlock(
            id = it.id,
            blockHeight = it.blockHeight,
            transactions = it.transactions,
            difficulty = it.difficulty,
            averageFee = it.averageFee,
            reward = it.reward
        )
    }
}

fun List<RecentBlock>.toBlockEntity(): List<BlockEntity> {
    return this.map {
        BlockEntity(
            id = it.id,
            blockHeight = it.blockHeight,
            transactions = it.transactions,
            difficulty = it.difficulty,
            averageFee = it.averageFee,
            reward = it.reward
        )
    }
}