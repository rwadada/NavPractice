package com.rwadada.sub

import android.content.Context
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import com.rwadada.core.Destinations
import com.rwadada.core.Navigation
import com.rwadada.sub.databinding.FragmentSubBinding
import dagger.android.support.AndroidSupportInjection
import javax.inject.Inject

class SubFragment : Fragment() {
    companion object {
        @Suppress("unused")
        private val TAG: String = SubFragment::class.java.simpleName
    }

    private lateinit var binding: FragmentSubBinding

    @Inject
    lateinit var navigation: Navigation

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_sub, container, false)
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
        navigation.navigate(this, Destinations.SUB_FRAGMENT)
    }

    @Suppress("UNUSED_PARAMETER")
    fun onClickButton1(view: View) {
        Log.d(TAG, "ON CLICK BUTTON1")
    }

    @Suppress("UNUSED_PARAMETER")
    fun onClickButton2(view: View) {
        Log.d(TAG, "ON CLICK BUTTON2")
        navigation.navigate(this, Destinations.MAIN_FRAGMENT)
    }
}