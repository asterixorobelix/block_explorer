package com.github.asterixorobelix.bitcoinblockexplorer.network

import io.ktor.client.HttpClient
import io.ktor.client.request.get
import io.ktor.client.statement.bodyAsText

class MempoolClient(private val httpClient: HttpClient) {

    /**
     * Returns details on the past 15 blocks with fee and mining details in an extras field
     */
    suspend fun getBlocks(): String {
        val response = httpClient.get("${MEMPOOL_BASE_URL}blocks")
        return response.bodyAsText()
    }

    companion object {
        const val MEMPOOL_BASE_URL = "https://mempool.space/api/v1/"
    }
}