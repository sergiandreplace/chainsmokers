package com.blindbugs.chainsmokers.domain.model

import org.threeten.bp.LocalDate

interface CigaretteCollection {
  fun save(cigarette: Cigarette): Cigarette
  fun getAll(): List<Cigarette>
  fun getDailyCigarettes(): Map<LocalDate, Long>
}

