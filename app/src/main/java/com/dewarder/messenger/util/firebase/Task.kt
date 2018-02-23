package com.dewarder.messenger.util.firebase

import com.google.android.gms.tasks.Task
import io.reactivex.BackpressureStrategy
import io.reactivex.Flowable
import io.reactivex.FlowableEmitter
import io.reactivex.FlowableOnSubscribe

fun <T : Any> Task<T>.toFlowable(
        mode: BackpressureStrategy = BackpressureStrategy.DROP
): Flowable<T> = Flowable.create(FirebaseTaskFlowableOnSubscribe(this), mode)

private class FirebaseTaskFlowableOnSubscribe<T>(
        val firebaseTask: Task<T>
) : FlowableOnSubscribe<T> {

    override fun subscribe(emitter: FlowableEmitter<T>) {
        firebaseTask.addOnCompleteListener { task ->
            if (!emitter.isCancelled) {
                if (task.isSuccessful) {
                    emitter.onNext(task.result!!)
                } else {
                    emitter.onError(task.exception!!)
                }
                emitter.onComplete()
            }
        }
    }
}