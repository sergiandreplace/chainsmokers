package com.blindbugs.chainsmokers.data.repository

import com.blindbugs.chainsmokers.data.datasource.EntryMemoryDataSource
import com.blindbugs.chainsmokers.domain.model.Entry
import com.blindbugs.chainsmokers.domain.model.EntryCollection
import javax.inject.Inject

class EntryRepository @Inject constructor(val entryMemoryDataSource: EntryMemoryDataSource) : EntryCollection {
  override fun execute(entry: Entry): Entry {
    entryMemoryDataSource.save(entry)
    return entry
  }

  override fun getEntriesByDay() = entryMemoryDataSource.getEntriesByDay()

}