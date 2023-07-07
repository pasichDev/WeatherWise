package com.pasichdev.weatherwise.utils

import java.text.SimpleDateFormat
import java.time.LocalDate
import java.time.format.DateTimeFormatter
import java.util.Date
import java.util.Locale

const val DATETIME_NETWORK_FORMAT = "yyyy-MM-dd HH:mm"
const val DATE_NETWORK_FORMAT = "yyyy-MM-dd"

fun convertToTime(dateStr: String): String {
    val date: Date =
        SimpleDateFormat(DATETIME_NETWORK_FORMAT, Locale.getDefault()).parse(dateStr) as Date
    return SimpleDateFormat("HH:mm", Locale.getDefault()).format(date)

}

fun getDataUser(): String {
    val currentDate = LocalDate.now()
    val formatter = DateTimeFormatter.ofPattern("EEEE, d MMMM", Locale.getDefault())
    return currentDate.format(formatter)
}

fun convertToHour(dateStr: String): Int {
    val date: Date =
        SimpleDateFormat(DATETIME_NETWORK_FORMAT, Locale.getDefault()).parse(dateStr) as Date
    return SimpleDateFormat("HH", Locale.getDefault()).format(date).toInt()
}

fun convertToDay(dateStr: String): Int {
    val date: Date =
        SimpleDateFormat(DATETIME_NETWORK_FORMAT, Locale.getDefault()).parse(dateStr) as Date
    return SimpleDateFormat("dd", Locale.getDefault()).format(date).toInt()
}

fun convertToSmallData(dateStr: String): String {
    val date: Date = SimpleDateFormat(DATE_NETWORK_FORMAT, Locale.getDefault()).parse(dateStr) as Date
    return SimpleDateFormat("dd.MM", Locale.getDefault()).format(date)
}

