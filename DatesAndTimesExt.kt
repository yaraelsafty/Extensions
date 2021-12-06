package com.appssquare.medtroopspartner.common.extensions
import android.os.Build
import androidx.annotation.RequiresApi
import java.text.SimpleDateFormat
import java.time.LocalDate
import java.time.LocalDateTime
import java.time.LocalTime
import java.time.format.DateTimeFormatter
import java.util.*

/**
 * Pattern: yyyy-MM-dd
 */
fun formatToServerDateDefaults(date: String): Date{
    val sdf= SimpleDateFormat("yyyy-MM-dd", Locale.getDefault())
    return sdf.parse(date)
}
/**
 * Pattern: dd/MM
 */
fun formatToServerDate(date: String): String{
    val dateObj = formatToServerDateDefaults(date)
    return SimpleDateFormat("dd/MM", Locale.getDefault()).format(dateObj)
}

/**
 * Pattern: dd/MM/yyyy
 */
fun formatToViewDateDefaults(date: String): String{
    val dateObj = formatToServerDateDefaults(date)
    return SimpleDateFormat("dd/MM/yyyy", Locale.getDefault()).format(dateObj)

}
/**
 *Compare Dates
 */
@RequiresApi(Build.VERSION_CODES.O)
fun compareDateWithToday(date :String): Int{
    var myDate = LocalDate.parse(date)
    val currentDate = LocalDate.parse(LocalDateTime.now().format(DateTimeFormatter.ISO_DATE))
    return when {
        myDate.isEqual(currentDate) -> {
            0
        }
        myDate.isAfter(currentDate) -> {
            myDate.dayOfMonth - currentDate.dayOfMonth
        }
        else -> {
            -1
        }
    }
}
/**
 *Times
 */
fun formatToViewTimeDefaults(time: String):Date{
    val sdf= SimpleDateFormat("HH:mm:ss", Locale.getDefault())
    return sdf.parse(time)
}
fun formatToViewTime(time: String): String{
    val dateObj = formatToViewTimeDefaults(time)
    return SimpleDateFormat("h:mm a", Locale.getDefault()).format(dateObj)
}

fun convertTo12Hour(time:String): String{
        val sdf = SimpleDateFormat("HH:mm", Locale.getDefault())
        val dateObj = sdf.parse(time)
        return SimpleDateFormat("h:mm a", Locale.getDefault()).format(dateObj)
}
@RequiresApi(Build.VERSION_CODES.O)
fun convertTimeToMillis(time: String): Long{
    var localTime : LocalTime = LocalTime.parse(time)
    return  (localTime.toSecondOfDay() * 1000).toLong()
}

