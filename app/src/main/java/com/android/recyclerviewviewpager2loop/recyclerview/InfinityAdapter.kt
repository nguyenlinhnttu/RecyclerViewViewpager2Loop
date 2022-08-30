package com.android.recyclerviewviewpager2loop.recyclerview

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.android.recyclerviewviewpager2loop.R

/**
 * Created by NguyenLinh on 30,August,2022
 */
class InfinityAdapter(var itemClickListener : ItemClickListener) : RecyclerView.Adapter<InfinityAdapter.ViewHolder>() {

    companion object {
        const val numberItems = 10
    }

    class ViewHolder(var textView: TextView ) : RecyclerView.ViewHolder(textView)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val textView = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_demo, parent, false) as TextView
        return ViewHolder(textView)
    }

    override fun getItemCount(): Int {
        return numberItems * 2
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val realPosition = position % numberItems
        holder.textView.text = "$realPosition"
        holder.textView.setOnClickListener {
            itemClickListener.onPosition(realPosition)
        }
    }

    interface ItemClickListener{
        fun onPosition(position :Int)
    }
}