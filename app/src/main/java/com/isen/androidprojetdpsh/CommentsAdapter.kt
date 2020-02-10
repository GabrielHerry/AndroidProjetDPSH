package com.isen.androidprojetdpsh

import android.content.Context
import android.os.Parcel
import android.os.Parcelable
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.comments.view.*
import kotlinx.android.synthetic.main.post.view.*

class CommentsAdapter(val post: PostOnWall, val callBack: (CommentOnPost)-> Unit) :
        RecyclerView.Adapter<CommentsAdapter.commentsViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): commentsViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.comments, parent, false)
        return commentsViewHolder(view, parent.context)
    }

    override fun getItemCount(): Int {
        return post.comments.count()
    }

    override fun onBindViewHolder(holder: commentsViewHolder, position: Int) {
        val commment = post.comments[position] //commentaire
        holder.bind(post, position)
        callBack.invoke(commment)
    }

    class commentsViewHolder(val view: View, val context: Context) :
            RecyclerView.ViewHolder(view) {
        fun bind(post: PostOnWall, position:Int) {

            view.commentTextView.text = post.comments[position].comment
            view.postDescription.text = post.description

            Picasso
                    .with(context)
                    .load(post.picture)
                    //.into(view.postPicture)
        }

    }
}
