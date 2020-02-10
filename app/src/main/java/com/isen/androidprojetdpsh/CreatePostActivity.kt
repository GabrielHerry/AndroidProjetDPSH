package com.isen.androidprojetdpsh

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import com.google.firebase.database.*
import kotlinx.android.synthetic.main.activity_create_post.*

class CreatePostActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_create_post)

        val intent1 = Intent(this, WallActivity::class.java)

        saveButton.setOnClickListener {
            startActivity(intent1)

            GlobalsVar.numberOfPost++
            // creer un post !
            var newPost = PostOnWall(editTitle.text.toString(),editDescription.text.toString(),editPicture.text.toString(),GlobalsVar.numberOfPost)
            GlobalsVar.postsOnPhone?.add(newPost)
            saveOnCloud (GlobalsVar.postsOnPhone)
        }


        testButton.setOnClickListener {
            var testpost = PostOnWall("Test", "My first post", "https://image.freepik.com/photos-gratuite/image-recadree-bel-homme-barbu_171337-2897.jpg",0)
            GlobalsVar.postsOnPhone?.add(testpost)
            startActivity(intent1)
        }

    }


    fun saveOnCloud (posts : ArrayList<PostOnWall>?  ) {
        // [START write_message]
        // Write a message to the database
       // val database = FirebaseDatabase.getInstance()
       // val myRef = database.getReference("posts")
        //myRef.child("posts").setValue(posts)
        //database.child("users").child(userId).setValue(user)

        var database: DatabaseReference
        database = FirebaseDatabase.getInstance().reference

        database.child("posts").setValue(posts)




        // [END write_message]   newPost.id.toString(

    }



}
