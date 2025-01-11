package com.github.asterixorobelix.bitcoinblockexplorer.network

import com.github.asterixorobelix.bitcoinblockexplorer.recent_blocks.BlockResponse
import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.request.get
import io.ktor.client.statement.bodyAsText

/**
 * Retrieve info from the network from mempool
 */
class MempoolClient(private val httpClient: HttpClient) {

    /**
     * Returns details on the last 15 blocks with fee and mining details in an extras field
     * @return list of [BlockResponse]
     */
    suspend fun getBlocks(): List<BlockResponse> {
        val response = httpClient.get("${MEMPOOL_BASE_URL}blocks").body<List<BlockResponse>>()
        return response
    }

    companion object {
        const val MEMPOOL_BASE_URL = "https://mempool.space/api/v1/"
    }
}