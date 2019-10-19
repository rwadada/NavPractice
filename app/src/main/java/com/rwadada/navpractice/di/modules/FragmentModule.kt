package com.rwadada.navpractice.di.modules

import com.rwadada.main.MainFragment
import com.rwadada.sub.SubFragment
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class FragmentModule {
    @ContributesAndroidInjector
    abstract fun contributeMainFragment(): MainFragment

    @ContributesAndroidInjector
    abstract fun contributeSubFragment(): SubFragment
}