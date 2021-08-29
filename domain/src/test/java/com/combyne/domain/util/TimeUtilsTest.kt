package com.combyne.domain.util

import com.google.common.truth.Truth.assertThat
import org.junit.Test
import java.time.ZonedDateTime

class TimeUtilsTest {

    private val dateStr = "2021-08-11T22:00:00.000Z"
    private val zonedDateTime: ZonedDateTime = ZonedDateTime.parse("2021-08-11T22:00:00.000Z")
    private val formattedDateStr = "11 Aug 2021"


    @Test
    fun givenString_returnsDate() {
        val output = TimeUtils.stringToDate(
            dateStr
        )
        assertThat(output).isEqualTo(
            zonedDateTime
        )
    }

    @Test
    fun givenZonedDateTime_returnsFormattedString() {
        val output = TimeUtils.dateToString(
            zonedDateTime
        )
        assertThat(output).isEqualTo(
            formattedDateStr
        )
    }

}