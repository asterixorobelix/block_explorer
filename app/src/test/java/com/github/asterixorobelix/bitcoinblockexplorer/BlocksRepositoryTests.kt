package com.github.asterixorobelix.bitcoinblockexplorer

import com.github.asterixorobelix.bitcoinblockexplorer.network.MempoolClient
import com.github.asterixorobelix.bitcoinblockexplorer.recent_blocks.BlockResponse
import com.github.asterixorobelix.bitcoinblockexplorer.recent_blocks.BlocksRepository
import com.github.asterixorobelix.bitcoinblockexplorer.recent_blocks.Extras
import com.github.asterixorobelix.bitcoinblockexplorer.recent_blocks.RecentBlock
import com.google.common.truth.Truth
import junit.framework.TestCase.assertEquals
import kotlinx.coroutines.test.runTest
import org.junit.Before
import org.junit.Test
import org.mockito.Mockito

class BlocksRepositoryTests {
    private lateinit var mempoolClient: MempoolClient
    private lateinit var blocksRepository: BlocksRepository

    @Before
    fun setup() {
        mempoolClient = Mockito.mock(MempoolClient::class.java)
        blocksRepository = BlocksRepository(mempoolClient)
    }

    @Test
    fun `confirm mempool client mapping works`() {
        runTest {
            val mempoolClientTestResponse = listOf(
                BlockResponse(
                    id = "1234",
                    height = 8786,
                    transactionCount = 3400,
                    difficulty = 1.0978,
                    extras = Extras(averageFee = 1804, reward = 318632736)
                )
            )
            Mockito.`when`(mempoolClient.getBlocks()).thenReturn(mempoolClientTestResponse)
            val expectedResponse = listOf(RecentBlock(id = "1234",
                blockHeight = 8786,
                transactions = 3400,
                difficulty = 1.0978,
                averageFee = 1804,
                reward = 318632736))
            Truth.assertThat(blocksRepository.getRecentBlocks()).isEqualTo(expectedResponse)
        }
    }
}