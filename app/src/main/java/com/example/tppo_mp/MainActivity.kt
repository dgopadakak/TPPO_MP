package com.example.tppo_mp

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import com.example.tppo_mp.entities.AboutCourse
import com.example.tppo_mp.entities.Client
import com.example.tppo_mp.entities.Contract
import com.example.tppo_mp.entities.Course
import com.google.gson.Gson
import com.google.gson.GsonBuilder

class MainActivity : AppCompatActivity()
{
    private val db: DB = DB()

    private val gsonBuilder: GsonBuilder = GsonBuilder()
    private val gson: Gson = gsonBuilder.create()

    private var resultLauncher = registerForActivityResult(
        ActivityResultContracts
            .StartActivityForResult())
    { result ->
        if (result.resultCode == Activity.RESULT_OK)
        {
            val data: Intent? = result.data
            processOnActivityResult(data)
        }
    }

    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        findViewById<Button>(R.id.buttonAddClient).setOnClickListener { startSomeActivity(1) }
        findViewById<Button>(R.id.buttonAddCourse).setOnClickListener { startSomeActivity(2) }
        findViewById<Button>(R.id.buttonAddContract).setOnClickListener { startSomeActivity(3) }
        findViewById<Button>(R.id.buttonCheckClients).setOnClickListener { startSomeActivity(4) }
        findViewById<Button>(R.id.buttonCheckCourses).setOnClickListener { startSomeActivity(5) }
        findViewById<Button>(R.id.buttonCheckContracts).setOnClickListener { startSomeActivity(6) }

        db.client.add(Client(1, "Иванов Иван Иванович", "+79189999999",
            "ivan@mail.ru", "Программирование", 50000,
            "По вечерам"))
        db.course.add(Course(1, 60000, 10,
            "Программирование, Kotlin", "JavaRush",
            "Олегов Олег Олегович", AboutCourse("Тема 1, тема 2, тема 3",
                "Задание 1, задание 2, задание 3", true)))
        db.contract.add(Contract(1, 55000, 1, 1))
    }

    private fun startSomeActivity(n: Int)
    {
        val intent = Intent()
        if (n == 1)
        {
            intent.setClass(this, AddClientActivity::class.java)
        }
        if (n == 2)
        {
            intent.setClass(this, AddCourseActivity::class.java)
        }
        if (n == 3)
        {
            intent.setClass(this, AddContractActivity::class.java)
        }
        if (n == 4 || n == 5 || n == 6)
        {
            intent.setClass(this, CheckActivity::class.java)
            intent.putExtra("action", n)
            intent.putExtra("gson", gson.toJson(db))
        }
        resultLauncher.launch(intent)
    }

    private fun processOnActivityResult(data: Intent?)
    {
        if (data?.getIntExtra("action", -1) == 1)
        {
            db.client.add(Client(
                data.getIntExtra("id", -1),
                data.getStringExtra("name").toString(),
                data.getStringExtra("phoneNum").toString(),
                data.getStringExtra("email").toString(),
                data.getStringExtra("direction").toString(),
                data.getIntExtra("desiredPrice", -1),
                data.getStringExtra("trainingMode").toString()
            ))
        }
        if (data?.getIntExtra("action", -1) == 2)
        {
            var tempIsHints = false
            if (data.getStringExtra("isHaveHints").toString().lowercase() == "есть")
            {
                tempIsHints = true
            }
            db.course.add(Course(
                data.getIntExtra("id", -1),
                data.getIntExtra("price", -1),
                data.getIntExtra("numOfStudents", -1),
                data.getStringExtra("searchTags").toString(),
                data.getStringExtra("companyName").toString(),
                data.getStringExtra("presenterName").toString(),
                AboutCourse(
                    data.getStringExtra("listOfTopics").toString(),
                    data.getStringExtra("listOfTasks").toString(),
                    tempIsHints
                )
            ))
        }
        if (data?.getIntExtra("action", -1) == 3)
        {
            db.contract.add(Contract(
                data.getIntExtra("id", -1),
                data.getIntExtra("price", -1),
                data.getIntExtra("clientId", -1),
                data.getIntExtra("courseId", -1)
            ))
        }
    }
}