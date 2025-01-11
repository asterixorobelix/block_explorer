package com.github.asterixorobelix.bitcoinblockexplorer.recent_blocks

data class RecentBlock(
    val id: String,
    val blockHeight: Int?,
    val transactions: Int?,
    val difficulty: Double?,
    val averageFee: Int?,
    val reward: Int?
)
