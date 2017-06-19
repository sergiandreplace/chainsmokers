package com.blindbugs.chainsmokers.infrastructure.database

import android.arch.persistence.room.Database
import android.arch.persistence.room.RoomDatabase
import com.blindbugs.chainsmokers.data.datasource.EntryDao
import com.blindbugs.chainsmokers.data.datasource.model.EntryEntity

@Database(entities = arrayOf(EntryEntity::class), version = 1, exportSchema = false)
abstract class AppDatabase : RoomDatabase() {
  abstract fun entryDao(): EntryDao
}