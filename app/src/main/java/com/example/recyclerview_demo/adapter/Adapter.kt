package com.example.recyclerview_demo.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.recyclerview_demo.R
import com.example.recyclerview_demo.models.President
import kotlinx.android.synthetic.main.list_item.view.*

class Adapter(private val listener: OnItemClickListener) :
    RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    //1. declare data set we want to display
    private var items: List<President> = ArrayList()


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return PresidentViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.list_item, parent, false)
        )
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        when (holder) {
            is PresidentViewHolder -> {
                holder.bind(items[position])
            }
        }
    }

    override fun getItemCount(): Int {
        return items.size
    }

    fun submitList(president: List<President>) {
        items = president
    }

    interface OnItemClickListener {
        fun onItemClick(position: Int)
    }

    //2.Create view holder to take the data from data set and set it to view holder
    inner class PresidentViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView),
        View.OnClickListener {
        private val presidentName: TextView = itemView.tv_title
        private val presidentDesc: TextView = itemView.tv_desc
        private val presidentBorn: TextView = itemView.tv_born
        private val presidentDied: TextView = itemView.tv_died

        init {
            itemView.setOnClickListener(this)
        }

        fun bind(president: President) {
            presidentName.text = president.fullname
            presidentDesc.text = president.WhatManyThPresident
            presidentBorn.text = president.born.toString()
            presidentDied.text = president.died.toString()

        }

        override fun onClick(view: View?) {
            val position: Int = adapterPosition
            if (position != RecyclerView.NO_POSITION) {
                listener.onItemClick(position)
            }
        }
    }
}