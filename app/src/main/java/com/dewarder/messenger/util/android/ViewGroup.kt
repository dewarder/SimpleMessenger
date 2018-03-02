package com.dewarder.messenger.util.android

import android.support.annotation.LayoutRes
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

@Suppress("unchecked_cast")
fun <T : View> ViewGroup.inflateInto(
        @LayoutRes layoutRes: Int,
        attachToRoot: Boolean = false
): T = LayoutInflater.from(context).inflate(layoutRes, this, attachToRoot) as T