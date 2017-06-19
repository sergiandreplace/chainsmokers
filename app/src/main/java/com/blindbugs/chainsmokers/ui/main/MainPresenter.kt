package com.blindbugs.chainsmokers.ui.main

import com.blindbugs.chainsmokers.domain.model.Cigarette
import com.blindbugs.chainsmokers.domain.usecase.RegisterCigaretteUseCase
import com.blindbugs.chainsmokers.domain.usecase.GetAllCigarettesUseCase
import org.jetbrains.anko.doAsync
import org.jetbrains.anko.uiThread
import javax.inject.Inject

class MainPresenter @Inject constructor(val registerCigaretteUseCase: RegisterCigaretteUseCase, val getAllCigarettesUseCase: GetAllCigarettesUseCase) {
  var view: MainPresenterView? = null

  fun createEntry() {
    val now = System.currentTimeMillis()
    doAsync {
      val entry = registerCigaretteUseCase.execute(now)
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
      val entriesByDay = getAllCigarettesUseCase.execute()
      uiThread {
        view?.onEntriesByDayUpdated(entriesByDay)
      }
    }
  }


  interface MainPresenterView {
    fun onEntryCreated(cigarette: Cigarette)
    fun onEntriesByDayUpdated(days: List<Cigarette>)
  }

}

