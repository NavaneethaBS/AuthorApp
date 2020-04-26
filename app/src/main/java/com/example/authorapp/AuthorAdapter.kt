package com.example.authorapp

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.activity_author_detail.view.author_id
import kotlinx.android.synthetic.main.activity_author_detail.view.imageView1
import kotlinx.android.synthetic.main.author_list.view.*

class AuthorAdapter(val items: List<AuthorModelClass>, val context: Context, val mItemClickListener: (Int, List<AuthorModelClass>) -> Unit) : RecyclerView.Adapter<AuthorAdapter.ViewHolder>() {
    interface ItemClickListener {
        fun onItemClick(position: Int)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val stringview = LayoutInflater.from(context).inflate(R.layout.author_list, parent, false)
        val stringviewholder = ViewHolder(stringview)
        stringview.setOnClickListener {
            mItemClickListener.invoke(stringviewholder.adapterPosition , items)
        }
        return stringviewholder
    }

    override fun getItemCount(): Int {
        return items.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val modelclass = items[position]
        holder.author?.text = items[position].author
        holder.author_id?.text=items[position].id
        holder.height?.text = items[position].height
        holder.width?.text = items[position].width
        Glide.with(holder.itemView.context)
            .load(modelclass.download_url)
            .into(holder.itemView.imageView1)
    }

    inner class ViewHolder(itemview: View) : RecyclerView.ViewHolder(itemview) {
        val author = itemview.author
        val author_id=itemview.author_id
        val height=itemview.height1
        val width=itemview.width1
        val imageView=itemView.imageView1
    }
}