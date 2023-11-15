package com.example.tugas11retrofit

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.tugas11retrofit.model.DataItem


class NewsAdapter(val dataNews: List<DataItem>): RecyclerView.Adapter<NewsAdapter.MyViewHolder>() {

    fun setData(newData: List<DataItem?>) {
        val dataNews = newData
        notifyDataSetChanged()
    }
    class MyViewHolder(view: View): RecyclerView.ViewHolder(view) {
        val imgNews = view.findViewById<ImageView>(R.id.img_item_photo)
        val nameNews = view.findViewById<TextView>(R.id.tv_item_name)
        val tanggalNews = view.findViewById<TextView>(R.id.tv_item_tanggal)
        val judulNews = view.findViewById<TextView>(R.id.tv_item_judul)
        val descNews = view.findViewById<TextView>(R.id.tv_item_description)
        val authorNews = view.findViewById<TextView>(R.id.tv_item_author)
        val categoryNews = view.findViewById<TextView>(R.id.tv_item_category)
    }



    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_news, parent, false)
        return MyViewHolder(view)
    }

    override fun getItemCount(): Int {
        if (dataNews != null) {
            return dataNews.size
        }
        return 0
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.nameNews.text = dataNews?.get(position)?.source
        holder.tanggalNews.text = dataNews?.get(position)?.publishedAt
        holder.judulNews.text = dataNews?.get(position)?.title
        holder.descNews.text = dataNews?.get(position)?.description
        holder.authorNews.text = dataNews?.get(position)?.author.toString()
        holder.categoryNews.text = dataNews?.get(position)?.category

        Glide.with(holder.imgNews)
            .load(dataNews?.get(position)?.image)
            .error(R.drawable.ic_launcher_background)
            .into(holder.imgNews)

        holder.itemView.setOnClickListener{
            val name = dataNews?.get(position)?.source
            Toast.makeText(holder.itemView.context, "${name}", Toast.LENGTH_SHORT).show()
        }

    }
}