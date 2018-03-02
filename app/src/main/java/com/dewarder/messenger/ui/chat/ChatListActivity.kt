package com.dewarder.messenger.ui.chat

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import com.dewarder.messenger.R
import com.dewarder.messenger.base.BaseActivity
import com.dewarder.messenger.domain.chat.ChatRoom
import com.dewarder.messenger.ui.chat.list.ChatRoomRecyclerAdapter
import dagger.android.AndroidInjection
import timber.log.Timber

class ChatListActivity : BaseActivity<ChatListViewModel>(),
        ChatRoomRecyclerAdapter.OnChatRoomClickListener {

    private val chatRoomAdapter = ChatRoomRecyclerAdapter(this)

    override fun injectComponents() = AndroidInjection.inject(this)

    override fun viewModelClass() = ChatListViewModel::class

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_chat_list)

        findViewById<RecyclerView>(R.id.chat_list_recycler).apply {
            adapter = chatRoomAdapter
            layoutManager = LinearLayoutManager(context)
        }
    }

    override fun onViewModelCreated(viewModel: ChatListViewModel) {
        viewModel.fetchChatRooms()

        viewModel.chatRooms.observe { rooms ->
            chatRoomAdapter.submitList(rooms)
        }
    }

    override fun onChatRoomClicked(chatRoom: ChatRoom) {
        Timber.v("onChatRoomClicked, chatRoom %s", chatRoom)
        ChatRoomActivity.start(
                context = this,
                arguments = ChatRoomActivity.Arguments(chatRoom)
        )
    }

    companion object {

        fun start(context: Context) {
            context.startActivity(
                    Intent(context, ChatListActivity::class.java)
            )
        }
    }
}