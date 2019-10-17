package com.rwadada.navpractice

import android.app.Application
import com.rwadada.navpractice.di.components.DaggerAppComponent

class ApplicationWrapper : Application() {

    override fun onCreate() {
        super.onCreate()
        DaggerAppComponent.create()
            .inject(this)
    }

}