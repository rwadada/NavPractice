package com.rwadada.navpractice.di.components

import com.rwadada.navpractice.ApplicationWrapper
import com.rwadada.navpractice.di.modules.ActivityModule
import com.rwadada.navpractice.di.modules.AppModule
import com.rwadada.navpractice.di.modules.FragmentModule
import com.rwadada.navpractice.di.modules.NavigationModule
import dagger.Component
import dagger.android.AndroidInjectionModule
import dagger.android.AndroidInjector
import javax.inject.Singleton

@Singleton
@Component(
    modules = [
        AndroidInjectionModule::class,
        NavigationModule::class,
        ActivityModule::class,
        FragmentModule::class,
        AppModule::class
    ]
)
interface AppComponent : AndroidInjector<ApplicationWrapper> {

    @Component.Factory
    interface Factory : AndroidInjector.Factory<ApplicationWrapper>
}