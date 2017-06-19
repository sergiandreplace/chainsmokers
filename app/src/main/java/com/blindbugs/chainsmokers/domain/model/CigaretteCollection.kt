package com.blindbugs.chainsmokers.domain.model

interface CigaretteCollection {
  fun save(cigarette: Cigarette): Cigarette
  fun getAll(): List<Cigarette>
}

