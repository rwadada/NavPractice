package com.rwadada.navpractice.di.modules

import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.navigation.NavOptions
import androidx.navigation.fragment.FragmentNavigator
import androidx.navigation.fragment.NavHostFragment.findNavController
import com.rwadada.core.Destinations
import com.rwadada.core.Navigation
import com.rwadada.feature_main.MainFragment
import com.rwadada.feature_main.MainFragmentDirections
import com.rwadada.feature_sub.SubFragment
import com.rwadada.feature_sub.SubFragmentDirections
import com.rwadada.navpractice.R
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
object NavigationModule {
    @JvmStatic
    @Singleton
    @Provides
    fun provideNavigation(): Navigation {
        return object : Navigation {
            override fun navigate(
                fragment: Fragment,
                destinations: Destinations,
                args: Bundle?,
                navOptions: NavOptions?,
                extras: FragmentNavigator.Extras?
            ) {
                when (fragment) {
                    MainFragment::class -> {
                        mainNavigation(
                            fragment as MainFragment,
                            destinations,
                            args,
                            navOptions,
                            extras
                        )
                    }
                    SubFragment::class -> {
                        subNavigation(
                            fragment as SubFragment,
                            destinations,
                            args,
                            navOptions,
                            extras
                        )
                    }
                }
                super.navigate(fragment, destinations, args, navOptions, extras)
            }
        }
    }

    private fun mainNavigation(
        fragment: MainFragment,
        destinations: Destinations,
        args: Bundle?,
        navOptions: NavOptions?,
        extras: FragmentNavigator.Extras?
    ) {
        when (destinations) {
            Destinations.MAIN_FRAGMENT -> {
                if (args == null && extras == null) {
                    findNavController(fragment).navigate(MainFragmentDirections.actionMainFragmentSelf())
                } else {
                    findNavController(fragment).navigate(
                        R.id.action_mainFragment_self,
                        args,
                        navOptions,
                        extras
                    )
                }
            }
            Destinations.SUB_FRAGMENT -> {
                if (args == null && extras == null) {
                    findNavController(fragment).navigate(MainFragmentDirections.actionMainFragmentToSubFragment())
                } else {
                    findNavController(fragment).navigate(
                        R.id.action_mainFragment_to_subFragment,
                        args,
                        navOptions,
                        extras
                    )
                }
            }
        }

    }

    private fun subNavigation(
        fragment: SubFragment,
        destinations: Destinations,
        args: Bundle?,
        navOptions: NavOptions?,
        extras: FragmentNavigator.Extras?
    ) {
        when (destinations) {
            Destinations.MAIN_FRAGMENT -> {
                if (args == null && extras == null) {
                    findNavController(fragment).navigate(SubFragmentDirections.actionSubFragmentToMainFragment())
                } else {
                    findNavController(fragment).navigate(
                        R.id.action_subFragment_to_mainFragment,
                        args,
                        navOptions,
                        extras
                    )
                }
            }
            Destinations.SUB_FRAGMENT -> {
                if (args == null && extras == null) {
                    findNavController(fragment).navigate(SubFragmentDirections.actionSubFragmentSelf())
                } else {
                    findNavController(fragment).navigate(
                        R.id.action_subFragment_self,
                        args,
                        navOptions,
                        extras
                    )
                }
            }
        }

    }
}