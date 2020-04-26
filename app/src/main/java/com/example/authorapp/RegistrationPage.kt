package com.example.authorapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.google.android.gms.tasks.OnCompleteListener
import com.google.firebase.auth.FirebaseAuth

class RegistrationPage : AppCompatActivity() {

    val mAuth = FirebaseAuth.getInstance()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_registration_page)

        var btnRegister = findViewById<Button>(R.id.registerBtn)
        var email = findViewById<EditText>(R.id.email)
        var password = findViewById<EditText>(R.id.pass)
        var username = findViewById<EditText>(R.id.username)

        btnRegister.setOnClickListener(){
            val emai_text = email.text.toString()
            val pass = password.text.toString()
            val user_name = username.text.toString()
            if(!emai_text.isEmpty() && !pass.isEmpty() && !user_name.isEmpty()){
                mAuth.createUserWithEmailAndPassword(emai_text,pass).addOnCompleteListener(this,
                    OnCompleteListener { task ->
                        if(task.isSuccessful){
                            Toast.makeText(this,"Registered Successfully",Toast.LENGTH_SHORT).show()
                            intent = Intent(applicationContext, MainActivity::class.java)
                            startActivity(intent)
                        }else{
                            Toast.makeText(this,"Unable to create an account",Toast.LENGTH_SHORT).show()
                        }
                    })
            }else{
                Toast.makeText(this,"Please enter the credentials",Toast.LENGTH_SHORT).show()
            }
        }
    }
}
