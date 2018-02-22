package com.dewarder.messenger.util

import android.arch.lifecycle.LiveData
import android.arch.lifecycle.LiveDataReactiveStreams
import io.reactivex.Flowable

fun <T : Any> Flowable<T>.toLiveData(): LiveData<T> =
        LiveDataReactiveStreams.fromPublisher(this)