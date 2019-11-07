package com.rameda.miajudaapagar.ui.Login

import android.content.Intent
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import android.view.View
import android.widget.Toast
import com.google.android.gms.tasks.OnCompleteListener
import com.google.android.gms.tasks.Task
import com.google.firebase.auth.AuthResult
import com.google.firebase.auth.FirebaseAuth
import com.rameda.miajudaapagar.MainActivity
import kotlinx.android.synthetic.main.activity_sign_up.*
import androidx.core.content.ContextCompat.getSystemService
import android.icu.lang.UCharacter.GraphemeClusterBreak.T
import android.R



class ActivitySignUp : AppCompatActivity() {
    private var firebaseAuth: FirebaseAuth? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(com.rameda.miajudaapagar.R.layout.activity_sign_up)
        getWindow()?.setStatusBarColor(Color.BLACK)
        supportActionBar?.hide()
        sign_up_btn.setOnClickListener(View.OnClickListener {
            val confirmPass = et_confirm_pass.getText().toString()
            val email = et_username.getText().toString()
            val pass = et_pass.getText().toString()
            firebaseAuth = FirebaseAuth.getInstance()

            RegistrarConta(confirmPass, email, pass)
        })

    }
    private fun RegistrarConta(confirmPass: String, email: String, pass: String) {
        if (TextUtils.isEmpty(confirmPass)) {
            Toast.makeText(this, "Confirme Sua Senha ", Toast.LENGTH_LONG)
                .show()
        }
        if (confirmPass!=pass){
            Toast.makeText(this, "Senhas Diferentes ", Toast.LENGTH_LONG)
                .show()
        }
        if (TextUtils.isEmpty(email)) {
            Toast.makeText(this, "Por Favor Digite seu Email", Toast.LENGTH_LONG).show()
        }
        if (TextUtils.isEmpty(pass)) {
            Toast.makeText(this, "Por Favor Digite seu Password", Toast.LENGTH_LONG).show()
        } else {
           /* this.firebaseAuth?.createUserWithEmailAndPassword(email, pass)?.addOnCompleteListener { task: Task<AuthResult> ->
                if (task.isSuccessful) {
                    //Registration OK
                    val firebaseUser = this.firebaseAuth?.currentUser!!
                } else {
                    Toast.makeText(this, "Perro", Toast.LENGTH_LONG).show()
                }
            }*/
            this.firebaseAuth?.createUserWithEmailAndPassword(email, pass)
                ?.addOnCompleteListener{ task ->
                    if (task.isSuccessful) {
                        val mainIntent = Intent(this, MainActivity::class.java)
                        mainIntent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK)
                        startActivity(mainIntent)
                        finish()

                    } else {
                        Toast.makeText(this, "Error", Toast.LENGTH_SHORT).show()
                    }
                }

        }
    }
}
