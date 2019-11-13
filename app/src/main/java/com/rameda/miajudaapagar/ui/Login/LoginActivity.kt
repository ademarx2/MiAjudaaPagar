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
import kotlinx.android.synthetic.main.activity_login.angry_btn
import kotlinx.android.synthetic.main.row_party_list.*
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.Retrofit
import androidx.core.app.ComponentActivity.ExtraData
import androidx.core.content.ContextCompat.getSystemService
import android.icu.lang.UCharacter.GraphemeClusterBreak.T




class LoginActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        getWindow()?.setStatusBarColor(Color.BLACK)

        setContentView(com.rameda.miajudaapagar.R.layout.activity_login)
        supportActionBar?.hide()
        val retrofit = Retrofit.Builder()
            .baseUrl("https://miajuda-a-pagar.firebaseio.com/")//url of firebase app
            .addConverterFactory(GsonConverterFactory.create())//use for convert JSON file into object
            .build()
        angry_btn.setOnClickListener {
         startActivity(Intent(this,MainActivity::class.java))
            // Write a message to the database
        }
    }

    fun onDataCharge(dataSnapShot:DataSnapshot){
        var map = mapOf<String,String>()
        map = dataSnapShot.getValue() as Map<String, String>

        val Status = map.get("lotado")
        val NumPart = map.get("2")


    }
}
