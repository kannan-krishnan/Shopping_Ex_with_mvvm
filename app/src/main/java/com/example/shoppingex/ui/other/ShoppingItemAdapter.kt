package com.example.shoppingex.ui.other

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.shoppingex.R
import com.example.shoppingex.dao.ShoppingItems
import com.example.shoppingex.ui.shopping_list.ShoppingViewModel
import kotlinx.android.synthetic.main.shopping_layout.view.*

/**
 * Created by #kannanpvm007 on  06/02/23.
 */
class ShoppingItemAdapter(
    var items: List<ShoppingItems>,
    private val viewModel: ShoppingViewModel
) : RecyclerView.Adapter<ShoppingItemAdapter.ShoppingViewHolder>() {
    inner class ShoppingViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ShoppingViewHolder {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.shopping_layout, parent, false)
        return ShoppingViewHolder(view)
    }

    override fun onBindViewHolder(holder: ShoppingViewHolder, position: Int) {
        val shoppingItemDetails = items[position]

        holder.itemView.nv_name.text = shoppingItemDetails.name
        holder.itemView.tv_amount.text = shoppingItemDetails.amount.toString()
        holder.itemView.delete.setOnClickListener {
            viewModel.delete(shoppingItemDetails)
        }
        holder.itemView.add.setOnClickListener {
            shoppingItemDetails.amount++
            viewModel.insert(shoppingItemDetails)
        }
        holder.itemView.minis.setOnClickListener {
            if (shoppingItemDetails.amount > 0) {
                shoppingItemDetails.amount--
                viewModel.insert(shoppingItemDetails)
            }
        }
    }

    override fun getItemCount(): Int {
        return items.size
    }
}