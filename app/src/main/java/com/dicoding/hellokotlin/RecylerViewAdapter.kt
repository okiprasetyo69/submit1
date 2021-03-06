package com.dicoding.hellokotlin

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.bumptech.glide.Glide
import com.dicoding.hellokotlin.R.layout.item_list
import kotlinx.android.synthetic.main.item_list.view.*


class RecyclerViewAdapter(private val context: Context, private val items: List<Item>, private val listener: (Item) -> Unit)
    : RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
            ViewHolder(LayoutInflater.from(context).inflate(item_list, parent, false))

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bindItem(items[position], listener)
    }

    override fun getItemCount(): Int = items.size

    class ViewHolder(val view: View) : RecyclerView.ViewHolder(view){
        fun bindItem(item: Item, listener: (Item) -> Unit) {
            itemView.name.text = item.name
            Glide.with(itemView.context).load(item.image).into(itemView.image)
           itemView.setOnClickListener { listener(item) }
        }
    }
}