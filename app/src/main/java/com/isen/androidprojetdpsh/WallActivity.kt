package com.isen.androidprojetdpsh

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_wall.*

class WallActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_wall)

        var posts : ArrayList<PostOnWall> = arrayListOf()

        // creation first fake post
        var testpost = PostOnWall("Test", "My first post", "https://image.freepik.com/photos-gratuite/image-recadree-bel-homme-barbu_171337-2897.jpg")

        posts.add(testpost)


        postRecyclerView.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        postRecyclerView.adapter = PostOnWallAdapter(posts)


    }
}
