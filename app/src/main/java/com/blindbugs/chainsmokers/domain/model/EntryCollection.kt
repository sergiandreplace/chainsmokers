package com.blindbugs.chainsmokers.domain.model

interface EntryCollection {
  fun execute(entry: Entry): Entry
  fun getEntries(): List<Entry>
}

