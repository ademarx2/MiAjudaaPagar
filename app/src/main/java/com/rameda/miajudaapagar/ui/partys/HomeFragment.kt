package com.rameda.miajudaapagar.ui.partys

import android.content.Context
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener
import com.rameda.miajudaapagar.Adapter.AdapterRecyclerParty
import com.rameda.miajudaapagar.R
import kotlinx.android.synthetic.main.row_party_list.*

class HomeFragment : Fragment() {
    private lateinit var mRecyclerTaskList: RecyclerView
    private lateinit var homeViewModel: HomeViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?): View? {
        homeViewModel =
            ViewModelProviders.of(this).get(HomeViewModel::class.java)
        val root = inflater.inflate(R.layout.fragment_home, container, false)
        homeViewModel.text.observe(this, Observer {
        })

        //1 obter elemento
        mRecyclerTaskList = root.findViewById(R.id.recyclerParty)

        //2 obter um adapter
        mRecyclerTaskList.adapter = AdapterRecyclerParty()

        //3 definir um layout
        mRecyclerTaskList.layoutManager = LinearLayoutManager(context)
        firebasemethod()

        return root
    }
    fun firebasemethod(){

        val database = FirebaseDatabase.getInstance()
        val myRef = database.getReference("Group")
        var a = 0
        a=a+1
        val myRef2 = database.getReference("Status")
        myRef2.setValue("ativo")
        myRef.addValueEventListener(object : ValueEventListener {
            override fun onDataChange(dataSnapshot: DataSnapshot) {
                // This method is called once with the initial value and again
                // whenever data at this location is updated.
                val value = dataSnapshot.getValue(String::class.java)
                Log.d("opa", "Value is: " + value!!)
                status_participation?.text = value.toString()
                status_tv?.text = value.toString()
                if (value.toInt()<=4){
                    myRef.setValue(a.toString())
                }
                else{
               //     Toast.makeText(Context,"PARTY FULL", Toast.LENGTH_LONG).show()
                }
            }

            override fun onCancelled(error: DatabaseError) {
                // Failed to read value
                Log.w("opa", "Failed to read value.", error.toException())
            }
        })


    }


}