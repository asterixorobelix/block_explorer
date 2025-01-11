package com.github.asterixorobelix.bitcoinblockexplorer.recent_blocks

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

class RecentBlocksViewModel(private val blocksRepository: BlocksRepository) : ViewModel() {
    private val _state = MutableStateFlow(RecentBlocksState())
    val state: StateFlow<RecentBlocksState> = _state

    suspend fun getRecentBlocks() {
        _state.emit(RecentBlocksState(loading = true))
        val blocks = blocksRepository.getRecentBlocks()
        _state.emit(RecentBlocksState(blocks, false))
    }

}