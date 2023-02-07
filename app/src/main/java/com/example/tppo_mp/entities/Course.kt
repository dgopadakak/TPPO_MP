package com.example.tppo_mp.entities

data class Course(
    var id: Int,
    var price: Int,
    var numOfStudents: Int,
    val searchTags: String,
    var companyName: String,
    var presenterName: String,
    val aboutCourse: AboutCourse
)