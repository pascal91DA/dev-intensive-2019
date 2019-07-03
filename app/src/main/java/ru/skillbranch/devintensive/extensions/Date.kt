package ru.skillbranch.devintensive.extensions

import java.text.SimpleDateFormat
import java.util.*

const val SECOND = 1000L
const val MINUTE = 60 * SECOND
const val HOUR = 60 * MINUTE
const val DAY = 24 * HOUR

fun Date.format(format: String = "HH:mm:ss dd.MM.yy"): String {
    val dateFormat = SimpleDateFormat(format, Locale("ru"))
    return dateFormat.format(this)
}

fun Date.add(value: Int, units: TimeUnits = TimeUnits.SECOND): Date {

    var time = this.time

    time += when (units) {
        TimeUnits.SECOND -> value * SECOND
        TimeUnits.MINUTE -> value * MINUTE
        TimeUnits.HOUR -> value * HOUR
        TimeUnits.DAY -> value * DAY
    }

    this.time = time
    return this
}

enum class TimeUnits {
    SECOND,
    MINUTE,
    HOUR,
    DAY
}

fun Date.humanizeDiff(): String {

    val time = this.time

    val diff: Int = ((Date().time - time) / 1000).toInt()
    val result: String

    if(diff < 0){
        result = when (diff) {
            in 0..1 -> "только что"
            in 1..45 -> "через несколько секунд"
            in 45..75 -> "через минуту"
            in 75..45 * 60 -> "через N минут"
            in 45 * 60..75 * 60 -> "через час"
            in 75 * 60..22 * 60 * 60 -> "через N часов"
            in 22 * 60 * 60..26 * 60 * 60 -> "через день"
            in 26 * 60 * 60..360 * 60 * 60 * 31 -> "через N дней"
            else -> "через годы"
        }
    }else{
        result = when (diff) {
            in 0..1 -> "только что"
            in 1..45 -> "несколько секунд назад"
            in 45..75 -> "минуту назад"
            in 75..45 * 60 -> "N минут назад"
            in 45 * 60..75 * 60 -> "час назад"
            in 75 * 60..22 * 60 * 60 -> "N часов назад"
            in 22 * 60 * 60..26 * 60 * 60 -> "день назад"
            in 26 * 60 * 60..360 * 60 * 60 * 31 -> "N дней назад"
            else -> "более года назад"
        }
    }

    return result

    /*
    0с - 1с "только что"
    1с - 45с "несколько секунд назад"
    45с - 75с "минуту назад"
    75с - 45мин "N минут назад"
    45мин - 75мин "час назад"
    75мин 22ч "N часов назад"
    22ч - 26ч "день назад"
    26ч - 360д "N дней назад"
    >360д "более года назад"
    */
}