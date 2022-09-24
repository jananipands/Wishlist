package com.example.wishlist

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.Adapter
import org.w3c.dom.Text


class WishlistAdapter(private val wishlistItems : ArrayList<Item>) : RecyclerView.Adapter<WishlistAdapter.ViewHolder>(){

    inner class ViewHolder(itemView : View) : RecyclerView.ViewHolder(itemView){
        val nameTextView: TextView
        val priceTextView: TextView
        val urlTextView: TextView

        init {
            nameTextView = itemView.findViewById(R.id.nameTextView)
            priceTextView = itemView.findViewById(R.id.priceTextView)
            urlTextView = itemView.findViewById(R.id.urlTextView)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): WishlistAdapter.ViewHolder {
        val context = parent.context
        val inflater = LayoutInflater.from(context)

        val itemsView = inflater.inflate(R.layout.item_layout, parent, false)

        return ViewHolder(itemsView)
    }

    override fun onBindViewHolder(holder: WishlistAdapter.ViewHolder, position: Int) {
        val item = wishlistItems[position]

        holder.nameTextView.text = item.name
        holder.priceTextView.text = item.price.toString()
        holder.urlTextView.text = item.url

    }

    override fun getItemCount(): Int {
        return wishlistItems.size
    }



}