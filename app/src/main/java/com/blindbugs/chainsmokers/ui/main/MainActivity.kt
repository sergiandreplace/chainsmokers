package com.blindbugs.chainsmokers.ui.main

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.Toast
import com.blindbugs.chainsmokers.R
import com.blindbugs.chainsmokers.infrastructure.ServiceLocator
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), MainPresenter.MainPresenterView {

    val presenter: MainPresenter = ServiceLocator.instance.getMainPresenter(this)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        createEntryButton.setOnClickListener { onCreateEntryClick() }
    }

    fun onCreateEntryClick() {
        presenter.createEntry()
    }

    override fun onEntryCreated() {
        Toast.makeText(this, "Created",Toast.LENGTH_LONG).show();
    }
}
