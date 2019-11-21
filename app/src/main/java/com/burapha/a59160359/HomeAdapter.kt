package com.burapha.a59160359

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView

class HomeAdapter: RecyclerView.Adapter<HomeAdapter.ViewHolder>() {

    var data =  listOf<Computer>()
        set(value) {
            field = value
            notifyDataSetChanged()
        }


    class ViewHolder(itemView: View):RecyclerView.ViewHolder(itemView) {
        val imageHolder: ImageView = itemView.findViewById(R.id.list_image)
        val textHolder: TextView = itemView.findViewById(R.id.list_title)
        fun bind(item: Computer) {
            textHolder.text = item.title
            imageHolder.setImageResource(when (item.id) {
                1 -> R.drawable.alpha
                2 -> R.drawable.aspire
                3 -> R.drawable.ej039t
                4 -> R.drawable.ej139t
                5 -> R.drawable.ej141t
                6 -> R.drawable.ej314t
                7 -> R.drawable.ideapad
                8 -> R.drawable.inspiron
                9 -> R.drawable.matebook
                10 -> R.drawable.xpro
                else -> R.drawable.ic_launcher_background
            })
            imageHolder.setOnClickListener {
                it.findNavController().navigate(
                    HomeFragmentDirections.actionHomeFragmentToDetailFragment(item.id)
                )
                Log.i("itemdetail","item id = ${item.id}")
            }
        }


        companion object {
            fun from(parent: ViewGroup): ViewHolder {
                val layoutInflater = LayoutInflater.from(parent.context)
                val view = layoutInflater
                    .inflate(R.layout.item_list, parent, false)
                return ViewHolder(view)
            }
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder.from(parent)
    }

    override fun getItemCount(): Int = data.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = data[position]
        holder.bind(item)
    }

}