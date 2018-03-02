package com.dewarder.messenger.domain.chat

import io.reactivex.Flowable

interface ChatRepository {

    fun getChatRooms(userId: String): Flowable<List<ChatRoom>>

    fun getChatMessages(userId: String, roomId: String): Flowable<List<ChatMessage>>

    fun sendMessage(userId: String, roomId: String, message: ChatMessageCreate): Flowable<Nothing>
}