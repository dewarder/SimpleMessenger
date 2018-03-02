package com.dewarder.messenger.ui.chat.list

import android.support.v7.recyclerview.extensions.ListAdapter
import android.support.v7.util.DiffUtil
import android.view.ViewGroup
import com.dewarder.messenger.R
import com.dewarder.messenger.domain.chat.ChatRoom
import com.dewarder.messenger.util.android.inflateInto

class ChatRoomRecyclerAdapter(
        val onChatRoomClickListener: OnChatRoomClickListener
) : ListAdapter<ChatRoom, ChatRoomViewHolder>(DIFF_ITEM_CALLBACK) {

    interface OnChatRoomClickListener {
        fun onChatRoomClicked(chatRoom: ChatRoom)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
            ChatRoomViewHolder(parent.inflateInto(R.layout.item_chat_room))

    override fun onBindViewHolder(holder: ChatRoomViewHolder, position: Int) {
        val chatRoom = getItem(position)
        holder.bind(chatRoom)
        holder.itemView.setOnClickListener {
            onChatRoomClickListener.onChatRoomClicked(chatRoom)
        }
    }

    companion object {

        private val DIFF_ITEM_CALLBACK = DiffItemCallback()
    }

    private class DiffItemCallback : DiffUtil.ItemCallback<ChatRoom>() {

        override fun areItemsTheSame(old: ChatRoom, new: ChatRoom) = old.id == new.id

        override fun areContentsTheSame(old: ChatRoom, new: ChatRoom) = old == new
    }
}