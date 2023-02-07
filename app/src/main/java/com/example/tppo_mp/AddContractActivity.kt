package com.example.tppo_mp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText

class AddContractActivity : AppCompatActivity()
{
    private lateinit var editTextAddContractId: EditText
    private lateinit var editTextAddContractPrice: EditText
    private lateinit var editTextAddContractClientId: EditText
    private lateinit var editTextAddContractCourseId: EditText

    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_contract)

        editTextAddContractId = findViewById(R.id.editTextAddContractId)
        editTextAddContractPrice = findViewById(R.id.editTextAddContractPrice)
        editTextAddContractClientId = findViewById(R.id.editTextAddContractClientId)
        editTextAddContractCourseId = findViewById(R.id.editTextAddContractCourseId)
        findViewById<Button>(R.id.buttonAddContractConfirm).setOnClickListener { confirm() }
    }

    private fun confirm()
    {
        val intent = Intent(this@AddContractActivity, MainActivity::class.java)
        intent.putExtra("action", 3)
        intent.putExtra("id", editTextAddContractId.text.toString().toInt())
        intent.putExtra("price", editTextAddContractPrice.text.toString().toInt())
        intent.putExtra("clientId", editTextAddContractClientId.text.toString().toInt())
        intent.putExtra("courseId", editTextAddContractCourseId.text.toString().toInt())
        setResult(RESULT_OK, intent)
        finish()
    }
}