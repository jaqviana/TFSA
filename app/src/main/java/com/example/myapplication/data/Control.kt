package com.example.myapplication.data

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Control(

@PrimaryKey(autoGenerate = true)
    val id: Int = 0, //toda vez q acrescentar mais uma item vai acrescentar +1 nesse numero vai gerar sozinho
    val dollar: Int,
    val dayofinvestment: String,
)