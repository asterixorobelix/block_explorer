package com.github.asterixorobelix.bitcoinblockexplorer.recent_blocks

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Extras(
    val totalFees: Int? = null,
    val medianFee: Int? = null,
    val feeRange: ArrayList<Double> = arrayListOf(),
    val reward: Int? = null,
    val pool: Pool? = Pool(),
    @SerialName("avgFee")
    val averageFee: Int? = null,
    @SerialName("avgFeeRate")
    val averageFeeRate: Int? = null,
    val coinbaseRaw: String? = null,
    val coinbaseAddress: String? = null,
    val coinbaseAddresses: ArrayList<String> = arrayListOf(),
    val coinbaseSignature: String? = null,
    val coinbaseSignatureAscii: String? = null,
    @SerialName("avgTxSize")
    val averageTransactionSize: Int? = null,
    val totalInputs: Int? = null,
    val totalOutputs: Int? = null,
    @SerialName("totalOutputAmt")
    val totalOutputAmount: Int? = null,
    @SerialName("medianFeeAmt")
    val medianFeeAmount: Int? = null,
    val feePercentiles: ArrayList<Int> = arrayListOf(),
    @SerialName("segwitTotalTxs")
    val segwitTotalTransactions: Int? = null,
    val segwitTotalSize: Int? = null,
    val segwitTotalWeight: Int? = null,
    val header: String? = null,
    val utxoSetChange: Int? = null,
    val utxoSetSize: Int? = null,
    @SerialName("totalInputAmt")
    val totalInputAmount: Int? = null,
    val virtualSize: Double? = null,
    val firstSeen: String? = null,
    val orphans: ArrayList<String> = arrayListOf(),
    val matchRate: String? = null,
    val expectedFees: String? = null,
    val expectedWeight: String? = null
)
