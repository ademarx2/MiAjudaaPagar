package com.rameda.miajudaapagar.ui.Login

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.rameda.miajudaapagar.MainActivity
import kotlinx.android.synthetic.main.activity_login.*
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import androidx.core.content.ContextCompat.getSystemService
import android.icu.lang.UCharacter.GraphemeClusterBreak.T
import android.R
import android.graphics.Color
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.ValueEventListener
import androidx.core.content.ContextCompat.getSystemService
import android.icu.lang.UCharacter.GraphemeClusterBreak.T
import android.util.Log
import android.widget.Toast


class LoginActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        getWindow()?.setStatusBarColor(Color.BLACK)

        setContentView(com.rameda.miajudaapagar.R.layout.activity_login)
        supportActionBar?.hide()
        var a = 0
        angry_btn.setOnClickListener {
         //startActivity(Intent(this,MainActivity::class.java))
            // Write a message to the database
            val database = FirebaseDatabase.getInstance()
            val myRef = database.getReference("Group")
            a=a+1
            val myRef2 = database.getReference("Status")
            myRef2.setValue("ativo")

            myRef.addValueEventListener(object : ValueEventListener {
                override fun onDataChange(dataSnapshot: DataSnapshot) {
                    // This method is called once with the initial value and again
                    // whenever data at this location is updated.
                    val value = dataSnapshot.getValue(String::class.java)
                    Log.d("opa", "Value is: " + value!!)
                    if (value.toInt()<=4){
                        myRef.setValue(a.toString())
                    }
                    else{
                        Toast.makeText(applicationContext,"PARTY FULL",Toast.LENGTH_LONG).show()
                    }
                }

                override fun onCancelled(error: DatabaseError) {
                    // Failed to read value
                    Log.w("opa", "Failed to read value.", error.toException())
                }
            })


        }
    }

    fun onDataCharge(dataSnapShot:DataSnapshot){
        var map = mapOf<String,String>()
        map = dataSnapShot.getValue() as Map<String, String>

        val Status = map.get("lotado")
        val NumPart = map.get("2")


    }
}
