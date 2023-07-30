package com.example.myapplication.presentation

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.R
import com.example.myapplication.data.Control

//pedir uma lista de string
class ControlListAdapter(
    private val list: List<Control>,
    private val openRegisterInvestment:(task: Control) -> Unit
    ): RecyclerView.Adapter<ControlListViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ControlListViewHolder {
        val view: View = LayoutInflater.from(parent.context)
            .inflate(R.layout.activity_main2, parent, false)
        return ControlListViewHolder(view)
    }
    //tamanho da lista
    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(holder: ControlListViewHolder, position: Int) {
        val item = list[position]
        holder.bind(item, openRegisterInvestment)
    }

}
class ControlListViewHolder(
    private val view: View) : RecyclerView.ViewHolder(view){

    val tvAmount = view.findViewById<TextView>(R.id.tv_amount)
    val tvDollar = view.findViewById<TextView>(R.id.tv_dollar)

    fun bind(
        list: Control,
        openRegisterInvestment:(task: Control) -> Unit
    ){
        tvAmount.text = list.toString()

        view.setOnClickListener {
            openRegisterInvestment.invoke(list)
        }
    }
}