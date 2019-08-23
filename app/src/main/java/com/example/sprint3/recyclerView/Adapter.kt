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
import com.example.sprint3.activities.MainActivity
import com.example.sprint3.fragments.RatingFragment
import com.example.sprint3.model.Items
import kotlinx.android.synthetic.main.list_layout.view.*
import androidx.appcompat.app.AppCompatActivity
import android.R
import android.os.Bundle


class Adapter(val list: MutableList<Items>) : RecyclerView.Adapter<Adapter.ViewHolder>() {/*
    internal var callback: OnRecyclerInterfaceListener? = null
  *//*  fun setOnRecyclerInterfaceListener(callback: OnRecyclerInterfaceListener) {
        this.callback = callback
    }*//*
*/
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val viewGroup = LayoutInflater.from(parent.context).inflate(com.example.sprint3.R.layout.list_layout, parent, false)
        return ViewHolder(viewGroup)
    }

    override fun getItemCount(): Int {
        return list.size
    }
/*   interface OnRecyclerInterfaceListener {
       fun onItemSelected(item:Items)
    }*/

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.nameTv.text = list[position].name
        holder.ratingTv.text=list[position].rating.toString()
        //holder.imageIv.setImageDrawable(holder.imageIv.getContext().getDrawable(shoppingList[position].resourceId))

        val currentSelection = list[position]

        holder.parentView.setOnClickListener {view ->
           /* callback?.onItemSelected(currentSelection)*/


        notifyItemChanged(position)
            val manager = (view.context as AppCompatActivity).supportFragmentManager
            val bundle = Bundle()
            bundle.putInt(MainActivity.ITEM_KEY, position)
            val fragment = RatingFragment()
            fragment.setArguments(bundle)
            manager.beginTransaction()
                .add(fragment, "first")
                .addToBackStack("thisbacko")
                .commit()
        }

    }


    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val nameTv: TextView = view.tv_item_name
        val ratingTv: TextView = view.tv_rating
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
