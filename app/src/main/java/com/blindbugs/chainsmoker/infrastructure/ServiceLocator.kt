package com.blindbugs.chainsmoker.infrastructure

import com.blindbugs.chainsmoker.data.datasource.EntryMemoryDataSource
import com.blindbugs.chainsmoker.data.repository.EntryRepository
import com.blindbugs.chainsmoker.domain.model.EntryCollection
import com.blindbugs.chainsmoker.domain.usecase.di.CreateEntryUseCase
import com.blindbugs.chainsmoker.ui.main.MainPresenter

class ServiceLocator private constructor() {
    init {
    }

    private object Holder {
        val INSTANCE = ServiceLocator()
    }

    companion object {
        val instance: ServiceLocator by lazy { Holder.INSTANCE }
    }

    fun getMainPresenter(view: MainPresenter.MainPresenterView): MainPresenter {
        return MainPresenter(view, getCreateEntryUseCase())
    }

    private fun getCreateEntryUseCase(): CreateEntryUseCase {
        return CreateEntryUseCase(getEntryCollection())
    }

    private fun getEntryCollection(): EntryCollection {
        return EntryRepository(getEntryMemoryDataSource())
    }

    private fun getEntryMemoryDataSource(): EntryMemoryDataSource {
        return EntryMemoryDataSource()
    }
}

