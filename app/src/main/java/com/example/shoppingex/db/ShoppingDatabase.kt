package com.example.shoppingex.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.shoppingex.dao.ShoppingDao
import com.example.shoppingex.dao.ShoppingItems

/**
 * Created by #kannanpvm007 on  06/02/23.
 */
@Database(
    entities = [ShoppingItems::class],
    version = 1
)
abstract class ShoppingDatabase : RoomDatabase() {
    abstract fun getShoppingDao(): ShoppingDao

    companion object {

        @Volatile
        private var INSTANCE: ShoppingDatabase?=null

        private val lock= Any()

        /**
         * the  "operator  fun invoke" is execute ever instance crete ex: "val x= ShoppingDatabase()" this time this fun will call automatically
         */

        operator fun invoke(context: Context) = INSTANCE ?: synchronized(lock) {
            INSTANCE ?: creteDataBase(context).also{
                INSTANCE =it
            }
        }
        private fun creteDataBase(context: Context)= Room.databaseBuilder(context,
            ShoppingDatabase::class.java,"shopping_db").build()

    }
}