package com.isen.androidprojetdpsh

import java.net.IDN

class PostOnWall( //one post
    var title: String?,
    var description: String?,
    var picture: String?,
    var id: Int?,
    var nbOfLike: Int = 0,
    var comments: ArrayList<String>? = null
)


