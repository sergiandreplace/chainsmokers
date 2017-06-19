package com.blindbugs.chainsmokers.infrastructure.database

import android.arch.persistence.room.TypeConverter
import org.threeten.bp.*
import org.threeten.bp.format.DateTimeFormatter
import java.util.*

class DateConverser {
  val df : DateTimeFormatter = DateTimeFormatter.ISO_DATE


  @TypeConverter
  fun toDate(date : String) : LocalDate {
    return LocalDate.parse(date, df)

  }
}