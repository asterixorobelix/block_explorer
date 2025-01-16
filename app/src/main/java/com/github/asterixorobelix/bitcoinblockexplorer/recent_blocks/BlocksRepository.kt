package com.github.asterixorobelix.bitcoinblockexplorer.recent_blocks

import com.github.asterixorobelix.bitcoinblockexplorer.network.MempoolClient
import com.github.asterixorobelix.bitcoinblockexplorer.recent_blocks.detail.BlockDetail

/**
 * Retrieves block information
 * @param [mempoolClient]
 */
class BlocksRepository(
    private val mempoolClient: MempoolClient
) {

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

    /**
     * Obtains information about a specific block
     * @param blockID id of the block
     * @return [BlockDetail]
     */
    suspend fun getBlockById(blockID: String): BlockDetail {
        val response = mempoolClient.getBlockByID(id = blockID)
        return BlockDetail(
            id = response.id,
            height = response.height,
            transactionCount = response.transactionCount,
            difficulty = response.difficulty,
            averageTransactionSize = response.extras?.averageTransactionSize,
            reward = response.extras?.reward,
            totalFees = response.extras?.totalFees,
        )
    }

}