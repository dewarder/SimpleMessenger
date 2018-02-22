package com.dewarder.messenger.base

import android.arch.lifecycle.ViewModel
import io.reactivex.disposables.CompositeDisposable

abstract class BaseViewModel : ViewModel() {

    protected val disposables = CompositeDisposable()

    fun dispose() {
        disposables.dispose()
    }
}