package com.rameda.miajudaapagar.ui.Login

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.rameda.miajudaapagar.MainActivity
import kotlinx.android.synthetic.main.activity_login.*
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import androidx.core.app.ComponentActivity.ExtraData
import androidx.core.content.ContextCompat.getSystemService
import android.icu.lang.UCharacter.GraphemeClusterBreak.T
import android.R
import android.graphics.Color


class LoginActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        getWindow()?.setStatusBarColor(Color.BLACK)

        setContentView(com.rameda.miajudaapagar.R.layout.activity_login)
        supportActionBar?.hide()

        angry_btn.setOnClickListener {
         startActivity(Intent(this,MainActivity::class.java))
            // Write a message to the database
            val database = FirebaseDatabase.getInstance()
            val myRef = database.getReference("message")

            myRef.setValue("Hello, World!")

        }


    }
}
