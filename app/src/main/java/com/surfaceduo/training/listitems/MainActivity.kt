package com.surfaceduo.training.listitems

import android.content.res.Configuration
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.microsoft.device.dualscreen.ScreenInfo
import com.microsoft.device.dualscreen.ScreenInfoListener
import com.microsoft.device.dualscreen.ScreenInfoProvider
import com.microsoft.device.dualscreen.ScreenManagerProvider

class MainActivity : AppCompatActivity(), ScreenInfoListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    override fun onConfigurationChanged(newConfig: Configuration) {
        super.onConfigurationChanged(newConfig)
        ScreenManagerProvider.getScreenManager().onConfigurationChanged()
    }

    override fun onStart() {
        super.onStart()
        ScreenManagerProvider.getScreenManager().addScreenInfoListener(this)
    }

    override fun onStop() {
        super.onStop()
        ScreenManagerProvider.getScreenManager().removeScreenInfoListener(this)
    }

    override fun onScreenInfoChanged(screenInfo: ScreenInfo) {
        setupFragments()
    }

    private fun setupFragments() {
        val screenInfo = ScreenInfoProvider.getScreenInfo(this)
        if (!screenInfo.isDualMode()) {
            supportFragmentManager.beginTransaction()
                .replace(R.id.first_container_id, ListItemsFragment())
                .commit()
        } else {
            supportFragmentManager.beginTransaction()
                .replace(R.id.first_container_id, ListItemsFragment())
                .replace(R.id.second_container_id, DetailFragment())
                .commit()
        }
    }

}