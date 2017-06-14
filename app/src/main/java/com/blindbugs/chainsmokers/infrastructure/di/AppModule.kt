package com.blindbugs.chainsmokers.infrastructure.di

import com.blindbugs.chainsmokers.ChainSmokersApplication
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class AppModule(val app: ChainSmokersApplication) {
  @Provides @Singleton fun app() = app
}