package com.blindbugs.chainsmokers.infrastructure.di.activity

import com.blindbugs.chainsmokers.domain.model.EntryCollection
import com.blindbugs.chainsmokers.ui.main.MainActivity
import dagger.Subcomponent
import javax.inject.Singleton

@Singleton
@Subcomponent(modules = arrayOf(MainActivityModule::class))
interface MainActivityComponent {
  fun inject(activity: MainActivity)

  fun entryCollection(): EntryCollection

}