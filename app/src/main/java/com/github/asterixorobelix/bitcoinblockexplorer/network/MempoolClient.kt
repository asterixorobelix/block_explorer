package com.github.asterixorobelix.bitcoinblockexplorer.network

import com.github.asterixorobelix.bitcoinblockexplorer.recent_blocks.BlockResponse
import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.request.get
import io.ktor.client.statement.bodyAsText

class MempoolClient(private val httpClient: HttpClient) {

    /**
     * Returns details on the past 15 blocks with fee and mining details in an extras field
     */
    suspend fun getBlocks(): BlockResponse {
        val response = httpClient.get("${MEMPOOL_BASE_URL}blocks").body<List<BlockResponse>>()
        return response.first()
    }

    companion object {
        const val MEMPOOL_BASE_URL = "https://mempool.space/api/v1/"
    }
}