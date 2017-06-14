package com.blindbugs.chainsmokers.infrastructure.extension

import android.app.Activity
import com.blindbugs.chainsmokers.ChainSmokersApplication


val Activity.app: ChainSmokersApplication
  get() = application as ChainSmokersApplication
