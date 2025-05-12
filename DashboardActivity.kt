package com.example.opsc_p2_ameer_miller_st10067171

import android.app.DatePickerDialog
import android.content.Intent
import android.os.Bundle
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import java.util.*

class DashboardActivity : AppCompatActivity() {

    private lateinit var editTextDate: EditText
    private lateinit var editTextCategory: EditText
    private lateinit var editTextStartTime: EditText
    private lateinit var editTextEndTime: EditText
    private lateinit var editTextDescription: EditText
    private lateinit var buttonAddCategory: Button
    private lateinit var buttonAddExpense: Button
    private lateinit var buttonViewBudget: Button
    private lateinit var listViewExpenses: ListView

    private val expensesList = ArrayList<String>()
    private lateinit var expensesAdapter: ArrayAdapter<String>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dashboard)

        // Bind UI elements
        editTextDate = findViewById(R.id.editTextDate)
        editTextCategory = findViewById(R.id.editTextCategory)
        editTextStartTime = findViewById(R.id.editTextStartTime)
        editTextEndTime = findViewById(R.id.editTextEndTime)
        editTextDescription = findViewById(R.id.editTextDescription)
        buttonAddCategory = findViewById(R.id.buttonAddCategory)
        buttonAddExpense = findViewById(R.id.buttonAddExpense)
        buttonViewBudget = findViewById(R.id.buttonViewBudget)
        listViewExpenses = findViewById(R.id.listViewExpenses)

        // Setup adapter for the list view
        expensesAdapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, expensesList)
        listViewExpenses.adapter = expensesAdapter

        // Date Picker for Date Input
        val dateEditText = findViewById<EditText>(R.id.editTextDate)

        dateEditText.setOnClickListener {
            val calendar = Calendar.getInstance()
            val datePickerDialog = DatePickerDialog(
                this, { _, year, monthOfYear, dayOfMonth ->
                    val selectedDate = "$dayOfMonth/${monthOfYear + 1}/$year"
                    dateEditText.setText(selectedDate)
                },
                calendar.get(Calendar.YEAR),
                calendar.get(Calendar.MONTH),
                calendar.get(Calendar.DAY_OF_MONTH)
            )
            datePickerDialog.datePicker.maxDate = System.currentTimeMillis() // Limit to today
            datePickerDialog.show()
        }

        // Add category logic
        buttonAddCategory.setOnClickListener {
            val newCategory = editTextCategory.text.toString()
            if (newCategory.isNotEmpty()) {
                Toast.makeText(this, "Category '$newCategory' added!", Toast.LENGTH_SHORT).show()
                editTextCategory.text.clear()
            } else {
                Toast.makeText(this, "Please enter a category!", Toast.LENGTH_SHORT).show()
            }
        }

        // Add expense logic
        buttonAddExpense.setOnClickListener {
            val date = editTextDate.text.toString()
            val category = editTextCategory.text.toString()
            val startTime = editTextStartTime.text.toString()
            val endTime = editTextEndTime.text.toString()
            val description = editTextDescription.text.toString()

            if (date.isEmpty() || category.isEmpty() || startTime.isEmpty() || endTime.isEmpty() || description.isEmpty()) {
                Toast.makeText(this, "Please fill in all fields.", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            val expenseDetails = "Date: $date | Category: $category | Start: $startTime | End: $endTime | Description: $description"
            expensesList.add(expenseDetails)
            expensesAdapter.notifyDataSetChanged()

            // Clear input fields after adding the expense
            editTextDate.text.clear()
            editTextCategory.text.clear()
            editTextStartTime.text.clear()
            editTextEndTime.text.clear()
            editTextDescription.text.clear()
        }

        // View Budget button logic
        buttonViewBudget.setOnClickListener {
            val intent = Intent(this, BudgetActivity::class.java)
            startActivity(intent)
        }
    }
}
