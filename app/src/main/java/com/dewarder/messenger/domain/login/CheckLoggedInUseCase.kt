package com.dewarder.messenger.domain.login

import io.reactivex.Flowable
import javax.inject.Inject

class CheckLoggedInUseCase @Inject constructor(
        private val loginRepository: LoginRepository
) {

    fun isLoggedIn(): Flowable<Boolean> =
            loginRepository.isLoggedIn()
}