package com.rameda.miajudaapagar.ui.Login

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.rameda.miajudaapagar.R

class LoginActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        supportActionBar?.hide()

    }
}