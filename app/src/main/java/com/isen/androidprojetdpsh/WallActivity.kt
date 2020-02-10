package com.isen.androidprojetdpsh

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.*

import kotlinx.android.synthetic.main.activity_wall.*

class WallActivity : AppCompatActivity() {

    private var auth: FirebaseAuth? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_wall)

        auth = FirebaseAuth.getInstance()

        readFromCloud()



        val intent1 = Intent(this, CreatePostActivity::class.java)

        createPostButton.setOnClickListener {
            startActivity(intent1)
        }

        disconnexionButton.setOnClickListener {
            logOut()
        }


        readButton.setOnClickListener {
            postRecyclerView.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
            postRecyclerView.adapter = PostOnWallAdapter(GlobalsVar.postsOnPhone) {
                val intent = Intent(this, ShowPostActivity::class.java)

                intent.putExtra("postId", it.id)

                startActivity(intent)
            }
        }




    }

    private fun logOut () {
        auth?.signOut()
        val intent2 = Intent(this, LoginActivity::class.java)
        intent2.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TOP
        startActivity(intent2)
    }

    fun readFromCloud() {


        var database: DatabaseReference
        database = FirebaseDatabase.getInstance().reference

       // database.child("posts").setValue(posts)
       // val database = FirebaseDatabase.getInstance()
      //  val myRef = database.getReference("posts")

        database.addValueEventListener(object : ValueEventListener {
            override fun onDataChange(dataSnapshot: DataSnapshot) {
                // This method is called once with the initial value and again
                // whenever data at this location is updated.
                val postsUpdate = dataSnapshot.getValue(ListOfPostsClass::class.java)

                GlobalsVar.postsOnPhone = postsUpdate?.posts



            }

            override fun onCancelled(error: DatabaseError) {
                // Failed to read value
                //Log.w(TAG, "Failed to read value.", error.toException())

                Toast.makeText(this@WallActivity, "Failed to read value." + error.toException(),
                    Toast.LENGTH_LONG).show()
            }
        })
        // [END read_message]
    }
}
