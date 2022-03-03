package com.edwin.mobilecomputing.data.repository

import com.edwin.mobilecomputing.data.entity.Payment
import com.edwin.mobilecomputing.data.room.PaymentDao
import com.edwin.mobilecomputing.data.room.PaymentToCategory
import kotlinx.coroutines.flow.Flow

/**
 * A data repository for [Payment] instances
 */
class PaymentRepository(
    private val paymentDao: PaymentDao
) {

    /**
     * Returns a flow containing the list of payments associated with the category with the
     * given [id]
     */
    fun paymentsInCategory(id: Long): Flow<List<PaymentToCategory>> {
        return paymentDao.paymentsFromCategory(id)
    }

    /**
     * Add a new [Payment] to the payment store
     */
    suspend fun addPayment(payment: Payment) = paymentDao.insert(payment)

}