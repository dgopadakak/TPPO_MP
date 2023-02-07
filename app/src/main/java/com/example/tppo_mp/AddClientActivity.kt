package com.example.tppo_mp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText

class AddClientActivity : AppCompatActivity()
{
    private lateinit var editTextAddClientId: EditText
    private lateinit var editTextAddClientName: EditText
    private lateinit var editTextAddClientPhoneNum: EditText
    private lateinit var editTextAddClientEmail: EditText
    private lateinit var editTextAddClientDirections: EditText
    private lateinit var editTextAddClientDesiredPrice: EditText
    private lateinit var editTextAddClientTrainingMode: EditText

    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_client)

        editTextAddClientId = findViewById(R.id.editTextAddClientId)
        editTextAddClientName = findViewById(R.id.editTextAddClientName)
        editTextAddClientPhoneNum = findViewById(R.id.editTextAddClientPhoneNum)
        editTextAddClientEmail = findViewById(R.id.editTextAddClientEmail)
        editTextAddClientDirections = findViewById(R.id.editTextAddClientDirections)
        editTextAddClientDesiredPrice = findViewById(R.id.editTextAddClientDesiredPrice)
        editTextAddClientTrainingMode = findViewById(R.id.editTextAddClientTrainingMode)
        findViewById<Button>(R.id.buttonAddClientConfirm).setOnClickListener { confirm() }
    }

    private fun confirm()
    {
        val intent = Intent(this@AddClientActivity, MainActivity::class.java)
        intent.putExtra("action", 1)
        intent.putExtra("id", editTextAddClientId.text.toString().toInt())
        intent.putExtra("name", editTextAddClientName.text.toString())
        intent.putExtra("phoneNum", editTextAddClientPhoneNum.text.toString())
        intent.putExtra("email", editTextAddClientEmail.text.toString())
        intent.putExtra("direction", editTextAddClientDirections.text.toString())
        intent.putExtra("desiredPrice", editTextAddClientDesiredPrice.text.toString().toInt())
        intent.putExtra("trainingMode", editTextAddClientTrainingMode.text.toString())
        setResult(RESULT_OK, intent)
        finish()
    }
}