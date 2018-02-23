package com.dewarder.messenger.data.login

import com.dewarder.messenger.domain.login.LoginRepository
import com.dewarder.messenger.util.firebase.toFlowable
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseAuthInvalidCredentialsException
import io.reactivex.Flowable
import javax.inject.Inject

class FirebaseLoginRepository @Inject constructor(
        private val firebaseAuth: FirebaseAuth
) : LoginRepository {

    override fun isLoggedIn(): Flowable<Boolean> =
            Flowable.fromCallable { firebaseAuth.currentUser != null }

    override fun checkEmail(email: String): Flowable<Boolean> =
            firebaseAuth.fetchProvidersForEmail(email)
                    .toFlowable()
                    .map { result -> result.providers.orEmpty().isNotEmpty() }

    override fun login(email: String, password: String): Flowable<Boolean> =
            firebaseAuth.signInWithEmailAndPassword(email, password)
                    .toFlowable()
                    .map { result -> result.user != null }
                    .onErrorResumeNext { throwable: Throwable ->
                        if (throwable is FirebaseAuthInvalidCredentialsException) {
                            Flowable.just(false)
                        } else {
                            Flowable.error(throwable)
                        }
                    }
}