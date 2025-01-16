package com.github.asterixorobelix.bitcoinblockexplorer.recent_blocks.detail

data class BlockDetail(
    val id: String,
    val height: Int? = null,
    val difficulty: Double? = null,
    val transactionCount: Int? = null,
    val reward: Int? = null,
    val totalFees: Int? = null,
    val averageTransactionSize: Double? = null
)