package com.blindbugs.chainsmokers.data.repository

import com.blindbugs.chainsmokers.data.datasource.CigaretteDao
import com.blindbugs.chainsmokers.data.datasource.mapper.CigaretteMapper
import com.blindbugs.chainsmokers.domain.model.Cigarette
import com.blindbugs.chainsmokers.domain.model.CigaretteCollection
import org.threeten.bp.LocalDate
import javax.inject.Inject

class CigaretteRepository @Inject constructor(val cigaretteDao: CigaretteDao, val cigaretteMapper: CigaretteMapper) :
  CigaretteCollection {

  override fun save(cigarette: Cigarette): Cigarette {
    cigaretteDao.insert(cigaretteMapper.toEntity(cigarette))
    return cigarette
  }

  override fun getAll(): List<Cigarette> {
    return cigaretteDao.getAll()
      .map { cigaretteMapper.toModel(it) }
      .toList()
  }

  override fun getDailyCigarettes(): Map<LocalDate, Long> {
    return cigaretteDao.getDailyCigarettes().map { Pair(it.day, it.cigarettes) }
      .toMap()
  }

}