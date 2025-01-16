package com.github.asterixorobelix.bitcoinblockexplorer.recent_blocks.detail

import androidx.lifecycle.ViewModel
import com.github.asterixorobelix.bitcoinblockexplorer.recent_blocks.BlocksRepository
import com.github.asterixorobelix.bitcoinblockexplorer.recent_blocks.RecentBlocksState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

class BlockDetailViewModel(private val blocksRepository: BlocksRepository) : ViewModel() {

    private val _state = MutableStateFlow(BlockDetailState())
    val state: StateFlow<BlockDetailState> = _state

    suspend fun getBlockInfo(blockID: String) {
        _state.emit(BlockDetailState(isLoading = true))
        val block = blocksRepository.getBlockById(blockID)
        block.height
        _state.emit(BlockDetailState(isLoading = false, blockDetail = block))
    }
}