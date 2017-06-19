package com.blindbugs.chainsmokers.domain.usecase

import com.blindbugs.chainsmokers.domain.model.Cigarette
import com.blindbugs.chainsmokers.domain.model.CigaretteCollection
import org.threeten.bp.LocalDateTime
import javax.inject.Inject

class RegisterCigaretteUseCase @Inject constructor(val cigaretteCollection: CigaretteCollection) {

  fun execute(time: LocalDateTime): Cigarette {
    return cigaretteCollection.save(Cigarette(time))
  }
}

