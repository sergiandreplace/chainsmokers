package com.blindbugs.chainsmokers

import android.app.Application
import com.blindbugs.chainsmokers.infrastructure.di.AppComponent
import com.blindbugs.chainsmokers.infrastructure.di.AppModule
import com.blindbugs.chainsmokers.infrastructure.di.DaggerAppComponent
import com.jakewharton.threetenabp.AndroidThreeTen


class ChainSmokersApplication : Application() {

  val component: AppComponent by lazy {
    DaggerAppComponent
      .builder()
      .appModule(AppModule(this))
      .build()
  }

  override fun onCreate() {
    super.onCreate()
    component.inject(this)
    AndroidThreeTen.init(this);
  }
}
