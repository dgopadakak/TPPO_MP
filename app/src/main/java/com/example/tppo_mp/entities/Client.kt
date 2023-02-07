package com.example.tppo_mp.entities

data class Client(
    var id: Int,
    var name: String,
    var phoneNum: String,
    var email: String,
    var direction: String,
    var desiredPrice: Int,
    var trainingMode: String
)