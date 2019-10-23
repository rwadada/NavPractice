package com.rwadada.core

import android.content.Context
import androidx.core.content.ContextCompat

class Colors(private val context: Context) {
    fun getWhite(): Int =
        ContextCompat.getColor(context, android.R.color.white)
}