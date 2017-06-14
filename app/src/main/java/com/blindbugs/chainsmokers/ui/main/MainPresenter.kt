package com.blindbugs.chainsmokers.ui.main

import com.blindbugs.chainsmokers.domain.model.Day
import com.blindbugs.chainsmokers.domain.model.Entry
import com.blindbugs.chainsmokers.domain.usecase.CreateEntryUseCase
import com.blindbugs.chainsmokers.domain.usecase.GetEntriesByDayUseCase
import org.jetbrains.anko.doAsync
import org.jetbrains.anko.uiThread
import org.threeten.bp.LocalDate
import javax.inject.Inject

class MainPresenter @Inject constructor(val createEntryUseCase: CreateEntryUseCase, val getEntriesByDayUseCase: GetEntriesByDayUseCase) {
  var view: MainPresenterView? = null

  fun createEntry() {
    val now = System.currentTimeMillis()
    val entry = createEntryUseCase.execute(now)
    view?.onEntryCreated(entry)
    updateEntries()
  }

  fun init() {
    updateEntries()
  }

  private fun updateEntries() {
    doAsync {
      val entriesByDay = getEntriesByDayUseCase.execute()
      uiThread {
        view?.onEntriesByDayUpdated(entriesByDay)
      }
    }
  }


  interface MainPresenterView {
    fun onEntryCreated(entry: Entry)
    fun onEntriesByDayUpdated(days: Map<LocalDate, Day>)
  }

}

