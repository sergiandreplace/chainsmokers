package com.blindbugs.chainsmokers.infrastructure.di

import com.blindbugs.chainsmokers.ChainSmokersApplication
import com.blindbugs.chainsmokers.infrastructure.di.main.MainActivityComponent
import com.blindbugs.chainsmokers.infrastructure.di.main.MainActivityModule
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = arrayOf(AppModule::class, DataModule::class))
interface AppComponent {
  fun inject(app: ChainSmokersApplication)

  fun plus(mainActivityModule: MainActivityModule): MainActivityComponent



}