package com.blindbugs.chainsmokers.ui.main

import com.blindbugs.chainsmokers.domain.model.Entry
import com.blindbugs.chainsmokers.domain.usecase.CreateEntryUseCase
import javax.inject.Inject

class MainPresenter @Inject constructor(val createEntryUseCase: CreateEntryUseCase) {
  var view: MainPresenterView? = null

  fun createEntry() {
    val now = System.currentTimeMillis()
    val entry = createEntryUseCase.execute(now)
    view?.onEntryCreated(entry)
  }

  interface MainPresenterView {
    fun onEntryCreated(entry: Entry)
  }

}

