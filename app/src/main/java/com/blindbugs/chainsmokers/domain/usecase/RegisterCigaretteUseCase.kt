package com.blindbugs.chainsmokers.domain.usecase

import com.blindbugs.chainsmokers.domain.model.Cigarette
import com.blindbugs.chainsmokers.domain.model.CigaretteCollection
import javax.inject.Inject

class RegisterCigaretteUseCase @Inject constructor(val cigaretteCollection: CigaretteCollection) {

  fun execute(time: Long): Cigarette {
    return cigaretteCollection.save(Cigarette(time))
  }
}

