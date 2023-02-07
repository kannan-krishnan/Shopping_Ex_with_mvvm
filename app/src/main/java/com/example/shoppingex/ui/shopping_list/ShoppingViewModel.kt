package com.example.shoppingex.ui.shopping_list

import androidx.lifecycle.ViewModel
import com.example.shoppingex.dao.ShoppingItems
import com.example.shoppingex.repo.ShoppingRepo
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

/**
 * Created by #kannanpvm007 on  06/02/23.
 */

class ShoppingViewModel(
    private val repo: ShoppingRepo
) : ViewModel() {

    fun insert(items: ShoppingItems) = CoroutineScope(Dispatchers.Main).launch {repo.insert(items)}

    fun delete(items: ShoppingItems) = CoroutineScope(Dispatchers.Main).launch { repo.delete(items) }

    fun getAllItems()=repo.getAllShoppingItems()
}