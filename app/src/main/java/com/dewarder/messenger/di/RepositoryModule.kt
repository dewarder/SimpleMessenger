package com.dewarder.messenger.di

import com.dewarder.messenger.data.auth.FirebaseAuthorizationRepository
import com.dewarder.messenger.data.chat.FirebaseChatRepository
import com.dewarder.messenger.data.login.FirebaseLoginRepository
import com.dewarder.messenger.domain.auth.AuthorizationRepository
import com.dewarder.messenger.domain.chat.ChatRepository
import com.dewarder.messenger.domain.login.LoginRepository
import dagger.Binds
import dagger.Module

@Module
interface RepositoryModule {

    @Binds
    fun bindLoginRepository(repository: FirebaseLoginRepository): LoginRepository

    @Binds
    fun bindChatRepository(repository: FirebaseChatRepository): ChatRepository

    @Binds
    fun bindAuthorizationRepository(repository: FirebaseAuthorizationRepository): AuthorizationRepository
}