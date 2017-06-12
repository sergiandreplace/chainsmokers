package com.blindbugs.chainsmokers.ui.main

import com.blindbugs.chainsmokers.domain.usecase.CreateEntryUseCase

class MainPresenter(val view: MainPresenterView,
                    val createEntryUseCase: CreateEntryUseCase) {

    fun createEntry() {
        val now = System.currentTimeMillis();
        createEntryUseCase.execute(now)
        view.onEntryCreated()
    }

    interface MainPresenterView {
        fun onEntryCreated()
    }

}

