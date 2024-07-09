package com.pardeep.todo_app

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

class TodoRecycler(var item : ArrayList<TodoDataClass>) : RecyclerView.Adapter<TodoRecycler.ViewHolder>() {
    class ViewHolder(var view: View) : RecyclerView.ViewHolder(view) {

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
       var view = LayoutInflater.from(parent.context).inflate(R.layout.todo_item,parent,false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return item.size

    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

    }
}