package com.blindbugs.chainsmokers.domain.usecase

import com.blindbugs.chainsmokers.domain.model.Entry
import com.blindbugs.chainsmokers.domain.model.EntryCollection
import javax.inject.Inject

class CreateEntryUseCase @Inject constructor(val entryCollection: EntryCollection) {

  fun execute(time: Long): Entry {
    return entryCollection.saveEntry(Entry(time))
  }
}

