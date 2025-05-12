package com.example.opsc_p2_ameer_miller_st10067171

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class ExpenseAdapter(private var expenses: List<Expense>) :
    RecyclerView.Adapter<ExpenseAdapter.ViewHolder>() {

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val cat = view.findViewById<TextView>(R.id.itemCategory)
        val amt = view.findViewById<TextView>(R.id.itemAmount)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.itemexpense, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, pos: Int) {
        val expense = expenses[pos]
        holder.cat.text = expense.category
        holder.amt.text = "$${expense.amount}"
    }

    override fun getItemCount() = expenses.size

    // Add this method to allow updates to the list
    fun updateData(newExpenses: List<Expense>) {
        expenses = newExpenses
        notifyDataSetChanged()
    }
}
