package com.dewarder.messenger.di

import com.dewarder.messenger.data.login.FirebaseLoginRepository
import com.dewarder.messenger.domain.login.LoginRepository
import dagger.Binds
import dagger.Module
import javax.inject.Singleton

@Module
interface RepositoryModule {

    @Binds
    fun bindLoginRepository(loginRepository: FirebaseLoginRepository): LoginRepository
}