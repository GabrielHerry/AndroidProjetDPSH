package com.isen.androidprojetdpsh

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.isen.androidprojetdpsh.GlobalsVar.Companion.posts
import kotlinx.android.synthetic.main.activity_show_post.*

class ShowPostActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_show_post)

        commentRecyclerView.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        val currentPostId = intent.getIntExtra("postId",0)
                //commentRecyclerView.adapter = CommentsAdapter(GlobalsVar.posts?.get(currentPostId)?.comments)

       // val intent1 = Intent(this, CreatePostActivity::class.java)

        commentButton.setOnClickListener(){
            val currentId = intent.getIntExtra("postId",0)
            val currentCommId = intent.getIntExtra("commentid",0)
            System.out.println(commentEditText.equals(""))
            if(!commentEditText.equals("")){
                val comm:String = commentEditText.getText().toString() //comment put by other user
                val commentaire = CommentOnPost(comm,currentCommId)

                System.out.println(comm)

                commentaire.id = commentaire.id + 1

                comment(currentId, commentaire)

                //val intent1 = Intent(this, WallActivity::class.java)
                //startActivity(intent1)

            }
        }
        likeButton.setOnClickListener{
            var currentId = intent.getIntExtra("postId",0)
            System.out.println("CURRENT ID : "+currentId)
            like(currentId)
        }
    }
    //@SuppressLint("ResourceAsColor")
    fun like(currentId: Int){

        posts!![currentId-1].nbOfLike++
     /*   if(posts[currentId.toInt()].liked == false){
            posts[currentId.toInt()].liked = true
            likeButton.setBackgroundColor(R.color.colorPrimaryDark)
        }
        else{
            posts[currentId.toInt()].liked = false
            likeButton.setBackgroundColor(R.color.colorAccent)
        }*/
        System.out.println("NB DE LIKE :"+ posts?.get(currentId-1)?.nbOfLike)
    }
    fun comment(postId:Int, newComment: CommentOnPost?){
        val currentPost= posts?.get(postId-1)

        System.out.printf("NB OF> POST "+currentPost?.comments?.count())
        if (newComment != null) {
            currentPost?.comments?.add(newComment)
        }
        System.out.printf("NB OF> POST "+currentPost?.comments?.count())
    }

}
