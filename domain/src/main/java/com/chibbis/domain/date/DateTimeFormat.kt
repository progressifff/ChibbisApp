package com.chibbis.domain.date

import java.text.DateFormat

/**
 * Format of date
 */
enum class DateTimeFormat(val id: Int) {
    SHORT(DateFormat.SHORT),
    MEDIUM(DateFormat.MEDIUM),
    LONG(DateFormat.LONG),
    FULL(DateFormat.FULL)
}