package com.surfaceduo.training.listitems

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.microsoft.device.dualscreen.core.ScreenHelper

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        if (!ScreenHelper.isDualMode(this)) {
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