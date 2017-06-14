package com.blindbugs.chainsmokers.infrastructure.di.activity

import android.content.Context
import com.blindbugs.chainsmokers.ui.main.MainActivity
import dagger.Module
import dagger.Provides

@Module
class MainActivityModule(val activity: MainActivity) {

  @Provides
  fun context(): Context = activity

}