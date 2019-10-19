package com.rwadada.main

import android.content.Context
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import com.rwadada.core.Destinations
import com.rwadada.core.Navigation
import com.rwadada.main.databinding.FragmentMainBinding
import dagger.android.support.AndroidSupportInjection
import javax.inject.Inject

class MainFragment : Fragment() {
    companion object {
        @Suppress("unused")
        private val TAG: String = MainFragment::class.java.simpleName
    }

    private lateinit var binding: FragmentMainBinding

    @Inject
    lateinit var navigation: Navigation

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_main, container, false)

        binding.handler = this
        binding.lifecycleOwner = viewLifecycleOwner

        return binding.root
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        AndroidSupportInjection.inject(this)
    }

    @Suppress("UNUSED_PARAMETER")
    fun onClickTitle(view: View) {
        Log.d(TAG, "ON CLICK TITLE")
        navigation.navigate(this, Destinations.MAIN_FRAGMENT)
    }

    @Suppress("UNUSED_PARAMETER")
    fun onClickButton1(view: View) {
        Log.d(TAG, "ON CLICK BUTTON1")
        navigation.navigate(this, Destinations.GOOGLE)
    }

    @Suppress("UNUSED_PARAMETER")
    fun onClickButton2(view: View) {
        Log.d(TAG, "ON CLICK BUTTON2")
        navigation.navigate(this, Destinations.SUB_FRAGMENT)
    }
}