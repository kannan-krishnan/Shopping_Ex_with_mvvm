package com.example.shoppingex.ui.shopping_list

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.shoppingex.repo.ShoppingRepo

/**
 * Created by #kannanpvm007 on  06/02/23.
 */
@Suppress("UNCHECKED_CAST")
class ShoppingViewModelFactory(
    private val repo: ShoppingRepo
) : ViewModelProvider.NewInstanceFactory() {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return ShoppingViewModel(repo) as T
    }
}