package com.github.asterixorobelix.bitcoinblockexplorer.db

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query

@Dao
interface BlockDao {
    @Query("SELECT * FROM blocks")
    suspend fun getAll(): List<BlockEntity>

    @Query("SELECT * FROM blocks WHERE id IN (:blockIds)")
    suspend fun loadAllByIds(blockIds: IntArray): List<BlockEntity>

    @Insert
    suspend fun insertAll( blocks: List<BlockEntity>)

    @Delete
    suspend fun delete(block: BlockEntity)
}