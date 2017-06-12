package com.blindbugs.chainsmokers.data.repository

import com.blindbugs.chainsmokers.data.datasource.EntryMemoryDataSource
import com.blindbugs.chainsmokers.domain.model.EntryCollection

class EntryRepository (val entryMemoryDataSource: EntryMemoryDataSource) :EntryCollection {
    override fun saveEntry(time: Long) {
    }
}