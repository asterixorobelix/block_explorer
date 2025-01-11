package com.github.asterixorobelix.bitcoinblockexplorer.db

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "blocks")
data class BlockEntity(
    @PrimaryKey val id: String,
    val blockHeight: Int?,
    val transactions: Int?,
    val difficulty: Double?,
    val averageFee: Int?,
    val reward: Int?
)
