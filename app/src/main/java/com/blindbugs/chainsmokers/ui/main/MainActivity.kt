package com.blindbugs.chainsmokers.ui.main

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.Toast
import com.blindbugs.chainsmokers.R
import com.blindbugs.chainsmokers.domain.model.Entry
import com.blindbugs.chainsmokers.infrastructure.di.activity.MainActivityModule
import com.blindbugs.chainsmokers.infrastructure.extension.app
import kotlinx.android.synthetic.main.activity_main.*
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
    createEntryButton.setOnClickListener { presenter.createEntry() }
  }

  override fun onEntryCreated(entry: Entry) {
    Toast.makeText(this, "Entry created at " + entry.timestamp, Toast.LENGTH_SHORT).show()
  }
}
