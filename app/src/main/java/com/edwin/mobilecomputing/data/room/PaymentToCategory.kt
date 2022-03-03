package com.edwin.mobilecomputing.data.room

import androidx.room.Embedded
import androidx.room.Ignore
import androidx.room.Relation
import com.edwin.mobilecomputing.data.entity.Category
import com.edwin.mobilecomputing.data.entity.Payment
import java.util.*

class PaymentToCategory {
    @Embedded
    lateinit var payment: Payment

    @Relation(parentColumn = "category_id", entityColumn = "id")
    lateinit var categories: List<Category>

    @get:Ignore
    val category: Category
        get() = categories[0]

    /**
     * Allow this class to be destructured by consumers
     */
    operator fun component1() = payment
    operator fun component2() = category

    override fun equals(other: Any?): Boolean = when {
        other === this -> true
        other is PaymentToCategory -> payment == other.payment && categories == other.categories
        else -> false
    }

    override fun hashCode(): Int = Objects.hash(payment, categories)
}