package com.isen.androidprojetdpsh

import com.google.firebase.database.IgnoreExtraProperties

@IgnoreExtraProperties
class PostOnWall (
    var title: String? = "",
    var description: String? = "",
    var picture: String? = "",
    var id: Int? = 0
)

class ListOfPostsClass (
    var posts: ArrayList<PostOnWall>? = arrayListOf()
)


