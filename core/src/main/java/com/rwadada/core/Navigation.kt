package com.rwadada.core

import android.app.Activity
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import androidx.navigation.NavOptions
import androidx.navigation.fragment.FragmentNavigator

interface Navigation {
    var currentActivity: Activity?
    fun navigate(fragment: Fragment,
                 destinations: Destinations,
                 args: Bundle? = null,
                 navOptions: NavOptions? = null,
                 extras: FragmentNavigator.Extras? = null
    ) {
        Log.d(Navigation::class.java.simpleName, "DO NOTHING")
    }
}