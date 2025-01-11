package com.github.asterixorobelix.bitcoinblockexplorer.recent_blocks

import androidx.lifecycle.ViewModel
import com.github.asterixorobelix.bitcoinblockexplorer.db.BlockExplorerDatabase
import com.github.asterixorobelix.bitcoinblockexplorer.utilities.toBlockEntity
import com.github.asterixorobelix.bitcoinblockexplorer.utilities.toRecentBLock
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
            _state.emit(
                RecentBlocksState(
                    dbBlocks.toRecentBLock(), loading = false
                )
            )
        }
        val apiBlocks = blocksRepository.getRecentBlocks()
        if (apiBlocks.firstOrNull()?.id != dbBlocks.firstOrNull()?.id) {
            _state.emit(RecentBlocksState(null, loading = true))
            blockExplorerDatabase.blockDao().insertAll(
                apiBlocks.toBlockEntity()
            )
            _state.emit(RecentBlocksState(apiBlocks, loading = false))
        }
    }
}