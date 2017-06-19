package com.blindbugs.chainsmokers.infrastructure.di.data

import com.blindbugs.chainsmokers.data.datasource.EntryDao
import com.blindbugs.chainsmokers.data.datasource.mapper.EntryMapper
import com.blindbugs.chainsmokers.data.repository.EntryRepository
import com.blindbugs.chainsmokers.domain.model.EntryCollection
import com.blindbugs.chainsmokers.infrastructure.database.AppDatabase
import dagger.Module
import dagger.Provides

@Module
class DataModule {
  @Provides
  fun entryCollection(entryDao: EntryDao, entryMapper: EntryMapper): EntryCollection
    = EntryRepository(entryDao, entryMapper)

  @Provides
  fun entryDao(appDatabase: AppDatabase) = appDatabase.entryDao()

}