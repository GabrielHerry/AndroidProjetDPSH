package com.isen.androidprojetdpsh

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.isen.androidprojetdpsh.GlobalsVar.Companion.posts
import kotlinx.android.synthetic.main.activity_show_post.*

class ShowPostActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_show_post)
        likeButton.setOnClickListener{
            var currentId = intent.getIntExtra("postId",0)
            System.out.println("CURRENT ID : "+currentId)
            like(currentId)

        }

    }
    //@SuppressLint("ResourceAsColor")
    fun like(currentId: Int){

        posts[currentId-1].nbOfLike++
     /*   if(posts[currentId.toInt()].liked == false){
            posts[currentId.toInt()].liked = true
            likeButton.setBackgroundColor(R.color.colorPrimaryDark)
        }
        else{
            posts[currentId.toInt()].liked = false
            likeButton.setBackgroundColor(R.color.colorAccent)
        }*/
        System.out.println("NB DE LIKE :"+posts[currentId-1].nbOfLike)
    }
}
