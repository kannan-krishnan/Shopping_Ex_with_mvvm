package com.example.shoppingex.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.shoppingex.R
import com.example.shoppingex.dao.ShoppingItems
import com.example.shoppingex.db.ShoppingDatabase
import com.example.shoppingex.repo.ShoppingRepo
import com.example.shoppingex.ui.other.AddDigListener
import com.example.shoppingex.ui.other.ShoppingItemAdapter
import com.example.shoppingex.ui.shopping_list.AddShoppingItemDialog
import com.example.shoppingex.ui.shopping_list.ShoppingViewModel
import com.example.shoppingex.ui.shopping_list.ShoppingViewModelFactory
import kotlinx.android.synthetic.main.activity_shopping.*

class ShoppingActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_shopping)
        val database= ShoppingDatabase(this)
        val repo=ShoppingRepo(database)
        val factory=ShoppingViewModelFactory(repo)
    val viewModel= ViewModelProvider(this,factory)[ShoppingViewModel::class.java]

        val adapter1= ShoppingItemAdapter(listOf(),viewModel)
        rvShopping.apply {
            layoutManager=           LinearLayoutManager(this@ShoppingActivity)
            adapter=adapter1
            viewModel.getAllItems().observe(this@ShoppingActivity, Observer {
                adapter1.items=it
                adapter1.notifyDataSetChanged()
            })
        }
        add_fab.setOnClickListener {
            AddShoppingItemDialog(this,object :AddDigListener{
                override fun onAddButtonClick(items: ShoppingItems) {
                     viewModel.insert(items)
                }

            }).show()
        }


    }
}