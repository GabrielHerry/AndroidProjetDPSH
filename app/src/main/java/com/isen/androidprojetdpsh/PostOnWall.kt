package com.isen.androidprojetdpsh


class PostOnWall( //one post
    var title: String? = "",
    var description: String? = "",
    var picture: String? = "",
    var id: Int? = 0,
    var nbOfLike: Int = 0,
    var comments: ArrayList<CommentOnPost>? = arrayListOf()
)


