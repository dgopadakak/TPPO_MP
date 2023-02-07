package com.example.tppo_mp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText

class AddCourseActivity : AppCompatActivity()
{
    private lateinit var editTextAddCourseId: EditText
    private lateinit var editTextAddCoursePrice: EditText
    private lateinit var editTextAddCourseNumOfStudents: EditText
    private lateinit var editTextAddCourseCompanyName: EditText
    private lateinit var editTextAddCoursePresenterName: EditText
    private lateinit var editTextAddCourseListOfTopics: EditText
    private lateinit var editTextAddCourseListOfTasks: EditText
    private lateinit var editTextAddCourseSearchTags: EditText
    private lateinit var editTextAddCourseIsHaveHints: EditText

    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_course)

        editTextAddCourseId = findViewById(R.id.editTextAddCourseId)
        editTextAddCoursePrice = findViewById(R.id.editTextAddCoursePrice)
        editTextAddCourseNumOfStudents = findViewById(R.id.editTextAddCourseNumOfStudents)
        editTextAddCourseCompanyName = findViewById(R.id.editTextAddCourseCompanyName)
        editTextAddCoursePresenterName = findViewById(R.id.editTextAddCoursePresenterName)
        editTextAddCourseListOfTopics = findViewById(R.id.editTextAddCourseListOfTopics)
        editTextAddCourseListOfTasks = findViewById(R.id.editTextAddCourseListOfTasks)
        editTextAddCourseSearchTags = findViewById(R.id.editTextAddCourseSearchTags)
        editTextAddCourseIsHaveHints = findViewById(R.id.editTextAddCourseIsHaveHints)
        findViewById<Button>(R.id.buttonAddCourseConfirm).setOnClickListener { confirm() }
    }

    private fun confirm()
    {
        val intent = Intent(this@AddCourseActivity, MainActivity::class.java)
        intent.putExtra("action", 2)
        intent.putExtra("id", editTextAddCourseId.text.toString().toInt())
        intent.putExtra("price", editTextAddCoursePrice.text.toString().toInt())
        intent.putExtra("numOfStudents", editTextAddCourseNumOfStudents.text.toString().toInt())
        intent.putExtra("searchTags", editTextAddCourseSearchTags.text.toString())
        intent.putExtra("companyName", editTextAddCourseCompanyName.text.toString())
        intent.putExtra("presenterName", editTextAddCoursePresenterName.text.toString())
        intent.putExtra("listOfTopics", editTextAddCourseListOfTopics.text.toString())
        intent.putExtra("listOfTasks", editTextAddCourseListOfTasks.text.toString())
        intent.putExtra("isHaveHints", editTextAddCourseIsHaveHints.text.toString())
        setResult(RESULT_OK, intent)
        finish()
    }
}