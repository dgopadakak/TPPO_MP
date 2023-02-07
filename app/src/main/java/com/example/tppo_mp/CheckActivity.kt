package com.example.tppo_mp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import com.google.gson.Gson
import com.google.gson.GsonBuilder

class CheckActivity : AppCompatActivity()
{
    private var currentAction = 0
    private lateinit var db: DB
    private var currentIndex = 0

    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_check)

        val gsonBuilder = GsonBuilder()
        val gson: Gson = gsonBuilder.create()
        db = gson.fromJson(intent.getStringExtra("gson"), DB::class.java)
        currentAction = intent.getIntExtra("action", -1)
        refresh()

        findViewById<Button>(R.id.buttonBack).setOnClickListener { finish() }
        findViewById<Button>(R.id.buttonForward).setOnClickListener { goForward() }
        findViewById<Button>(R.id.buttonBackward).setOnClickListener { goBackward() }
    }

    private fun goForward()
    {
        val size = if (currentAction == 4)
        {
            db.client.size
        }
        else if (currentAction == 5)
        {
            db.course.size
        }
        else
        {
            db.contract.size
        }
        if (currentIndex < size - 1)
        {
            currentIndex++
            refresh()
        }
    }

    private fun goBackward()
    {
        if (currentIndex > 0)
        {
            currentIndex--
            refresh()
        }
    }

    private fun refresh()
    {
        if (currentAction == 4)
        {
            "ID: ${db.client[currentIndex].id}"
                .also { findViewById<TextView>(R.id.textView1).text = it }
            "ФИО: ${db.client[currentIndex].name}"
                .also { findViewById<TextView>(R.id.textView2).text = it }
            "Номер телефона: ${db.client[currentIndex].phoneNum}"
                .also { findViewById<TextView>(R.id.textView3).text = it }
            "E-mail: ${db.client[currentIndex].email}"
                .also { findViewById<TextView>(R.id.textView4).text = it }
            "Направление доп. образования: ${db.client[currentIndex].direction}"
                .also { findViewById<TextView>(R.id.textView5).text = it }
            "Желаемая стоимость: ${db.client[currentIndex].desiredPrice}"
                .also { findViewById<TextView>(R.id.textView6).text = it }
            "Режим обучения: ${db.client[currentIndex].trainingMode}"
                .also { findViewById<TextView>(R.id.textView7).text = it }
        }
        if (currentAction == 5)
        {
            "ID: ${db.course[currentIndex].id}"
                .also { findViewById<TextView>(R.id.textView1).text = it }
            "Стоимость: ${db.course[currentIndex].price}"
                .also { findViewById<TextView>(R.id.textView2).text = it }
            "Количество мест: ${db.course[currentIndex].numOfStudents}"
                .also { findViewById<TextView>(R.id.textView3).text = it }
            "Метки поиска: ${db.course[currentIndex].searchTags}"
                .also { findViewById<TextView>(R.id.textView4).text = it }
            "Название компании: ${db.course[currentIndex].companyName}"
                .also { findViewById<TextView>(R.id.textView5).text = it }
            "ФИО ведущего: ${db.course[currentIndex].presenterName}"
                .also { findViewById<TextView>(R.id.textView6).text = it }
            "Список тем: ${db.course[currentIndex].aboutCourse.listOfTopics}"
                .also { findViewById<TextView>(R.id.textView7).text = it }
            "Список заданий: ${db.course[currentIndex].aboutCourse.listOfTasks}"
                .also { findViewById<TextView>(R.id.textView8).text = it }
            findViewById<TextView>(R.id.textView9).text =
                if (db.course[currentIndex].aboutCourse.isHaveHints)
                {
                    "Есть подсказки"
                }
                else
                {
                    "Нет подсказок"
                }
        }
        if (currentAction == 6)
        {
            "ID: ${db.contract[currentIndex].id}"
                .also { findViewById<TextView>(R.id.textView1).text = it }
            "Итоговая стоимость: ${db.contract[currentIndex].price}"
                .also { findViewById<TextView>(R.id.textView2).text = it }
            "ID клиента: ${db.contract[currentIndex].clientId}"
                .also { findViewById<TextView>(R.id.textView3).text = it }
            "ID курса: ${db.contract[currentIndex].courseId}"
                .also { findViewById<TextView>(R.id.textView4).text = it }
        }
    }
}