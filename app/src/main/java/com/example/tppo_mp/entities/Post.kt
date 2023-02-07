package com.example.tppo_mp.entities

data class Post(
    var id: Int,
    val duties: ArrayList<String> = ArrayList(),
    val privileges: ArrayList<String> = ArrayList(),
    var education: String,
    var numOfEmployees: Int,
    var salary: Int,
    var workingHoursPerMonth: Int
)