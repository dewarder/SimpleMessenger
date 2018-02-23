package com.dewarder.messenger.domain.chat

import com.dewarder.messenger.domain.auth.AuthorizationRepository
import io.reactivex.Flowable
import javax.inject.Inject

class GetChatListUseCase @Inject constructor(
        private val chatRepository: ChatRepository,
        private val authorizationRepository: AuthorizationRepository
) {

    fun execute(): Flowable<List<ChatRoom>> =
            authorizationRepository.getCurrentUserId()
                    .flatMap(chatRepository::getChatRooms)
}