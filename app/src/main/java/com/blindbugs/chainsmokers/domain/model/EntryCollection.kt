package com.blindbugs.chainsmokers.domain.model

interface EntryCollection {
  fun saveEntry(entry: Entry): Entry
}
