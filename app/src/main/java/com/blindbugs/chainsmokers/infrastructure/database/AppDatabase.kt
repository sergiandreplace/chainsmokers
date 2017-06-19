package com.blindbugs.chainsmokers.infrastructure.database

import android.arch.persistence.room.Database
import android.arch.persistence.room.RoomDatabase
import android.arch.persistence.room.TypeConverters
import com.blindbugs.chainsmokers.data.datasource.CigaretteDao
import com.blindbugs.chainsmokers.data.datasource.model.CigaretteEntity

@Database(entities = arrayOf(CigaretteEntity::class), version = 1, exportSchema = false)
@TypeConverters(*arrayOf(DateTimeConverser::class, DateConverser::class))
abstract class AppDatabase : RoomDatabase() {
  abstract fun cigaretteDao(): CigaretteDao
}