package com.dewarder.messenger.domain.login

import io.reactivex.Flowable
import javax.inject.Inject

class CheckEmailExistUseCase @Inject constructor(
        private val loginRepository: LoginRepository
) {

    fun execute(email: String): Flowable<CheckEmailResult> =
            loginRepository.checkEmail(email)
                    .map { exist -> CheckEmailResult(exist, email) }

}