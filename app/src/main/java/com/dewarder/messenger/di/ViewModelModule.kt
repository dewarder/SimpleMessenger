package com.dewarder.messenger.di

import android.arch.lifecycle.ViewModel
import android.arch.lifecycle.ViewModelProvider
import com.dewarder.messenger.ui.chat.ChatListViewModel
import com.dewarder.messenger.ui.login.LoginPasswordViewModel
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

    @Binds
    @IntoMap
    @ViewModelKey(LoginPasswordViewModel::class)
    fun bindLoginPasswordViewModel(viewModel: LoginPasswordViewModel): ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(ChatListViewModel::class)
    fun bindChatListViewModel(viewModel: ChatListViewModel): ViewModel

}