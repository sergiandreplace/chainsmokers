package com.blindbugs.chainsmokers.ui.main

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.Toast
import com.blindbugs.chainsmokers.R
import com.blindbugs.chainsmokers.infrastructure.di.extension.AppCompatActivity.app
import com.blindbugs.chainsmokers.infrastructure.di.main.MainModule
import kotlinx.android.synthetic.main.activity_main.*
import javax.inject.Inject

class MainActivity : AppCompatActivity(), MainPresenter.MainPresenterView {
    val component by lazy { app.component.plus(MainModule(this)) }

    @Inject
    lateinit var presenter:MainPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        component.inject(this)

        presenter.view = this
        createEntryButton.setOnClickListener { onCreateEntryClick() }
    }

    fun onCreateEntryClick() {
    }

    override fun onEntryCreated() {
        Toast.makeText(this, "Created",Toast.LENGTH_LONG).show()
    }
}
