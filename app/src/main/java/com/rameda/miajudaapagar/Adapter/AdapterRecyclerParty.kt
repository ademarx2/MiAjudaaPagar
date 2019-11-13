package com.rameda.miajudaapagar.Adapter

import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener
import com.rameda.miajudaapagar.R
import com.rameda.miajudaapagar.ViewHolder.TaskViewHolver
import kotlinx.android.synthetic.main.row_party_list.*
import java.util.zip.Inflater

class AdapterRecyclerParty : RecyclerView.Adapter<TaskViewHolver>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TaskViewHolver {
        val context = parent.context
        val inflater = LayoutInflater.from(context)
        val view = inflater.inflate(R.layout.row_party_list,parent,false)

        return TaskViewHolver(view)
    }

    override fun getItemCount(): Int {
        return 5
    }

    override fun onBindViewHolder(holder: TaskViewHolver, position: Int) {
        holder.itemView.setOnClickListener{Log.e("accept","top")}
    }

}

