package com.surfaceduo.training.listitems

import android.app.Application
import com.microsoft.device.dualscreen.ScreenManagerProvider

class ListItemsApp : Application() {

    override fun onCreate() {
        super.onCreate()
        ScreenManagerProvider.init(this)
    }
}