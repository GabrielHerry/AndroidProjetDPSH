package com.isen.androidprojetdpsh

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_create_post.*

class CreatePostActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_create_post)

        val intent1 = Intent(this, WallActivity::class.java)

        saveButton.setOnClickListener {
            startActivity(intent1)

            // creer un post !
            var newPost = PostOnWall(editTitle.text.toString(),editDescription.text.toString(),editPicture.text.toString(),0)
            GlobalsVar.posts.add(newPost)
        }


        testButton.setOnClickListener {
            var testpost = PostOnWall("Test", "My first post", "https://image.freepik.com/photos-gratuite/image-recadree-bel-homme-barbu_171337-2897.jpg",0)
            GlobalsVar.posts.add(testpost)
            startActivity(intent1)
        }

    }



}
