package com.example.opsc_p2_ameer_miller_st10067171

import android.os.Bundle
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class BudgetActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_budget)

        val recyclerView = findViewById<RecyclerView>(R.id.recyclerViewExpenses)
        val totalExpenseTextView = findViewById<TextView>(R.id.textViewTotalExpense)
        val editTextMinGoal = findViewById<EditText>(R.id.editTextMinGoal)
        val editTextMaxGoal = findViewById<EditText>(R.id.editTextMaxGoal)
        val buttonSetGoals = findViewById<Button>(R.id.buttonSetGoals)

        // Set up RecyclerView
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = ExpenseAdapter(ExpenseStorage.expenseList)

        // Calculate and display total expenses
        var total = 0.0
        for (expense in ExpenseStorage.expenseList) {
            total += expense.amount
        }
        totalExpenseTextView.text = "Total: $${"%.2f".format(total)}"

        // Handle Set Goals button click
        buttonSetGoals.setOnClickListener {
            val minInput = editTextMinGoal.text.toString()
            val maxInput = editTextMaxGoal.text.toString()

            if (minInput.isNotEmpty() && maxInput.isNotEmpty()) {
                val minGoal = minInput.toDoubleOrNull()
                val maxGoal = maxInput.toDoubleOrNull()

                if (minGoal != null && maxGoal != null) {
                    if (minGoal > maxGoal) {
                        Toast.makeText(this, "Minimum goal cannot be higher than maximum.", Toast.LENGTH_SHORT).show()
                    } else {
                        Toast.makeText(this, "Goals set: Min = $minGoal, Max = $maxGoal", Toast.LENGTH_SHORT).show()
                    }
                } else {
                    Toast.makeText(this, "Enter valid numeric values.", Toast.LENGTH_SHORT).show()
                }
            } else {
                Toast.makeText(this, "Please fill in both goals.", Toast.LENGTH_SHORT).show()
            }
        }
    }
}
