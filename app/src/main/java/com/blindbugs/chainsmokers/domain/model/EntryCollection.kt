package com.blindbugs.chainsmokers.domain.model

import org.threeten.bp.LocalDate

interface EntryCollection {
  fun execute(entry: Entry): Entry
  fun getEntriesByDay(): Map<LocalDate, Day>
}

