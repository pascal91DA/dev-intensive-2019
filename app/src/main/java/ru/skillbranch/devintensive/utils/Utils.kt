package ru.skillbranch.devintensive.utils

object Utils {
    fun parseFullName(fullName: String?): Pair<String?, String?> {

        if(fullName == null || fullName == "" || fullName == " "){
            return "null" to "null"
        }

        val creds: List<String>? = fullName.split(" ")

        val firstName = creds?.getOrNull(0)
        val lastName = creds?.getOrNull(1)

        return firstName to lastName
    }

    fun toInitials(firstName: String?, lastName: String?): String? {
        return "${firstName.toString().get(0).toUpperCase()} ${lastName.toString().get(0).toUpperCase()}"
    }

    fun transliteration(payload: String?, divider: String? = " "): String? {

        /*
        "а": "a",
        "б": "b",
        "в": "v",
        "г": "g",
        "д": "d",
        "е": "e",
        "ё": "e",
        "ж": "zh",
        "з": "z",
        "и": "i",
        "й": "i",
        "к": "k",
        "л": "l",
        "м": "m",
        "н": "n",
        "о": "o",
        "п": "p",
        "р": "r",
        "с": "s",
        "т": "t",
        "у": "u",
        "ф": "f",
        "х": "h",
        "ц": "c",
        "ч": "ch",
        "ш": "sh",
        "щ": "sh'",
        "ъ": "",
        "ы": "i",
        "ь": "",
        "э": "e",
        "ю": "yu",
        "я": "ya",
        */

        return "Zhenya Stereotipov"
    }
}