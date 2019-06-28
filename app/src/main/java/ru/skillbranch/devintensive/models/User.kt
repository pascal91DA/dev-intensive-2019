package ru.skillbranch.devintensive.models

import java.util.*

class User(
    val id: String,
    var firstName: String?,
    var lastName: String?,
    var avatar: String?,
    var rating: Int = 0,
    var respect: Int = 0,
    var lastVisit: Date? = Date(),
    var isOnline: Boolean = false
) {

    companion object Factory {

        private var lastId: Int = -1

        fun makeUser(fullName: String?): User{

            lastId++

            val creds: List<String>? = fullName?.split(" ")

            val firstName = creds?.get(0)
            val lastName = creds?.get(1)

            return User(id = "$lastId", firstName = firstName, lastName = lastName, avatar = null)
        }
    }

    override fun toString(): String {
        return "User(id='$id', firstName=$firstName, lastName=$lastName, avatar=$avatar, rating=$rating, respect=$respect, lastVisit=$lastVisit, isOnline=$isOnline)"
    }


}