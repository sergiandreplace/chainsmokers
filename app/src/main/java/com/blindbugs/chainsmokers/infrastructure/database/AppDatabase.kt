package com.blindbugs.chainsmokers.infrastructure.database

import android.arch.persistence.room.Database
import android.arch.persistence.room.RoomDatabase
import com.blindbugs.chainsmokers.data.datasource.CigaretteDao
import com.blindbugs.chainsmokers.data.datasource.model.CigaretteEntity

@Database(entities = arrayOf(CigaretteEntity::class), version = 1, exportSchema = false)
abstract class AppDatabase : RoomDatabase() {
  abstract fun cigaretteDao(): CigaretteDao
}