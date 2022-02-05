package com.example.shoppinglist.data.repositories

import com.example.shoppinglist.data.db.ShoppingDb
import com.example.shoppinglist.data.db.entities.ShoppingItem

class ShoppingRepository(
    private val db: ShoppingDb
) {
    suspend fun insert(item: ShoppingItem) = db.getShoppingDao().insert(item)

    suspend fun delete(item: ShoppingItem) = db.getShoppingDao().delete(item)

    suspend fun getAll() = db.getShoppingDao().getAll()
}