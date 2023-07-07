package com.nodes.aimit.utils

import androidx.compose.runtime.ProvidableCompositionLocal
import java.time.LocalDate
import java.time.format.DateTimeFormatter
import java.time.format.FormatStyle
import java.util.Locale

class StringUtils {
    companion object {
        fun getFormattedDate(date: LocalDate, locale: ProvidableCompositionLocal<Locale>): String {
            return DateTimeFormatter.ofLocalizedDate(FormatStyle.MEDIUM)
                .withLocale(Locale.getDefault()).format(date)
        }
    }
}