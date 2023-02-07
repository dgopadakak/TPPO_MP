package com.example.tppo_mp

import com.example.tppo_mp.entities.*

class DB(
    val client: ArrayList<Client> = ArrayList(),
    val contract: ArrayList<Contract> = ArrayList(),
    val course: ArrayList<Course> = ArrayList(),
    val manager: ArrayList<Manager> = ArrayList(),
    val sale: ArrayList<Sale> = ArrayList()
)