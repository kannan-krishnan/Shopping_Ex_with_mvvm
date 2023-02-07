package com.example.shoppingex.repo

import com.example.shoppingex.dao.ShoppingItems
import com.example.shoppingex.db.ShoppingDatabase

/**
 * Created by #kannanpvm007 on  06/02/23.
 */

class ShoppingRepo(
    private val db: ShoppingDatabase
) {

    suspend fun insert(items: ShoppingItems)=db.getShoppingDao().insert(items)

    suspend fun delete(items: ShoppingItems)=db.getShoppingDao().delete(items)

    fun getAllShoppingItems()=db.getShoppingDao().getAllShoppingItems()
}