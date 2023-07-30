package com.example.myapplication.presentation

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.R
import com.example.myapplication.data.Control

class MainActivity2 : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)

        val registerList: RecyclerView = findViewById(R.id.rv_control_detail)

        val list = listOf(
            Control(0, 0, "date0"),
            Control(1, 100, "date1"),
        )


        val adapter = ControlListAdapter(list, ::openRegisterInvestment)

        registerList.adapter = adapter

    }

    fun openRegisterInvestment(task: Control) {
        val intent = Intent(this, RegisterInvestment::class.java)
            // para mandar info para a outra tela
            .apply {
                putExtra(RegisterInvestment.TASK_TITLE_EXTRA,task.dollar)
            }
        startActivity(intent)
    }
}
