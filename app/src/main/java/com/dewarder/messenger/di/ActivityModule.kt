package com.dewarder.messenger.di

import com.dewarder.messenger.ui.chat.ChatListActivity
import com.dewarder.messenger.ui.chat.ChatRoomActivity
import com.dewarder.messenger.ui.login.LoginPasswordActivity
import com.dewarder.messenger.ui.login.LoginUsernameActivity
import com.dewarder.messenger.ui.splash.SplashActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
interface ActivityModule {

    @ContributesAndroidInjector
    fun bindSplashActivity(): SplashActivity

    @ContributesAndroidInjector
    fun bindLoginUsernameActivity(): LoginUsernameActivity

    @ContributesAndroidInjector
    fun bindLoginPasswordActivity(): LoginPasswordActivity

    @ContributesAndroidInjector
    fun bindChatListActivity(): ChatListActivity

    @ContributesAndroidInjector
    fun bindChatRoomActivity(): ChatRoomActivity
}