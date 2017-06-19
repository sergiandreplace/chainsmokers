package com.blindbugs.chainsmokers.ui.main

import com.blindbugs.chainsmokers.domain.model.Cigarette
import com.blindbugs.chainsmokers.domain.usecase.RegisterCigaretteUseCase
import com.blindbugs.chainsmokers.domain.usecase.GetDailyCigarettesUseCase
import org.jetbrains.anko.doAsync
import org.jetbrains.anko.uiThread
import org.threeten.bp.LocalDate
import org.threeten.bp.LocalDateTime
import javax.inject.Inject

class MainPresenter @Inject constructor(val registerCigaretteUseCase: RegisterCigaretteUseCase, val getDailyCigarettesUseCase: GetDailyCigarettesUseCase) {
  var view: MainPresenterView? = null

  fun createEntry() {
    doAsync {
      val entry = registerCigaretteUseCase.execute(LocalDateTime.now())
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
      val entriesByDay = getDailyCigarettesUseCase.execute()
      uiThread {
        view?.onEntriesByDayUpdated(entriesByDay)
      }
    }
  }


  interface MainPresenterView {
    fun onEntryCreated(cigarette: Cigarette)
    fun onEntriesByDayUpdated(days: Map<LocalDate, Long>)
  }

}

