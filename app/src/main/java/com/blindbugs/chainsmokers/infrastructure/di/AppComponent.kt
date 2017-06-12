package com.blindbugs.chainsmokers.infrastructure.di

import android.content.Context
import com.blindbugs.chainsmokers.ChainSmokersApplication
import com.blindbugs.chainsmokers.infrastructure.di.main.MainComponent
import com.blindbugs.chainsmokers.infrastructure.di.main.MainModule
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = arrayOf(AppModule::class))
interface AppComponent {
    fun inject(app: ChainSmokersApplication)

    fun plus(mainModule: MainModule): MainComponent



}