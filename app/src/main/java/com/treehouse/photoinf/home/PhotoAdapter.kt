package com.treehouse.photoinf.home

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import com.squareup.picasso.Picasso
import com.treehouse.photoinf.R
import com.treehouse.photoinf.model.Result

class PhotoAdapter : RecyclerView.Adapter<PhotoAdapter.RanViewHolder>() {


    private val data = arrayListOf<Result>()

    fun setData(data: List<Result>) {
        this.data.clear()
        this.data.addAll(data)
        notifyDataSetChanged()
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RanViewHolder {

        val rootView = LayoutInflater.from(parent.context).inflate(R.layout.item_pass, parent, false)
        return RanViewHolder(rootView)
    }

    override fun getItemCount(): Int { return data.size }

    override fun onBindViewHolder(viewHolder: RanViewHolder, position: Int)
    { viewHolder.bind(data[position]) }

    class RanViewHolder(private val rootView: View) : RecyclerView.ViewHolder(rootView) {
        fun bind(data: Result) {

           val tvAIbum_id =rootView.findViewById<TextView>(R.id.tvAlbum_id)
            tvAIbum_id.text= data.id

            val tvTitle =rootView.findViewById<TextView>(R.id.tvTitle)
            tvTitle.text= data.title


            val ImageviewUrl = rootView.findViewById<View>(R.id.ImageviewUrl) as ImageView
            Picasso.with(rootView.context).load(data.url).into(ImageviewUrl)

            //Picasso.with(rootView.context).load("http://lorempixel.com/1024/768/abstract/?73143").into(ImageviewUrl)

            //val ImageviewUrl2 = rootView.findViewById<View>(R.id.ImageviewUrl2) as ImageView

        }
        }
}