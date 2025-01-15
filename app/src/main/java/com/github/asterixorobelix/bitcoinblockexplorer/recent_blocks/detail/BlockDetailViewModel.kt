package com.github.asterixorobelix.bitcoinblockexplorer.recent_blocks.detail

import androidx.lifecycle.ViewModel
import com.github.asterixorobelix.bitcoinblockexplorer.recent_blocks.BlocksRepository

class BlockDetailViewModel(private val blocksRepository: BlocksRepository):ViewModel() {

    suspend fun getBlockInfo(blockID:String){
        val block = blocksRepository.getBlockById(blockID)
        block.blockHeight
    }
}