package com.github.asterixorobelix.bitcoinblockexplorer.recent_blocks

import androidx.lifecycle.ViewModel
import com.github.asterixorobelix.bitcoinblockexplorer.db.BlockEntity
import com.github.asterixorobelix.bitcoinblockexplorer.db.BlockExplorerDatabase
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

class RecentBlocksViewModel(
    private val blocksRepository: BlocksRepository,
    private val blockExplorerDatabase: BlockExplorerDatabase
) : ViewModel() {
    private val _state = MutableStateFlow(RecentBlocksState())
    val state: StateFlow<RecentBlocksState> = _state

    /**
     * Caches api response and returns recent blocks
     */
    suspend fun getRecentBlocks() {
        _state.emit(RecentBlocksState(loading = true))
        val dbBlocks = blockExplorerDatabase.blockDao().getAll()
        if (dbBlocks.isNotEmpty()) {
            _state.emit(RecentBlocksState(dbBlocks.map {
                RecentBlock(
                    id = it.id,
                    blockHeight = it.blockHeight,
                    transactions = it.transactions,
                    difficulty = it.difficulty,
                    averageFee = it.averageFee,
                    reward = it.reward
                )
            }, loading = false))
        }
        val apiBlocks = blocksRepository.getRecentBlocks()
        if (apiBlocks.firstOrNull()?.id != dbBlocks.firstOrNull()?.id) {
            _state.emit(RecentBlocksState(null, loading = true))
            blockExplorerDatabase.blockDao().insertAll(apiBlocks.map {
                BlockEntity(
                    id = it.id,
                    blockHeight = it.blockHeight,
                    transactions = it.transactions,
                    difficulty = it.difficulty,
                    averageFee = it.averageFee,
                    reward = it.reward

                ) }
            )
            _state.emit(RecentBlocksState(apiBlocks, false))
        }
    }
}