package com.dewarder.messenger.domain.login

import io.reactivex.Flowable

interface LoginRepository {

    fun isLoggedIn(): Flowable<Boolean>

    fun checkEmail(email: String): Flowable<Boolean>

    fun login(email: String, password: String): Flowable<Boolean>
}