package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import java.text.NumberFormat
import java.util.Locale

class CalculateActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_caculate)

        // Find views by their IDs
        val btn2Calculate: Button = findViewById(R.id.btn2_calculate)
        val edtSin: EditText = findViewById(R.id.edt_sinyear)
        val edtCurrent: EditText = findViewById(R.id.edt_currentyear)
        val txtResult: TextView = findViewById(R.id.tv_result)

        // Set click listener for the button
        btn2Calculate.setOnClickListener {

            //Get the input values from the EditText views
            val currentYearStr = edtCurrent.text.toString()
            val yearCreatedSinStr = edtSin.text.toString()

            //Convert the input values to integers
            val currentYearInt = currentYearStr.toIntOrNull() ?: 0
            val yearCreatedSinInt = yearCreatedSinStr.toIntOrNull() ?: 0

            //Call the function to caculate the total TFSA
            val totalTFSA = calculateTotalTFSA(yearCreatedSinInt, currentYearInt)

            // Function to format the number as Canadian dollars (CAD)
            fun formatCurrency(value: Int): String {
                val currencyFormat = NumberFormat.getCurrencyInstance(Locale.CANADA)
                return currencyFormat.format(value).replace("CA", "CAD")
            }

            // Format the result in Canadian dollars (CAD)
            val formattedResult = formatCurrency(totalTFSA)

            // Display the formatted result
            txtResult.text = "Based on the information that you never used your TFSA, your room until $currentYearInt since the year of your first SIN or the year of your birth is: $formattedResult"
        }


    }
  }

    // Function to calculate the total TFSA
    private fun calculateTotalTFSA(yearCreatedSin: Int, currentYear: Int): Int {
        val tfsaLimits = mapOf(
            2009 to 5000,
            2010 to 5000,
            2011 to 5000,
            2012 to 5000,
            2013 to 5500,
            2014 to 5500,
            2015 to 10000,
            2016 to 5500,
            2017 to 5500,
            2018 to 5500,
            2019 to 6000,
            2020 to 6000,
            2021 to 6000,
            2022 to 6000,
            2023 to 6500
        )

        val eligibleYears = tfsaLimits.keys.filter { it >= yearCreatedSin }
        return eligibleYears.sumOf { tfsaLimits[it] ?: 0 }
    }

