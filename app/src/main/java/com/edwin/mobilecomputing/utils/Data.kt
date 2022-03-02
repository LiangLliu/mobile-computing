package com.edwin.mobilecomputing.utils

import java.text.SimpleDateFormat
import java.util.*

fun Date.formatToString(): String {
    return SimpleDateFormat("MMMM dd, yyyy", Locale.getDefault()).format(this)
}

fun Long.toDateString(): String {
    return SimpleDateFormat("MMMM dd, yyyy", Locale.getDefault()).format(Date(this))
}
