package com.dewarder.messenger.ui.chat

import android.content.Context
import android.content.Intent
import com.dewarder.messenger.base.BaseActivity
import com.dewarder.messenger.domain.chat.ChatRoom
import dagger.android.AndroidInjection
import kotlinx.android.parcel.Parcelize

class ChatRoomActivity : BaseActivity<ChatRoomViewModel>() {

    override fun injectComponents() = AndroidInjection.inject(this)

    override fun viewModelClass() = ChatRoomViewModel::class

    override fun onViewModelCreated(viewModel: ChatRoomViewModel) {
        val arguments: Arguments = getArguments()

        viewModel.sendTestMessage(arguments.chatRoom.id)
    }

    @Parcelize
    data class Arguments(
            val chatRoom: ChatRoom
    ) : ArgumentsContainer

    companion object {

        fun start(context: Context, arguments: Arguments) {
            context.startActivity(
                    Intent(context, ChatRoomActivity::class.java).putArguments(arguments)
            )
        }
    }

}