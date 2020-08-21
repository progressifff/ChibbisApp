package com.chibbis.domain.app_rate

/**
 * Тип рейтинга приложения.
 *
 * @property starValue Рейтинг приложения в звёздах.
 */
enum class AppRate(val starValue: Int) {

    UNKNOWN(0),
    AWFUL(1),
    BAD(2),
    SATISFACTORY(3),
    GOOD(4),
    GREAT(5);

    val isPositive: Boolean get() = this.starValue > 3

    companion object {

        private val values = values()

        fun getByStarValue(starValue: Int) = values.firstOrNull { it.starValue == starValue }
            ?: UNKNOWN
    }
}