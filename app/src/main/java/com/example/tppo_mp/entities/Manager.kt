package com.example.tppo_mp.entities

data class Manager(
    var id: Int,
    var name: String,
    var dateOfBirth: String,
    var phoneNum: String,
    var address: String,
    var docNum: Int,
    val post: Post
)