package com.example.myapplication.presentation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import androidx.room.Room
import com.example.myapplication.R
import com.example.myapplication.data.AppDataBase
import com.example.myapplication.data.Control
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers.IO
import kotlinx.coroutines.launch

class RegisterInvestment : AppCompatActivity() {

    companion object{
        val TASK_TITLE_EXTRA = "task.title.extra.detail"
    }

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.register_investment)

        //recuperar string tela anterior
        val title: String = intent.getStringExtra(TASK_TITLE_EXTRA)?:"" //se nao existir retorna um vazio no float coloca "'" e 0 dento do parentese

        //recuperar xml
        val tvamount = findViewById<TextView>(R.id.tv_amount)

        //setando a view
        tvamount.text = title

            //como cria um banco de dados uma tabela
            val dataBase = Room.databaseBuilder(
                applicationContext,
                AppDataBase::class.java, "control-database"
            ).build()


            //taskDao pra chmar o Dao
            val dao = dataBase.taskDao()

            //salvar localmente na base de dados
            val control = Control(
                dollar = 500, dayofinvestment = "date"
            )//nao preciso colocar o id pq ele eh gerado automaticamente

            //nao sabe to tempo vai demorar,  entao pra mudar a thread tem q usar o CouroutineScope
            //A activity vai continuar fazendo o q tem q fazer e o insert vai acontecer paralelo
            CoroutineScope(IO).launch {
                dao.insert(control)
            }

        }
    }









