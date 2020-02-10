package com.isen.androidprojetdpsh

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import com.google.firebase.database.*
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import androidx.core.app.ComponentActivity.ExtraData
import androidx.core.content.ContextCompat.getSystemService
import android.icu.lang.UCharacter.GraphemeClusterBreak.T



class TestFirebaseActivity : AppCompatActivity() {

    companion object {
        private const val TAG = "KotlinActivity"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // Reuse the layout used in MainActivity
        setContentView(R.layout.activity_main)

        basicReadWrite()
    }

    fun basicReadWrite() {
        // [START write_message]
        // Write a message to the database
        val database = FirebaseDatabase.getInstance()
        val myRef = database.getReference("message")
        //val myRef = database.getReference("https://console.firebase.google.com/project/androidprojet-dpsh/database/firestore/data~2F")


        myRef.setValue("Hello, World!")
        // [END write_message]


        // [START read_message]

        // Read from the database
        myRef.addValueEventListener(object : ValueEventListener {
            override fun onDataChange(dataSnapshot: DataSnapshot) {
                // This method is called once with the initial value and again
                // whenever data at this location is updated.
                val value = dataSnapshot.getValue(String::class.java)
                //Log.d(TAG, "Value is: $value")

                Toast.makeText(this@TestFirebaseActivity, "Value is: $value",
                    Toast.LENGTH_LONG).show()
            }

            override fun onCancelled(error: DatabaseError) {
                // Failed to read value
                //Log.w(TAG, "Failed to read value.", error.toException())

                Toast.makeText(this@TestFirebaseActivity, "Failed to read value." + error.toException(),
                    Toast.LENGTH_LONG).show()
            }
        })
        // [END read_message]
    }

    /*
    private fun writeNewUser(userId: String, name: String, email: String?) {
        val user = User(name, email)
        database.child("users").child(userId).setValue(user)
    }
    */
}
