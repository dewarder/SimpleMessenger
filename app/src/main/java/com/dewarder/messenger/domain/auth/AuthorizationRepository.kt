package com.dewarder.messenger.domain.auth

import io.reactivex.Flowable

interface AuthorizationRepository {

    fun getCurrentUserId(): Flowable<String>
}