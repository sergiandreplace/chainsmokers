package com.blindbugs.chainsmokers.domain.usecase

import com.blindbugs.chainsmokers.domain.model.CigaretteCollection
import javax.inject.Inject

class GetAllCigarettesUseCase @Inject constructor(val cigaretteCollection: CigaretteCollection) {
  fun execute() = cigaretteCollection.getAll()
}