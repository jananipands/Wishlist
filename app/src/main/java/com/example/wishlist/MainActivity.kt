package com.example.wishlist

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.LinearLayout
import android.widget.RelativeLayout
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

lateinit var wishlistItems : ArrayList<Item>

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val wishListRv = findViewById<RecyclerView>(R.id.recyclerView)
        val submitButton = findViewById<Button>(R.id.submit)

        wishlistItems = ArrayList()

        val adapter = WishlistAdapter(wishlistItems)

        wishListRv.adapter = adapter

        wishListRv.layoutManager = LinearLayoutManager(this)


        submitButton.setOnClickListener {
            val name = findViewById<EditText>(R.id.nameText).text.toString()
            val price = findViewById<EditText>(R.id.priceText).text.toString().toDouble()
            val url = findViewById<EditText>(R.id.urlText).text.toString()

            val newItem = Item(name, url, price)
            wishlistItems.add(newItem)

            adapter.notifyItemInserted(wishlistItems.size - 1)

            findViewById<EditText>(R.id.nameText).text.clear()
            findViewById<EditText>(R.id.priceText).text.clear()
            findViewById<EditText>(R.id.urlText).text.clear()
        }

    }


}