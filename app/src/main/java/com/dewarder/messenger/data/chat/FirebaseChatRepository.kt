package com.dewarder.messenger.data.chat

import com.dewarder.messenger.domain.chat.ChatRepository
import com.dewarder.messenger.domain.chat.ChatRoom
import com.dewarder.messenger.util.firebase.toFlowable
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.Query
import io.reactivex.Flowable
import java.util.*
import javax.inject.Inject

class FirebaseChatRepository @Inject constructor(
        private val firebaseFirestore: FirebaseFirestore
) : ChatRepository {

    override fun getChatRooms(userId: String): Flowable<List<ChatRoom>> {
        return firebaseFirestore.collection("chat")
                .whereGreaterThan("member.$userId", Date(0))
                .orderBy("member.$userId", Query.Direction.DESCENDING)
                .get()
                .toFlowable()
                .map { result ->
                    result.toObjects(ChatRoom::class.java)
                    result.map { document ->
                        ChatRoom(name = document.getString("name"))
                    }
                }
    }

}