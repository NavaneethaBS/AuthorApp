package com.example.authorapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import com.bumptech.glide.Glide

class AuthorDetail : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_author_detail)
        val btnLogout = findViewById<Button>(R.id.logout)

        var intent = intent
        val id = intent.getStringExtra("id")
        val author = intent.getStringExtra("author")
        val height = intent.getStringExtra("height")
        val width = intent.getStringExtra("width")
        val image = intent.getStringExtra("image")

        val author_id = findViewById<TextView>(R.id.author_id)
        author_id.text = id.toString()
        val author_name = findViewById<TextView>(R.id.author_name)
        author_name.text = author.toString()
        val height3 = findViewById<TextView>(R.id.height2)
        height3.text = height.toString()
        val width3 = findViewById<TextView>(R.id.width2)
        width3.text = width.toString()
        val viewImage = findViewById<ImageView>(R.id.imageView1)
        Glide.with(this)
            .load(image)
            .into(viewImage)

        btnLogout.setOnClickListener(){
            intent = Intent(applicationContext, MainActivity::class.java)
            startActivity(intent)
        }
    }
}
