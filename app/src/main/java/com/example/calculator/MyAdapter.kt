package com.example.calculator

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.RecyclerView

class MyAdapter(context: Context,private val items:List<MyData>): ArrayAdapter<MyData>(context,0,items) {


    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        var itemview = convertView
        val holder: ViewHolder

        if (convertView == null) {
            itemview = LayoutInflater.from(context).inflate(R.layout.item_list, parent, false)

            holder = ViewHolder()

            holder.img = itemview.findViewById(R.id.imageView)
            holder.text = itemview.findViewById(R.id.textView)

            itemview.tag = holder
        } else {
            holder = itemview?.tag as ViewHolder
        }

        val currentItem = items[position]
        holder.img.setImageResource(currentItem.image)
        holder.text.text = currentItem.title



        return itemview!!

    }

    private class ViewHolder{
        lateinit var text: TextView
        lateinit var img:ImageView
    }
}