package com.blindbugs.chainsmokers.data.datasource.model

import android.arch.persistence.room.ColumnInfo
import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey
import org.threeten.bp.LocalDate
import org.threeten.bp.LocalDateTime

@Entity(tableName = "cigarettes")
class DailyCigarettesEntity(
  @ColumnInfo(name = "day") var day: LocalDate,
  @ColumnInfo(name = "count") var cigarettes: Long
)