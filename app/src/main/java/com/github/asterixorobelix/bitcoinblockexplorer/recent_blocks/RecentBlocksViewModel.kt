package com.github.asterixorobelix.bitcoinblockexplorer.recent_blocks

import androidx.compose.runtime.State
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

class RecentBlocksViewModel(private val blocksRepository: BlocksRepository) : ViewModel() {
    private val _state = MutableStateFlow(listOf<RecentBlock>())
    val state: StateFlow<List<RecentBlock>> = _state

    suspend fun getRecentBlocks() {
        val blocks = blocksRepository.getRecentBlocks()
        _state.emit(blocks)
    }

}