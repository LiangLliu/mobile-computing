package com.edwin.mobilecomputing.data.room

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import com.edwin.mobilecomputing.data.entity.Payment
import kotlinx.coroutines.flow.Flow

@Dao
abstract class PaymentDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    abstract suspend fun insert(payment: Payment): Long

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    abstract suspend fun insertAll(payments: Collection<Payment>)

    @Update(onConflict = OnConflictStrategy.REPLACE)
    abstract suspend fun update(payment: Payment)

    @Delete
    abstract suspend fun delete(payment: Payment): Int

    @Query(
        """
        SELECT payments.* FROM payments
        INNER JOIN categories ON payments.category_id = categories.id
        WHERE category_id = :categoryId
    """
    )
    abstract fun paymentsFromCategory(categoryId: Long): Flow<List<PaymentToCategory>>


    @Query(
        """
        SELECT * FROM payments WHERE id = :id
    """
    )
    abstract fun payment(id: Long): Payment?
}
