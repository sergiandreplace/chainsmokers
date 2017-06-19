package com.blindbugs.chainsmokers.ui.main

import com.blindbugs.chainsmokers.domain.model.Entry
import com.blindbugs.chainsmokers.domain.usecase.CreateEntryUseCase
import com.blindbugs.chainsmokers.domain.usecase.GetEntries
import org.jetbrains.anko.doAsync
import org.jetbrains.anko.uiThread
import javax.inject.Inject

class MainPresenter @Inject constructor(val createEntryUseCase: CreateEntryUseCase, val getEntries: GetEntries) {
  var view: MainPresenterView? = null

  fun createEntry() {
    val now = System.currentTimeMillis()
    doAsync {
      val entry = createEntryUseCase.execute(now)
      uiThread {
        view?.onEntryCreated(entry)

        updateEntries()
      }
    }
  }

  fun init() {
    updateEntries()
  }

  private fun updateEntries() {
    doAsync {
      val entriesByDay = getEntries.execute()
      uiThread {
        view?.onEntriesByDayUpdated(entriesByDay)
      }
    }
  }


  interface MainPresenterView {
    fun onEntryCreated(entry: Entry)
    fun onEntriesByDayUpdated(days: List<Entry>)
  }

}

