package ru.skillbranch.devintensive.utils

import ru.skillbranch.devintensive.models.Chat
import ru.skillbranch.devintensive.models.User
import java.util.*

class TextMessage(id: String, from: User?, chat: Chat, isIncoming: Boolean, date: Date) :
    BaseMessage(id, from, chat, isIncoming, date) {
}