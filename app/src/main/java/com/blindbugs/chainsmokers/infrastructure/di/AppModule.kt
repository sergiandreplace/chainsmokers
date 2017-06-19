package com.blindbugs.chainsmokers.infrastructure.di

import android.arch.persistence.room.Room
import com.blindbugs.chainsmokers.ChainSmokersApplication
import com.blindbugs.chainsmokers.infrastructure.database.AppDatabase
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class AppModule(val app: ChainSmokersApplication) {
  @Provides @Singleton fun app() = app


}