package ru.skillbranch.devintensive.models

import ru.skillbranch.devintensive.utils.Utils
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

    constructor(id: String, firstName: String?, lastName: String?) : this(id, firstName, lastName, avatar = null)

    constructor(id: String) : this(id, firstName = "John", lastName = "Doe $id")

    companion object Factory {

        private var lastId: Int = -1

        fun makeUser(fullName: String?): User {

            lastId++

            val (firstName, lastName) = Utils.parseFullName(fullName)

            return User(id = "$lastId", firstName = firstName, lastName = lastName, avatar = null)
        }
    }

    class Builder {

        var bread: String? = null
            private set
        var condiments: String? = null
            private set
        var meat: String? = null
            private set
        var fish: String? = null
            private set

        fun bread(bread: String) = apply { this.bread = bread }
        fun condiments(condiments: String) = apply { this.condiments = condiments }
        fun meat(meat: String) = apply { this.meat = meat }
        fun fish(fish: String) = apply { this.fish = fish }
        fun build() = makeUser("TEST USER")
    }


    override fun toString(): String {
        return "User(id='$id', firstName=$firstName, lastName=$lastName, avatar=$avatar, rating=$rating, respect=$respect, lastVisit=$lastVisit, isOnline=$isOnline)"
    }


}