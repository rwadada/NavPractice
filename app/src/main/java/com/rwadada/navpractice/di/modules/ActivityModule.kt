package com.rwadada.navpractice.di.modules

import com.rwadada.navpractice.MainActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class ActivityModule {
    @ContributesAndroidInjector
    internal abstract fun contributeMainActivity(): MainActivity
}