package com.blindbugs.chainsmokers.data.datasource

import android.arch.persistence.room.Dao
import android.arch.persistence.room.Insert
import android.arch.persistence.room.OnConflictStrategy.REPLACE
import android.arch.persistence.room.Query
import com.blindbugs.chainsmokers.data.datasource.model.EntryEntity

@Dao
interface EntryDao {

  @Insert(onConflict = REPLACE)
  fun insert(entryEntity: EntryEntity)

  @Query("Select id, datetime from entries")
  fun getEntries(): List<EntryEntity>
}