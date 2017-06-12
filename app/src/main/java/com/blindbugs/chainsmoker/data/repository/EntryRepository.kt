package com.blindbugs.chainsmoker.data.repository

import com.blindbugs.chainsmoker.data.datasource.EntryMemoryDataSource
import com.blindbugs.chainsmoker.domain.model.EntryCollection

class EntryRepository (val entryMemoryDataSource: EntryMemoryDataSource) :EntryCollection {
    override fun saveEntry(time: Long) {
    }
}