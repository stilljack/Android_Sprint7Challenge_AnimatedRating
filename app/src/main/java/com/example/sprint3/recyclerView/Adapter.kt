package com.example.sprint3.recyclerView

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.example.sprint3.R
import com.example.sprint3.model.Items
import kotlinx.android.synthetic.main.list_layout.view.*


class Adapter(val list: MutableList<Items>) : RecyclerView.Adapter<Adapter.ViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val viewGroup = LayoutInflater.from(parent.context).inflate(R.layout.list_layout, parent, false)
        return ViewHolder(viewGroup)
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.nameTv.text = list[position].name
        //holder.imageIv.setImageDrawable(holder.imageIv.getContext().getDrawable(shoppingList[position].resourceId))

        val currentSelection = list[position]

        holder.parentView.setOnClickListener {view ->


        }

    }


    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val imageIv: ImageView = view.iv_item_drawable
        val nameTv: TextView = view.tv_item_name
        val parentView: LinearLayout = view.llcardview

   /*     fun bindModel(currentSelection: Items) {
            if (currentSelection.ordered) {
                parentView.setBackgroundColor(ContextCompat.getColor(parentView.context, R.color.bought))
            } else {
                parentView.setBackgroundColor(ContextCompat.getColor(parentView.context, R.color.unbought))
            }
        }*/
    }


}
