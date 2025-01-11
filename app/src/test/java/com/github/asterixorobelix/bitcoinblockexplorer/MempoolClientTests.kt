package com.github.asterixorobelix.bitcoinblockexplorer

import com.github.asterixorobelix.bitcoinblockexplorer.network.MempoolClient
import com.github.asterixorobelix.bitcoinblockexplorer.recent_blocks.BlocksRepository
import com.google.common.truth.Truth
import io.ktor.client.HttpClient
import org.junit.Before
import org.junit.Test
import org.mockito.Mockito

class MempoolClientTests {
    private lateinit var mempoolClient: MempoolClient
    private lateinit var httpClient: HttpClient

    @Before
    fun setup() {
        httpClient = Mockito.mock(HttpClient::class.java)
        mempoolClient = MempoolClient(httpClient)
    }

    @Test
    fun `confirm base url correct`(){
        Truth.assertThat(MempoolClient.MEMPOOL_BASE_URL).isEqualTo("https://mempool.space/api/v1/")
    }
}