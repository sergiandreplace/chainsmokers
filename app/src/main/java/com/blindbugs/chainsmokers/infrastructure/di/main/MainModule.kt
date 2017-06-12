package com.blindbugs.chainsmokers.infrastructure.di.main

import com.blindbugs.chainsmokers.data.datasource.EntryMemoryDataSource
import com.blindbugs.chainsmokers.data.repository.EntryRepository
import com.blindbugs.chainsmokers.domain.model.EntryCollection
import com.blindbugs.chainsmokers.domain.usecase.CreateEntryUseCase
import com.blindbugs.chainsmokers.ui.main.MainActivity
import com.blindbugs.chainsmokers.ui.main.MainPresenter
import dagger.Module
import dagger.Provides

@Module
class MainModule(val activity: MainActivity) {

    @Provides
    fun provideContext() = activity

    @Provides
    fun provideMainPresenter(createEntryUseCase: CreateEntryUseCase)
            = MainPresenter(createEntryUseCase)


}