package com.rameda.miajudaapagar.Adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.rameda.miajudaapagar.R
import com.rameda.miajudaapagar.ViewHolder.TaskViewHolver
import java.util.zip.Inflater

class AdapterRecyclerParty : RecyclerView.Adapter<TaskViewHolver>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TaskViewHolver {
        val context = parent?.context
        val inflater = LayoutInflater.from(context)
        val view = inflater.inflate(R.layout.row_party_list,parent,false)
        return TaskViewHolver(view)
    }

    override fun getItemCount(): Int {
        return 2
    }

    override fun onBindViewHolder(holder: TaskViewHolver, position: Int) {
    }

}