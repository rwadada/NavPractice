package com.rwadada.navpractice.di.modules

import com.rwadada.main.MainFragment
import com.rwadada.sub.SubFragment
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class FragmentModule {
    @ContributesAndroidInjector
    internal abstract fun contributeMainFragment(): MainFragment

    @ContributesAndroidInjector
    internal abstract fun contributeSubFragment(): SubFragment
}