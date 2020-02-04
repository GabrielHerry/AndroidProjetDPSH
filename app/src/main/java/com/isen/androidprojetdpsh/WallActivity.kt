package com.isen.androidprojetdpsh

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager

import kotlinx.android.synthetic.main.activity_wall.*

class WallActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_wall)

        postRecyclerView.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        postRecyclerView.adapter = PostOnWallAdapter(GlobalsVar.posts)

        val intent1 = Intent(this, CreatePostActivity::class.java)

        createPostButton.setOnClickListener {
            startActivity(intent1)
        }
    }
}
