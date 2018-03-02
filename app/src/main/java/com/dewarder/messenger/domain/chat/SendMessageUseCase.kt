package com.dewarder.messenger.domain.chat

import com.dewarder.messenger.domain.auth.AuthorizationRepository
import io.reactivex.Flowable
import javax.inject.Inject

class SendMessageUseCase @Inject constructor(
        private val chatRepository: ChatRepository,
        private val authorizationRepository: AuthorizationRepository
) {

    fun execute(
            roomId: String,
            message: ChatMessageCreate
    ): Flowable<Nothing> = authorizationRepository.getCurrentUserId()
            .flatMap { userId -> chatRepository.sendMessage(userId, roomId, message) }
}