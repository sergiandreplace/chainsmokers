package com.blindbugs.chainsmokers.domain.usecase

import com.blindbugs.chainsmokers.domain.model.EntryCollection
import javax.inject.Inject

class GetEntries @Inject constructor(val entryCollection: EntryCollection) {
  fun execute() = entryCollection.getEntries()
}