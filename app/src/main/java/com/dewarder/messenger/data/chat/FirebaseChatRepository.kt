package com.dewarder.messenger.data.chat

import com.dewarder.messenger.domain.chat.ChatMessage
import com.dewarder.messenger.domain.chat.ChatMessageCreate
import com.dewarder.messenger.domain.chat.ChatRepository
import com.dewarder.messenger.domain.chat.ChatRoom
import com.dewarder.messenger.util.firebase.toFlowable
import com.google.firebase.firestore.DocumentSnapshot
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.Query
import io.reactivex.Flowable
import java.util.*
import javax.inject.Inject

class FirebaseChatRepository @Inject constructor(
        private val firebaseFirestore: FirebaseFirestore
) : ChatRepository {

    override fun getChatRooms(userId: String): Flowable<List<ChatRoom>> {
        fun map(document: DocumentSnapshot) = ChatRoom(
                id = document.id,
                name = document.getString("name")
        )

        return firebaseFirestore.collection("chat")
                .whereGreaterThan("member.$userId", Date(0))
                .orderBy("member.$userId", Query.Direction.DESCENDING)
                .get()
                .toFlowable()
                .map { result -> result.map(::map) }
    }

    override fun getChatMessages(userId: String, roomId: String): Flowable<List<ChatMessage>> {
        fun map(document: DocumentSnapshot) = ChatMessage(
                id = document.id,
                content = document.getString("content")
        )

        return firebaseFirestore.collection("chat")
                .document(roomId)
                .collection("message")
                .document(userId)
                .collection("history")
                .get()
                .toFlowable()
                .map { result -> result.map(::map) }
    }

    override fun sendMessage(
            userId: String,
            roomId: String,
            message: ChatMessageCreate
    ): Flowable<Nothing> {

        return firebaseFirestore.collection("chat")
                .document(roomId)
                .collection("message")
                .document(userId)
                .collection("history")
                .document()
                .set(message)
                .toFlowable()
                .flatMap { Flowable.empty<Nothing>() }
    }
}