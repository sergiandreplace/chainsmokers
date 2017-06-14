package com.blindbugs.chainsmokers.infrastructure.di.data

import com.blindbugs.chainsmokers.data.datasource.EntryMemoryDataSource
import com.blindbugs.chainsmokers.data.repository.EntryRepository
import com.blindbugs.chainsmokers.domain.model.EntryCollection
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class DataModule {
  @Provides
  fun entryCollection(entryMemoryDataSource: EntryMemoryDataSource): EntryCollection = EntryRepository(entryMemoryDataSource)

  @Provides
  @Singleton
  fun entryMemoryDataSource() = EntryMemoryDataSource()
}