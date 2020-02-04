package com.isen.androidprojetdpsh

import com.google.firebase.database.IgnoreExtraProperties

@IgnoreExtraProperties
data class User(
    var username: String? = "",
    var password: String? = "",
    var email: String? = "",
    var gender: String? = ""
)
