package com.dewarder.messenger.ui.chat

import android.arch.lifecycle.LiveData
import android.arch.lifecycle.MutableLiveData
import com.dewarder.messenger.base.BaseViewModel
import com.dewarder.messenger.domain.chat.ChatRoom
import com.dewarder.messenger.domain.chat.GetChatListUseCase
import com.dewarder.messenger.util.plusAssign
import timber.log.Timber
import javax.inject.Inject

class ChatListViewModel @Inject constructor(
        private val getChatListUseCase: GetChatListUseCase
) : BaseViewModel() {

    private val mutableChatRooms = MutableLiveData<List<ChatRoom>>()
    val chatRooms: LiveData<List<ChatRoom>>
        get() = mutableChatRooms

    fun fetchChatRooms() {
        disposables += getChatListUseCase.execute()
                .doOnNext { rooms ->
                    Timber.v("fetchChatRooms, onNext %s", rooms)
                }
                .subscribe(mutableChatRooms::postValue)
    }

}