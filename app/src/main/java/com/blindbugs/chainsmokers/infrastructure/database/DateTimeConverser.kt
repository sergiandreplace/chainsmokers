package com.blindbugs.chainsmokers.infrastructure.database

import android.arch.persistence.room.TypeConverter
import org.threeten.bp.Instant
import org.threeten.bp.LocalDateTime
import org.threeten.bp.ZoneId
import org.threeten.bp.ZoneOffset
import org.threeten.bp.format.DateTimeFormatter
import java.util.*

class DateTimeConverser {
  val df : DateTimeFormatter = DateTimeFormatter.ISO_LOCAL_DATE_TIME

  @TypeConverter
  fun toTimestamp(dateTime: LocalDateTime) : String {
    return dateTime.format(df)
  }

  @TypeConverter
  fun toDateTime(timestamp:String) : LocalDateTime {
    return LocalDateTime.parse(timestamp, df);

  }
}