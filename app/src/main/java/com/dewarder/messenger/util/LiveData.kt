package com.dewarder.messenger.util

import android.arch.lifecycle.LifecycleOwner
import android.arch.lifecycle.LiveData
import android.arch.lifecycle.Observer

fun <T : Any> LiveData<T>.observeNonNull(
        lifecycleOwner: LifecycleOwner,
        observer: (T) -> Unit
) {
    observe(lifecycleOwner, NonNullObserver(observer))
}

private class NonNullObserver<T>(
        val function: (T) -> Unit
) : Observer<T> {
    override fun onChanged(t: T?) {
        function(t!!)
    }
}