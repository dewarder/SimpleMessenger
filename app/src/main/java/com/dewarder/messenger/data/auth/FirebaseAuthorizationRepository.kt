package com.dewarder.messenger.data.auth

import com.dewarder.messenger.domain.auth.AuthorizationRepository
import com.google.firebase.auth.FirebaseAuth
import io.reactivex.BackpressureStrategy
import io.reactivex.Flowable
import javax.inject.Inject

class FirebaseAuthorizationRepository @Inject constructor(
        private val firebaseAuth: FirebaseAuth
) : AuthorizationRepository {

    override fun getCurrentUserId(): Flowable<String> =
            Flowable.create({ emitter ->
                val user = firebaseAuth.currentUser
                if (!emitter.isCancelled) {
                    if (user == null) {
                        emitter.onError(IllegalStateException("User isn't authorized"))
                    } else {
                        emitter.onNext(user.uid)
                        emitter.onComplete()
                    }
                }
            }, BackpressureStrategy.DROP)

}