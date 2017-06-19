package com.blindbugs.chainsmokers.infrastructure.di.data

import android.arch.persistence.room.Room
import com.blindbugs.chainsmokers.ChainSmokersApplication
import com.blindbugs.chainsmokers.data.datasource.CigaretteDao
import com.blindbugs.chainsmokers.data.datasource.mapper.CigaretteMapper
import com.blindbugs.chainsmokers.data.repository.CigaretteRepository
import com.blindbugs.chainsmokers.domain.model.CigaretteCollection
import com.blindbugs.chainsmokers.infrastructure.database.AppDatabase
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class DataModule {
  @Provides @Singleton
  fun database(app: ChainSmokersApplication): AppDatabase
    = Room.databaseBuilder(app, AppDatabase::class.java, "chainsmokers").build()


  @Provides
  fun cigaretteCollection(entryDao: CigaretteDao, cigaretteMapper: CigaretteMapper): CigaretteCollection
    = CigaretteRepository(entryDao, cigaretteMapper)

  @Provides
  fun cigaretteDao(appDatabase: AppDatabase) = appDatabase.cigaretteDao()

}