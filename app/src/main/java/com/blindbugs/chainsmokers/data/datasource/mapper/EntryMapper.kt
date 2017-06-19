package com.blindbugs.chainsmokers.data.datasource.mapper

import com.blindbugs.chainsmokers.data.datasource.model.EntryEntity
import com.blindbugs.chainsmokers.domain.model.Entry
import javax.inject.Inject

class EntryMapper @Inject constructor() {
  fun toEntity(entry: Entry): EntryEntity {
    val entryEntity = EntryEntity(entry.timestamp)
    entryEntity.entry = entry.timestamp
    return entryEntity
  }

  fun toModel(entity: EntryEntity): Entry {
    return Entry(entity.entry)
  }
}