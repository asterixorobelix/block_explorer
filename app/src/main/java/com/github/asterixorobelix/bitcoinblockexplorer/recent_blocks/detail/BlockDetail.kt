package com.github.asterixorobelix.bitcoinblockexplorer.recent_blocks.detail

data class BlockDetail(
    val id: String,
    val height: Int? = null,
    val difficulty: Double? = null,
    val transactionCount: Int? = null,
    val reward: Int? = null,
    val totalFees: Int? = null,
    val averageTransactionSize: Double? = null
) {
    fun getText(id: Int): String {
        return when (id) {
            0 -> "Height: ${height?.toDouble()}"
            1 -> "Difficulty: $difficulty"
            2 -> "Transactions: ${transactionCount?.toDouble()}"
            3 -> "Reward: ${reward?.toDouble()}"
            4 -> "Fees: ${totalFees?.toDouble()}"
            else -> "Transaction Size: $averageTransactionSize"
        }
    }
}