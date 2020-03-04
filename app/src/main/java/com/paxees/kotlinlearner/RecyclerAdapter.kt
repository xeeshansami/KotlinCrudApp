package com.paxees.kotlinlearner

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView


class RecyclerAdapter(val context: Context, val array: ArrayList<mForm>) :
    RecyclerView.Adapter<RecyclerAdapter.RecyclerViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerViewHolder {
        val inflater = LayoutInflater.from(context)
        return RecyclerViewHolder(inflater, parent)
    }

    override fun getItemCount(): Int {
        return array.size
    }

    override fun onBindViewHolder(holder: RecyclerViewHolder, position: Int) {
        val movie: mForm = array[position]
        holder.bind(movie)
    }

    class RecyclerViewHolder(inflater: LayoutInflater, parent: ViewGroup) :
        RecyclerView.ViewHolder(inflater.inflate(R.layout.list_item, parent, false)) {
        private var mID: TextView? = null
        private var mName: TextView? = null
        private var mNumber: TextView? = null


        init {
            mID = itemView.findViewById(R.id.id)
            mName = itemView.findViewById(R.id.name)
            mNumber = itemView.findViewById(R.id.number)
        }

        fun bind(movie: mForm) {
            mID?.text = movie.id
            mName?.text = movie.name
            mNumber?.text = movie.number
        }

    }

}