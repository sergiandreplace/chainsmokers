package com.blindbugs.chainsmokers.data.repository

import com.blindbugs.chainsmokers.data.datasource.EntryDao
import com.blindbugs.chainsmokers.data.datasource.mapper.EntryMapper
import com.blindbugs.chainsmokers.domain.model.Entry
import com.blindbugs.chainsmokers.domain.model.EntryCollection
import javax.inject.Inject

class EntryRepository @Inject constructor(val entryDao: EntryDao, val entryMapper: EntryMapper) :
  EntryCollection {
  override fun execute(entry: Entry): Entry {
    entryDao.insert(entryMapper.toEntity(entry))
    return entry
  }

  override fun getEntries(): List<Entry> {
    return entryDao.getEntries()
      .map { entryMapper.toModel(it) }
      .toList()
  }

}