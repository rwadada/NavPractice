package com.rwadada.feature_main

import android.content.Context
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment
import com.rwadada.core.Destinations
import com.rwadada.core.Navigation
import dagger.android.support.AndroidSupportInjection
import javax.inject.Inject

class MainFragment : Fragment() {
    companion object {
        @Suppress("unused")
        private val TAG: String = MainFragment::class.java.simpleName
    }

    private lateinit var button1: Button
    private lateinit var button2: Button

    @Inject
    lateinit var navigation: Navigation

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view: View = inflater.inflate(R.layout.fragment_main, container, false)
        button1 = view.findViewById(R.id.button)
        button2 = view.findViewById(R.id.button2)

        setOnClickListeners()

        return view
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        AndroidSupportInjection.inject(this)
    }

    private fun setOnClickListeners() {
        button1.setOnClickListener {
            Log.d(TAG, "ON CLICK BUTTON1")
        }

        button2.setOnClickListener {
            Log.d(TAG, "ON CLICK BUTTON2")
            navigation.navigate(this, Destinations.SUB_FRAGMENT)
        }
    }
}