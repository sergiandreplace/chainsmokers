package com.blindbugs.chainsmokers.infrastructure.di.extension.AppCompatActivity

import android.support.v7.app.AppCompatActivity
import com.blindbugs.chainsmokers.ChainSmokersApplication


val AppCompatActivity.app: ChainSmokersApplication
    get() = application as ChainSmokersApplication
