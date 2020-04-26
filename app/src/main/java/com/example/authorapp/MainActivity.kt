package com.example.authorapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Gravity
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import com.example.authorapp.R
import com.google.android.gms.auth.api.signin.GoogleSignInOptions
import com.google.android.gms.tasks.OnCompleteListener
import com.google.firebase.auth.FirebaseAuth

class MainActivity : AppCompatActivity() {

    val mAuth = FirebaseAuth.getInstance()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var btnSubmit = findViewById<Button>(R.id.btnSubmit)
        var registerUser = findViewById<TextView>(R.id.register)
        var guestUser = findViewById<TextView>(R.id.guestUser)
        var email = findViewById<EditText>(R.id.e_mail)
        var password = findViewById<EditText>(R.id.password)

        btnSubmit.setOnClickListener()
        {
            var email_text = email.text.toString()
            val pass = password.text.toString()
            if (!email_text.isEmpty() && !pass.isEmpty()) {
                mAuth.signInWithEmailAndPassword(email_text, pass)
                    .addOnCompleteListener(this, OnCompleteListener { task ->
                        if (task.isSuccessful) {
                            intent = Intent(applicationContext, AuthorListActivity::class.java)
                            startActivity(intent)
                            Toast.makeText(this, "Loggedin successfully", Toast.LENGTH_SHORT).show()
                        } else {
                            Toast.makeText(this, "Incorrect Email or Password", Toast.LENGTH_SHORT)
                                .show()
                        }
                    })
            } else {
                Toast.makeText(this, "Please fill credentials", Toast.LENGTH_SHORT).show()
            }
        }
        registerUser.setOnClickListener() {
            intent = Intent(applicationContext, RegistrationPage::class.java)
            startActivity(intent)
        }
        guestUser.setOnClickListener() {
            intent = Intent(applicationContext, AuthorListActivity::class.java)
            startActivity(intent)
        }
    }
}



