package com.chibbis.i_network

import java.text.DateFormat
import java.text.SimpleDateFormat
import java.util.*

private const val SERVER_DATE_TIME_FORMAT = "yyyy-MM-dd'T'HH:mm:ss.SSS"

val dateTimeFormatter: DateFormat = SimpleDateFormat(SERVER_DATE_TIME_FORMAT, Locale.ENGLISH)

/**
 * Пытается расспарсить дату формата [SERVER_DATE_TIME_FORMAT], в случае успеха вернет дату, в случае неудачи - текущая дата
 */
fun tryParseLocalDateFromServer(date: String?): Date = runCatching {
    date?.let { dateTimeFormatter.parse(it) } ?: Date()
}.fold(
    onSuccess = { it },
    onFailure = { Date() }
)