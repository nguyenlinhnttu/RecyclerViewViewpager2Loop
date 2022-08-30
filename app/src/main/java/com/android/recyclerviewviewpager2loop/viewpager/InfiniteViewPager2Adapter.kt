package com.android.recyclerviewviewpager2loop.viewpager

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.android.recyclerviewviewpager2loop.R

class InfiniteViewPager2Adapter(itemListOriginal: List<String>) :
    RecyclerView.Adapter<InfiniteViewPager2Adapter.MyViewHolder>() {

    private val itemList: List<String> = listOf(itemListOriginal.last() + "-Faked") +
                itemListOriginal +
                listOf(itemListOriginal.first() + "-Faked")

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.list_item_viewpager, parent, false)
        return MyViewHolder(view)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.itemView.findViewById<TextView>(R.id.txt_label).text = itemList[position]
    }

    override fun getItemCount(): Int {
        return itemList.count()
    }

    class MyViewHolder(view: View) : RecyclerView.ViewHolder(view)
}
