package com.dewarder.messenger.ui.chat

import android.content.Context
import android.content.Intent
import com.dewarder.messenger.base.BaseActivity
import dagger.android.AndroidInjection

class ChatListActivity : BaseActivity<ChatListViewModel>() {

    override fun injectComponents() = AndroidInjection.inject(this)

    override fun viewModelClass() = ChatListViewModel::class

    override fun onViewModelCreated(viewModel: ChatListViewModel) {
        viewModel.fetchChatRooms()
    }

    companion object {

        fun start(context: Context) {
            context.startActivity(
                    Intent(context, ChatListActivity::class.java)
            )
        }
    }
}