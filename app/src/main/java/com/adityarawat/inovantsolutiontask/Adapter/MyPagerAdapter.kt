package com.adityarawat.inovantsolutiontask.Adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.adityarawat.inovantsolutiontask.R

class MyPagerAdapter(private val context : Context) : RecyclerView.Adapter<MyPagerAdapter.ViewHolder>() {
    private val images: List<Int> = listOf(
        R.drawable.eye
        )
    class ViewHolder(itemView : View): RecyclerView.ViewHolder(itemView) {
        val imageView: ImageView = itemView.findViewById(R.id.imageView)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.item_page, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return 20
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.imageView.setImageResource(images[0])
    }
}