package com.github.asterixorobelix.bitcoinblockexplorer.recent_blocks

import kotlinx.serialization.Serializable

@Serializable
data class Pool(
    val id: Int? = null,
    val name: String? = null,
    val slug: String? = null,
    val minerNames: List<String>? = null
)
