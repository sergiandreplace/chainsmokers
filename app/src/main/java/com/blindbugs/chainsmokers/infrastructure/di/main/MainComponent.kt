package com.blindbugs.chainsmokers.infrastructure.di.main

import android.content.Context
import com.blindbugs.chainsmokers.ui.main.MainActivity
import com.blindbugs.chainsmokers.ui.main.MainPresenter
import dagger.Subcomponent
import javax.inject.Singleton

@Singleton
@Subcomponent(modules = arrayOf(MainModule::class))
interface MainComponent {
    fun inject(activity: MainActivity)

    fun mainPresenter(): MainPresenter
}