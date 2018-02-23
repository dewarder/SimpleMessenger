package com.dewarder.messenger.domain.chat

import io.reactivex.Flowable

interface ChatRepository {

    fun getChatRooms(userId: String): Flowable<List<ChatRoom>>
}