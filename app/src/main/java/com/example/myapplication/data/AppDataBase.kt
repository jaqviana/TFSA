package com.example.myapplication.data

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = [Control::class], version = 1) //entity q eh nossa task, q vai ser um array
abstract class AppDataBase: RoomDatabase() {
    abstract fun taskDao(): ControlDao //to expondo meu taskDao q vai ser meu acesso ao objeto/acesso a tabela/base de dados
}
