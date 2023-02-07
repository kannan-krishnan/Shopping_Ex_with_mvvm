package com.example.shoppingex.dao

import androidx.lifecycle.LiveData
import androidx.room.*

/**
 * Created by #kannanpvm007 on  06/02/23.
 */
@Dao
interface ShoppingDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(items: ShoppingItems)

    @Delete
    suspend  fun delete(items: ShoppingItems)

    @Query("SELECT * from shopping_items ")
    fun getAllShoppingItems():LiveData<List<ShoppingItems>>
}