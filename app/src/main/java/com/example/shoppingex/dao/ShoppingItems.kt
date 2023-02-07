package com.example.shoppingex.dao

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

/**
 * Created by #kannanpvm007 on  06/02/23.
 */
@Entity(tableName = "shopping_items")
data class ShoppingItems(
    @ColumnInfo(name = "item_name") var name: String,
    @ColumnInfo(name = "item_amount") var amount: Int

) {
    @PrimaryKey(autoGenerate = true)
    var id: Int? = null
}