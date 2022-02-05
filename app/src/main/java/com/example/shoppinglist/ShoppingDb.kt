package com.example.shoppinglist

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase


@Database(
    entities = [ShoppingItem::class],
    version = 1
)
abstract class ShoppingDb: RoomDatabase() {

    abstract fun getShoppingDao(): ShoppingDao

    companion object{
        @Volatile
        private var instance: ShoppingDb? = null
        private val LOCK = Any()


        operator fun invoke(context: Context) = instance ?: synchronized(LOCK){
            instance ?: createDb(context).also{ instance = it}
        }

        fun createDb(context: Context) =
            Room.databaseBuilder(context, ShoppingDb::class.java, "ShoppingDB.db").build()
    }

}