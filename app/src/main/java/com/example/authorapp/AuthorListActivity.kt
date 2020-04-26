package com.example.authorapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_author_list.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class AuthorListActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_author_list)

        fetchAuthorData()
    }

    private fun fetchAuthorData() {
        AuthorApi()
            .getAuthorNames().enqueue(object : Callback<List<AuthorModelClass>> {
                override fun onFailure(call: Call<List<AuthorModelClass>>, t: Throwable) {
                    Toast.makeText(applicationContext, t.message, Toast.LENGTH_LONG).show()
                }
                override fun onResponse(call: Call<List<AuthorModelClass>>, response: Response<List<AuthorModelClass>>) {
                    val movies = response.body()
                    print(movies?.size)
                    movies?.let {
                        showdata(it)
                    }
                }
            })
    }

    private fun showdata(authorData:List<AuthorModelClass>): List<AuthorModelClass>
    {
        rc_view.layoutManager = LinearLayoutManager(this);
        rc_view.adapter = AuthorAdapter(
            authorData,
            this,
            this@AuthorListActivity::onItemClick
        )
        return  authorData
    }

    private fun onItemClick(position: Int, names:List<AuthorModelClass>) {
        intent = Intent(applicationContext, AuthorDetail:: class.java)
        intent.putExtra("id",names[position].id)
        intent.putExtra("author" , names[position].author)
        intent.putExtra("author",names[position].author)
        intent.putExtra("height",names[position].height)
        intent.putExtra("width",names[position].width)
        intent.putExtra("image",names[position].download_url)
        startActivity(intent)
    }
}
