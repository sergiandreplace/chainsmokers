package com.blindbugs.chainsmokers.infrastructure.di

import android.content.Context
import com.blindbugs.chainsmokers.ChainSmokersApplication
import com.blindbugs.chainsmokers.data.datasource.EntryMemoryDataSource
import com.blindbugs.chainsmokers.data.repository.EntryRepository
import com.blindbugs.chainsmokers.domain.model.EntryCollection
import com.blindbugs.chainsmokers.domain.usecase.CreateEntryUseCase
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module class AppModule(val app: ChainSmokersApplication) {
    @Provides @Singleton fun provideApp() = app

    @Provides
    fun provideCreateEntryUseCase(entryCollection: EntryCollection)
            = CreateEntryUseCase(entryCollection)

    @Provides
    fun provideEntryCollection(entryMemoryDataSource: EntryMemoryDataSource): EntryCollection
            = EntryRepository(entryMemoryDataSource)

    @Provides
    fun provideEntryMemoryDataSource() = EntryMemoryDataSource();
}