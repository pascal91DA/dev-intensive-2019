package ru.skillbranch.devintensive.utils

import ru.skillbranch.devintensive.models.Chat
import ru.skillbranch.devintensive.models.User
import java.util.*

abstract class BaseMessage(
    val id: String,
    val from: User?,
    val chat: Chat,
    val isIncoming: Boolean = false,
    val date: Date = Date()
) {


    companion object Factory {
        fun makeMessage(from: User, chat: Chat, date: Date, type: String, payload: String, isIncoming: Boolean = false){

        }
    }

    fun formatMessage(){

    }

}