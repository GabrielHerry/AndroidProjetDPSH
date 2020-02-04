package com.isen.androidprojetdpsh

import android.content.Context
import android.os.Parcel
import android.os.Parcelable
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.post.view.*

class PostOnWallAdapter(val posts: ArrayList<PostOnWall>, val callBack: (PostOnWall)-> Unit) :
    RecyclerView.Adapter<PostOnWallAdapter.postOnWallViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): postOnWallViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.post, parent, false)
        return postOnWallViewHolder(view, parent.context)
    }

    override fun getItemCount(): Int {
        return posts.count()
    }

    override fun onBindViewHolder(holder: postOnWallViewHolder, position: Int) {
        val post = posts[position]
        holder.bind(post, callBack)
    }

    class postOnWallViewHolder(val view: View, val context: Context) :
        RecyclerView.ViewHolder(view) {
        fun bind(post: PostOnWall, callBack: (PostOnWall)-> Unit) {

            view.postTitle.text = post.title
            view.postDescription.text = post.description

            Picasso
                .with(context)
                .load(post.picture)
                .into(view.postPicture)

            view.setOnClickListener {
                callBack.invoke(post)
            }
        }

    }
}


/*
class AllResultAdapter(val results: Array<User>): RecyclerView.Adapter<AllResultAdapter.UsersViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UsersViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.recycler_view_contact_cell, parent, false)
        return UsersViewHolder(view, parent.context)
    }

    override fun getItemCount(): Int {
        return results.count()
    }

    override fun onBindViewHolder(holder: UsersViewHolder, position: Int) {
        val user = results[position]
        holder.bind(user)
    }

    class UsersViewHolder(val view: View, val context: Context): RecyclerView.ViewHolder(view) {
        fun bind(user: User) {

            view.genderOfUser.text = user.gender

            view.titleNameOfUser.text = user.name?.title
            view.firstNameOfUser.text = user.name?.first
            view.lastNameOfUser.text = user.name?.last

            view.emailOfUser.text = user.email

            Picasso
                .with(context)
                .load(user.picture?.large)
                .into(view.pictureOfUser)

            Log.i("URL picture", user.picture?.large)
        }
    }
}
*/