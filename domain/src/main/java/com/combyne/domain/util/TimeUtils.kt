package com.combyne.domain.util

import java.time.ZonedDateTime
import java.time.format.DateTimeFormatter

object TimeUtils {

    fun stringToDate(dateStr: String): ZonedDateTime {
        return ZonedDateTime.parse(dateStr)
    }

    fun dateToString(zonedDateTime: ZonedDateTime): String {
        return DateTimeFormatter.ofPattern("d MMM yyyy").format(zonedDateTime)
    }

    fun dateToFormat(zonedDateTime: ZonedDateTime, format: String): String {
        return DateTimeFormatter.ofPattern(format).format(zonedDateTime)
    }

}