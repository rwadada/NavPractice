package com.rwadada.feature_sub

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment

class SubFragment : Fragment() {
    companion object {
        @Suppress("unused")
        private val TAG: String = SubFragment::class.java.simpleName
    }

    private lateinit var button1: Button
    private lateinit var button2: Button

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view: View = inflater.inflate(R.layout.fragment_sub, container, false)
        button1 = view.findViewById(R.id.button)
        button2 = view.findViewById(R.id.button2)

        setOnClickListeners()

        return view
    }

    private fun setOnClickListeners() {
        button1.setOnClickListener {
            Log.d(TAG, "ON CLICK BUTTON1")
        }

        button2.setOnClickListener {
            Log.d(TAG, "ON CLICK BUTTON2")
        }
    }
}