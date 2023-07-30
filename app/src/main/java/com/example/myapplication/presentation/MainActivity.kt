package com.example.myapplication.presentation

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.example.myapplication.CalculateActivity
import com.example.myapplication.R

class MainActivity : AppCompatActivity() {



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)



        val btnOne: Button = findViewById(R.id.btn_tfsa)
        val btnTwo: Button = findViewById(R.id.btn_calculate)
        val btnThree: Button = findViewById(R.id.btn_register)



        btnOne.setOnClickListener {

            //link para acessar info oficial/site governo
        }

        btnTwo.setOnClickListener {

            val intent = Intent(this, CalculateActivity::class.java)
            startActivity(intent)
        }

        btnThree.setOnClickListener {

            val intent = Intent(this, MainActivity2::class.java)
            startActivity(intent)
        }
    }

}













