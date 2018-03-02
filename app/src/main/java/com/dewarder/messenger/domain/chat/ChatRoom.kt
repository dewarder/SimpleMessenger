package com.dewarder.messenger.domain.chat

import android.os.Parcelable
import com.dewarder.messenger.base.FirebaseModel
import kotlinx.android.parcel.Parcelize

@Parcelize
@FirebaseModel
data class ChatRoom(
        val id: String,
        val name: String
) : Parcelable