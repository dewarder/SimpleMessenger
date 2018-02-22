package com.dewarder.messenger.di

import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.FirebaseFirestore
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class FirebaseModule {

    @Provides
    fun provideFirebaseFirestore(): FirebaseFirestore =
            FirebaseFirestore.getInstance()

    @Provides
    fun provideFirebaseAuth(): FirebaseAuth =
            FirebaseAuth.getInstance()
}