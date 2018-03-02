package com.dewarder.messenger.domain.chat

import com.dewarder.messenger.base.FirebaseModel

@FirebaseModel
data class ChatMessage(
        val id: String,
        val content: String
)