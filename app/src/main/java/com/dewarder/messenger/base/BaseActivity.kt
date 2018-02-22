package com.dewarder.messenger.base

import android.arch.lifecycle.LiveData
import android.arch.lifecycle.ViewModel
import android.arch.lifecycle.ViewModelProvider
import android.arch.lifecycle.ViewModelProviders
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.dewarder.messenger.util.observeNonNull
import javax.inject.Inject
import kotlin.reflect.KClass

abstract class BaseActivity<VM : ViewModel> : AppCompatActivity() {

    @Inject
    protected lateinit var viewModelFactory: ViewModelProvider.Factory

    lateinit var viewModel: VM
        private set

    protected abstract fun injectComponents()

    protected abstract fun viewModelClass(): KClass<out VM>

    override fun onCreate(savedInstanceState: Bundle?) {
        injectComponents()
        super.onCreate(savedInstanceState)

        if (!this::viewModelFactory.isInitialized) {
            throw IllegalStateException("ViewModelFactory should be initialized in `injectComponents`")
        }

        viewModel = ViewModelProviders.of(this, viewModelFactory).get(viewModelClass().java)
        onViewModelCreated(viewModel)
    }

    open fun onViewModelCreated(viewModel: VM) {

    }

    fun <T : Any> LiveData<T>.observe(observer: (T) -> Unit) {
        observeNonNull(this@BaseActivity, observer)
    }
}