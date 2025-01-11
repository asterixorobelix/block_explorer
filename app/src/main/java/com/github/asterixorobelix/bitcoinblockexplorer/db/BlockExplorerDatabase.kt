package com.github.asterixorobelix.bitcoinblockexplorer.db

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = [BlockEntity::class], version = 1)
abstract class BlockExplorerDatabase : RoomDatabase() {
    abstract fun blockDao(): BlockDao
}