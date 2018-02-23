package com.dewarder.messenger.domain.login

import io.reactivex.Flowable
import javax.inject.Inject

class LoginUseCase @Inject constructor(
        private val loginRepository: LoginRepository
) {

    fun execute(email: String, password: String): Flowable<Boolean> =
             loginRepository.login(email, password)
}