package com.pardeep.todo_app

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class MyAdapter(var data: ArrayList<MyData>,
var crudInterface: CrudInterface) : RecyclerView.Adapter<MyAdapter.ViewHolder>() {
    class ViewHolder(var view: View) : RecyclerView.ViewHolder(view) {
        var title : TextView =view.findViewById(R.id.Title)
        var description : TextView =view.findViewById(R.id.Description)
        var update : Button =view.findViewById(R.id.Update)
        var delete : Button =view.findViewById(R.id.delete)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
       var view = LayoutInflater.from(parent.context).inflate(R.layout.single_design,parent,false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
     return data.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
      holder.title.setText(data[position].name)
      holder.description.setText(data[position].description)

        holder.update.setOnClickListener {
            crudInterface.update(position)
        }

        holder.delete.setOnClickListener {
            crudInterface.delete(position)
        }
    }

}
