package com.github.asterixorobelix.bitcoinblockexplorer.recent_blocks

data class RecentBlocksState(val recentBlocks: List<RecentBlock>? = null, val loading: Boolean = false)
