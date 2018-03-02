package com.dewarder.messenger.ui.chat.list

import android.support.v7.widget.RecyclerView
import android.view.View
import android.widget.TextView
import com.dewarder.messenger.R
import com.dewarder.messenger.domain.chat.ChatRoom

class ChatRoomViewHolder(view: View) : RecyclerView.ViewHolder(view) {

    private val name: TextView = view.findViewById(R.id.name)

    fun bind(chatRoom: ChatRoom) {
        name.text = chatRoom.name
    }
}