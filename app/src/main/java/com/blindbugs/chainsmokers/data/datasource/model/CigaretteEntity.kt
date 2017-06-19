package com.blindbugs.chainsmokers.data.datasource.model

import android.arch.persistence.room.ColumnInfo
import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey

@Entity(tableName = "cigarettes")
class CigaretteEntity(@ColumnInfo(name = "datetime") var entry: Long) {
  @ColumnInfo(name = "id")
  @PrimaryKey(autoGenerate = true) var id: Long = 0
}