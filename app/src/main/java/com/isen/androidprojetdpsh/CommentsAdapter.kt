package com.isen.androidprojetdpsh

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.comments.view.*

class CommentsAdapter(val comm: ArrayList<CommentOnPost>?) :
        RecyclerView.Adapter<CommentsAdapter.commentsViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): commentsViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.comments, parent, false)
        return commentsViewHolder(view, parent.context)
    }

    override fun getItemCount(): Int {
        return comm!!.count()
    }

    override fun onBindViewHolder(holder: commentsViewHolder, position: Int) {
        val comment = comm!![position] //commentaire
        holder.bind(comment)

    }

    class commentsViewHolder(val view: View, val context: Context) :
            RecyclerView.ViewHolder(view) {
        fun bind(comm: CommentOnPost) {

            view.commentTextView.text = comm.comment
            //view.postDescription.text = post.description
        }

    }
}
