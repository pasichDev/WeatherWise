package com.pasichdev.weatherwise.utils

import java.text.SimpleDateFormat
import java.time.LocalDate
import java.time.LocalDateTime
import java.time.LocalTime
import java.time.format.DateTimeFormatter
import java.util.Date
import java.util.Locale

fun convertToNewFormat(dateStr: String): String {
    val currentFormatter = DateTimeFormatter.ISO_DATE_TIME
    val newFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss")
    val dateTime = LocalDateTime.parse(dateStr, currentFormatter)
    return dateTime.format(newFormatter)
}

fun convertToTime(dateStr: String): String {
    val date: Date = SimpleDateFormat("yyyy-MM-dd HH:mm", Locale.getDefault()).parse(dateStr) as Date
    return SimpleDateFormat("HH:mm", Locale.getDefault()).format(date)

}
 fun getDataUser():String{
    val currentDate = LocalDate.now()
    val formatter = DateTimeFormatter.ofPattern("EEEE, d MMMM",  Locale.getDefault())
    return currentDate.format(formatter)
}

fun convertToHour(dateStr: String): Int {
    val date: Date = SimpleDateFormat("yyyy-MM-dd HH:mm", Locale.getDefault()).parse(dateStr) as Date
    return SimpleDateFormat("HH", Locale.getDefault()).format(date).toInt()
}
fun convertToDay(dateStr: String): Int {
    val date: Date = SimpleDateFormat("yyyy-MM-dd HH:mm", Locale.getDefault()).parse(dateStr) as Date
    return SimpleDateFormat("dd", Locale.getDefault()).format(date).toInt()
}



fun getDataUserCheck():String{
    val currentDateTime = LocalDateTime.now()

    val formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm")
    val formattedDateTime = currentDateTime.format(formatter)
    return formattedDateTime
}