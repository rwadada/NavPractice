package com.rwadada.navpractice

import android.app.Application
import com.rwadada.navpractice.di.components.DaggerAppComponent
import dagger.android.AndroidInjector
import dagger.android.DispatchingAndroidInjector
import dagger.android.HasAndroidInjector
import javax.inject.Inject

class ApplicationWrapper : Application(), HasAndroidInjector {

    @Inject
    lateinit var androidInjector: DispatchingAndroidInjector<Any>

    override fun androidInjector(): AndroidInjector<Any> {
        DaggerAppComponent.create().inject(this)
        return androidInjector
    }

    override fun onCreate() {
        super.onCreate()
    }
}