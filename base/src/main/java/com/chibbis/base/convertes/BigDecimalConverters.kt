package com.chibbis.base.convertes

import com.chibbis.base.mappers.nonNull
import java.math.BigDecimal

/**
 * Перевод строки в [BigDecimal]. При ошибке возвращается значение [BigDecimal.ZERO]
 *
 * @param value Значение для перевода
 *
 * @return [BigDecimal]
 */
fun safeConvertToBigDecimal(value: String?): BigDecimal =
    runCatching {
        BigDecimal(value.nonNull)
    }.fold(
        { it },
        { BigDecimal.ZERO }
    )