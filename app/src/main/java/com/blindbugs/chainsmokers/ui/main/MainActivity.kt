package com.blindbugs.chainsmokers.ui.main

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.blindbugs.chainsmokers.R
import com.blindbugs.chainsmokers.domain.model.Cigarette
import com.blindbugs.chainsmokers.infrastructure.di.activity.MainActivityModule
import com.blindbugs.chainsmokers.infrastructure.extension.app
import kotlinx.android.synthetic.main.activity_main.*
import org.jetbrains.anko.longToast
import org.jetbrains.anko.toast
import org.threeten.bp.LocalDate
import javax.inject.Inject

class MainActivity : AppCompatActivity(), MainPresenter.MainPresenterView {
  val component by lazy { app.component.plus(MainActivityModule(this)) }

  @Inject
  lateinit var presenter: MainPresenter

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.activity_main)
    component.inject(this)

    presenter.view = this
    presenter.init()
    createEntryButton.setOnClickListener { presenter.createEntry() }

  }

  override fun onEntriesByDayUpdated(days: Map<LocalDate, Long>) {
    val output = StringBuilder()
    toast("Items : " + days.size)
    days.forEach { output.appendln("${it.key}: ${it.value}") }
    longToast(output)
  }

  override fun onEntryCreated(cigarette: Cigarette) {
    toast("Cigarette created at " + cigarette.timestamp)
  }
}
