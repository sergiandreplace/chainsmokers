package com.blindbugs.chainsmokers.data.datasource.mapper

import com.blindbugs.chainsmokers.data.datasource.model.CigaretteEntity
import com.blindbugs.chainsmokers.domain.model.Cigarette
import javax.inject.Inject

class CigaretteMapper @Inject constructor() {
  fun toEntity(cigarette: Cigarette): CigaretteEntity {
    val cigaretteEntity = CigaretteEntity(cigarette.timestamp)
    cigaretteEntity.entry = cigarette.timestamp
    return cigaretteEntity
  }

  fun toModel(cigaretteEntity: CigaretteEntity): Cigarette {
    return Cigarette(cigaretteEntity.entry)
  }
}