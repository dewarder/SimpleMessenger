package com.dewarder.messenger.di

import android.arch.lifecycle.ViewModel
import android.arch.lifecycle.ViewModelProvider
import com.dewarder.messenger.ui.login.LoginUsernameViewModel
import com.dewarder.messenger.ui.splash.SplashViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
interface ViewModelModule {

    @Binds
    fun bindViewModelFactory(factory: ViewModelFactory): ViewModelProvider.Factory

    @Binds
    @IntoMap
    @ViewModelKey(SplashViewModel::class)
    fun bindSplashViewModel(viewModel: SplashViewModel): ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(LoginUsernameViewModel::class)
    fun bindLoginUsernameViewModel(viewModel: LoginUsernameViewModel): ViewModel

}