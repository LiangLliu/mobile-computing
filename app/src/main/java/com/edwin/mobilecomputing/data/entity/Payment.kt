package com.edwin.mobilecomputing.data.entity

data class Payment(
    val paymentId: Long,
    val paymentTitle: String,
    val paymentDate: Long,
    val paymentCategoryId: Long
)