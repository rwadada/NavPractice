package com.rwadada.navpractice.di.components

import android.app.Application
import com.rwadada.navpractice.di.modules.ActivityModule
import com.rwadada.navpractice.di.modules.FragmentModule
import com.rwadada.navpractice.di.modules.NavigationModule
import dagger.Component
import dagger.android.AndroidInjectionModule
import dagger.android.support.AndroidSupportInjectionModule
import javax.inject.Singleton

@Singleton
@Component(
    modules = [
        AndroidSupportInjectionModule::class,
        NavigationModule::class,
        ActivityModule::class
    ]
)
interface AppComponent {
    @Component.Factory
    interface Factory {
        fun create(): AppComponent
    }

    fun inject(application: Application)
}