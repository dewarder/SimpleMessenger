package com.dewarder.messenger.ui.chat

import com.dewarder.messenger.base.BaseViewModel
import com.dewarder.messenger.domain.chat.ChatMessageCreate
import com.dewarder.messenger.domain.chat.SendMessageUseCase
import com.dewarder.messenger.util.plusAssign
import timber.log.Timber
import javax.inject.Inject

class ChatRoomViewModel @Inject constructor(
        private val sendMessageUseCase: SendMessageUseCase
) : BaseViewModel() {

    fun sendTestMessage(chatId: String) {
        disposables += sendMessageUseCase
                .execute(chatId, ChatMessageCreate("Message"))
                .doOnComplete { Timber.v("Success") }
                .doOnError { Timber.e(it) }
                .subscribe()
    }
}