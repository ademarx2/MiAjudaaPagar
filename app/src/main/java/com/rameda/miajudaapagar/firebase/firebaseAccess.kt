package com.rameda.miajudaapagar.firebase

import android.content.Context
import android.util.Log
import android.widget.Toast
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener

class firebaseAccess {


    fun firebaseReadStatus(){
        val database = FirebaseDatabase.getInstance()

        val status = database.getReference("Status")
        status.setValue("ativo")
        status.addValueEventListener(object : ValueEventListener {
            override fun onDataChange(dataSnapshot: DataSnapshot) {
                // This method is called once with the initial value and again
                // whenever data at this location is updated.
                val value = dataSnapshot.getValue(String::class.java)
                Log.d("opa", "Value is: " + value!!)
            }

            override fun onCancelled(error: DatabaseError) {
                // Failed to read value
                Log.w("opa", "Failed to read value.", error.toException())
            }
        })




    }

    fun firebasemethodGroupSize(): String {
        var groupSize:String = ""
        val database = FirebaseDatabase.getInstance()
        val myRef = database.getReference("Group")
        var a = 0
        a = a + 1
        myRef.addValueEventListener(object : ValueEventListener {
            override fun onDataChange(dataSnapshot: DataSnapshot) {
                // This method is called once with the initial value and again
                // whenever data at this location is updated.
                val value = dataSnapshot.getValue(String::class.java)
                Log.d("opa", "Value is: " + value!!)
                if (value.toInt() <= 4) {
                    myRef.setValue(a.toString())
                    groupSize= a.toString()
                } else {
                       //  Toast.makeText(this,"PARTY FULL", Toast.LENGTH_LONG).show()
                }
            }

            override fun onCancelled(error: DatabaseError) {
                // Failed to read value
                Log.w("opa", "Failed to read value.", error.toException())
            }
        })

        return groupSize
    }
}