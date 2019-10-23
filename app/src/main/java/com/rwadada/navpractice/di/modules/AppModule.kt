package com.rwadada.navpractice.di.modules

import android.content.Context
import com.rwadada.core.Colors
import com.rwadada.navpractice.ApplicationWrapper
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
object AppModule {
    @Singleton
    @Provides
    fun provideContext(applicationWrapper: ApplicationWrapper): Context = applicationWrapper.applicationContext

    @Singleton
    @Provides
    fun provideColors(context: Context) = Colors(context)
}