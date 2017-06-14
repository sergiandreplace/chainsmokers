package com.blindbugs.chainsmokers.data.datasource

import com.blindbugs.chainsmokers.domain.model.Day
import com.blindbugs.chainsmokers.domain.model.Entry
import org.threeten.bp.LocalDate
import org.threeten.bp.LocalDateTime
import org.threeten.bp.ZoneOffset
import javax.inject.Inject

class EntryMemoryDataSource @Inject constructor() {

  val entries: MutableList<Entry> = ArrayList()

  fun save(entry: Entry) {
    entries.add(entry)
  }

  fun getEntriesByDay(): Map<LocalDate, Day> {
    return entries.map(Entry::timestamp)
      .groupBy { k -> LocalDateTime.ofEpochSecond(k, 0, ZoneOffset.UTC).toLocalDate() }
      .map { Pair(it.key, Day(it.value.size)) }
      .toMap();
  }
}