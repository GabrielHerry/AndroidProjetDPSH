package com.isen.androidprojetdpsh

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class ShowPostActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_show_post)

        var currentpost = intent.getIntExtra("postId",0)
    }
}
