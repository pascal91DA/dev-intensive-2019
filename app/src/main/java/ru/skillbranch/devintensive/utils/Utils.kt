package ru.skillbranch.devintensive.utils

object Utils {
    fun parseFullName(fullName: String?): Pair<String?, String?> {

        val creds: List<String>? = fullName?.split(" ")

        val firstName = creds?.getOrNull(0)
        val lastName = creds?.getOrNull(1)

        return firstName to lastName
    }
}