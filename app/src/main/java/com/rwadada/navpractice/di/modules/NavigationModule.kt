package com.rwadada.navpractice.di.modules

import android.app.Activity
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import androidx.navigation.NavOptions
import androidx.navigation.fragment.FragmentNavigator
import androidx.navigation.fragment.NavHostFragment.findNavController
import com.rwadada.core.Destinations
import com.rwadada.core.Navigation
import com.rwadada.main.MainFragment
import com.rwadada.main.MainFragmentDirections
import com.rwadada.sub.SubFragment
import com.rwadada.sub.SubFragmentDirections
import com.rwadada.navpractice.R
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
object NavigationModule {
    @Singleton
    @Provides
    fun provideNavigation(): Navigation {
        return object : Navigation {
            override var currentActivity: Activity? = null
            override fun navigate(
                fragment: Fragment,
                destinations: Destinations,
                args: Bundle?,
                navOptions: NavOptions?,
                extras: FragmentNavigator.Extras?
            ) {
                when (fragment::class) {
                    MainFragment::class -> {
                        mainNavigation(
                            currentActivity,
                            fragment as MainFragment,
                            destinations,
                            args,
                            navOptions,
                            extras
                        )
                    }
                    SubFragment::class -> {
                        subNavigation(
                            currentActivity,
                            fragment as SubFragment,
                            destinations,
                            args,
                            navOptions,
                            extras
                        )
                    }
                    else -> {
                        super.navigate(fragment, destinations, args, navOptions, extras)
                    }
                }
            }
        }
    }

    private fun mainNavigation(
        currentActivity: Activity?,
        fragment: MainFragment,
        destinations: Destinations,
        args: Bundle?,
        navOptions: NavOptions?,
        extras: FragmentNavigator.Extras?
    ) {
        Log.d("NAVIGATION", "Called by ${MainFragment::class.java.simpleName}")
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
            Destinations.GOOGLE -> {
                openGoogle(currentActivity)
            }
        }

    }

    private fun subNavigation(
        currentActivity: Activity?,
        fragment: SubFragment,
        destinations: Destinations,
        args: Bundle?,
        navOptions: NavOptions?,
        extras: FragmentNavigator.Extras?
    ) {
        Log.d("NAVIGATION", "Called by ${SubFragment::class.java.simpleName}")
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
            Destinations.GOOGLE -> {
                openGoogle(currentActivity)
            }
        }
    }

    private fun openGoogle(currentActivity: Activity?) {
        val uri: Uri = Uri.parse("https://github.com/rwadada/NavPractice")
        val intent = Intent(Intent.ACTION_VIEW, uri)
        currentActivity?.startActivity(intent)
    }
}