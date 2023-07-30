package com.example.myapplication.data

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update


@Dao
interface ControlDao {

    //essa funcao vai receber uma classe que eh uma entity e por enquanto nao vai me devolver nada so vai inserir e nao vai fazer mais nada
    @Insert(onConflict = OnConflictStrategy.REPLACE) //qdo to tentando iserir uma tarefa mas tem tarefa igual entao faz o replace
    fun insert(control: Control)

    @Query("Select * from control")
    fun getAll(): LiveData<List<Control>>

    @Update(onConflict = OnConflictStrategy.REPLACE)
    fun update(control: Control)

    //Delete all
    @Query("Delete from control")
    fun deleteALl()

    //Delete pelo id
    @Query("Delete from control WHERE id =:id")
    fun deleteById(id: Int)

}