package com.example.shoppingex.ui.shopping_list

import android.content.Context
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatDialog
import com.example.shoppingex.R
import com.example.shoppingex.dao.ShoppingItems
import com.example.shoppingex.ui.other.AddDigListener
import kotlinx.android.synthetic.main.add_shopping_item.*

/**
 * Created by #kannanpvm007 on  06/02/23.
 */
class AddShoppingItemDialog(context: Context, private val addDigListener: AddDigListener) :
    AppCompatDialog(context) {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.add_shopping_item)
        button.setOnClickListener {
            val nama = name.text.toString()
            val tv_amount = tv_amount1.text.toString()

            if (nama.isEmpty() || tv_amount.isEmpty()) {
                Toast.makeText(context, "please enter details", Toast.LENGTH_SHORT).show()

                return@setOnClickListener
            }

            val item = ShoppingItems(nama, tv_amount.toInt())
            addDigListener.onAddButtonClick(item)
            dismiss()
        }
        cancel.setOnClickListener {
            dismiss()
        }
    }
}