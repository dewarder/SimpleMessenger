package com.dewarder.messenger.data.login

import com.dewarder.messenger.domain.login.LoginRepository
import com.google.firebase.auth.FirebaseAuth
import io.reactivex.Flowable
import javax.inject.Inject

class FirebaseLoginRepository @Inject constructor(
        private val firebaseAuth: FirebaseAuth
) : LoginRepository {

    override fun isLoggedIn(): Flowable<Boolean> =
            Flowable.fromCallable { firebaseAuth.currentUser != null }

    override fun checkEmail(email: String): Flowable<Boolean> {
        return Flowable.fromPublisher { publisher ->
            firebaseAuth.fetchProvidersForEmail(email)
                    .addOnCompleteListener { task ->
                        if (task.isSuccessful) {
                            publisher.onNext(task.result.providers.orEmpty().isNotEmpty())
                        } else {
                            publisher.onError(task.exception!!)
                        }
                    }
        }
    }
}