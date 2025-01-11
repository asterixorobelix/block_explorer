package com.github.asterixorobelix.bitcoinblockexplorer.recent_blocks

import com.github.asterixorobelix.bitcoinblockexplorer.network.MempoolClient

/**
 * Retrieves block information
 * @param [mempoolClient]
 */
class BlocksRepository(private val mempoolClient: MempoolClient) {

    /**
     * Retrieves the last 15 blocks
     * @return [List] of [RecentBlock]
     */
    suspend fun getRecentBlocks(): List<RecentBlock> {
        val response = mempoolClient.getBlocks()
        return response.map {
            RecentBlock(
                id = it.id,
                blockHeight = it.height,
                transactions = it.transactionCount,
                difficulty = it.difficulty,
                averageFee = it.extras?.averageFee,
                reward = it.extras?.reward
            )
        }
    }
}