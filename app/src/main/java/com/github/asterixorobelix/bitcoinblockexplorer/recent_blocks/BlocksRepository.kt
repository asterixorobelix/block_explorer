package com.github.asterixorobelix.bitcoinblockexplorer.recent_blocks

import com.github.asterixorobelix.bitcoinblockexplorer.network.MempoolClient

class BlocksRepository(private val mempoolClient: MempoolClient) {

    suspend fun getRecentBlocks()=mempoolClient.getBlocks()
}