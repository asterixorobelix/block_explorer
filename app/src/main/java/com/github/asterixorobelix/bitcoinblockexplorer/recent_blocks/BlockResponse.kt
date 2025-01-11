package com.github.asterixorobelix.bitcoinblockexplorer.recent_blocks

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class BlockResponse(
    val id: String? = null,
    val height: Int? = null,
    val version: Int? = null,
    val timestamp: Int? = null,
    val bits: Int? = null,
    val nonce: Int? = null,
    val difficulty: Double? = null,
    @SerialName("merkle_root")
    val merkleRoot: String? = null,
    @SerialName("tx_count")
    val transactionCount: Int? = null,
    val size: Int? = null,
    val weight: Int? = null,
    @SerialName("previousblockhash")
    val previousBlockHash: String? = null,
    @SerialName("mediantime")
    val medianTime: Int? = null,
    val extras: Extras? = Extras()
)
