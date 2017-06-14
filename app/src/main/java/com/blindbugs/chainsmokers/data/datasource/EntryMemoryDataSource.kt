package com.blindbugs.chainsmokers.data.datasource

import com.blindbugs.chainsmokers.domain.model.Entry
import javax.inject.Inject

class EntryMemoryDataSource @Inject constructor() {

  val entries: MutableList<Entry> = ArrayList()

  fun save(entry: Entry) {
    entries.add(entry)
  }

}