package com.isen.androidprojetdpsh

import android.os.Parcel
import android.os.Parcelable
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

class PostOnWallAdapter (val results: Array<PostOnWall>): RecyclerView.Adapter<PostOnWallAdapter.PostOnWallViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PostOnWallViewHolder {
    val view = LayoutInflater.from(parent.context).inflate(R.layout.PostActivity, parent, false)
    return UsersViewHolder(view, parent.context)
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