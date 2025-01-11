package com.github.asterixorobelix.bitcoinblockexplorer.recent_blocks

/**
 * Object which represents the state of the UI
 * @param recentBlocks list of [RecentBlock]s
 * @param loading whether or not progress indication should be given to the user
 */
data class RecentBlocksState(
    val recentBlocks: List<RecentBlock>? = null,
    val loading: Boolean = false
)
