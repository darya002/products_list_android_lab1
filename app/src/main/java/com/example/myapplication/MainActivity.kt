package com.example.myapplication

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.ListView
import androidx.activity.ComponentActivity
import com.example.myapplication.models.ShoppingItem
import com.example.myapplication.models.ShoppingListAdapter

class MainActivity : ComponentActivity() {
    private val shoppingList = mutableListOf<ShoppingItem>()
    private lateinit var adapter: ShoppingListAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val itemInput: EditText = findViewById(R.id.itemInput)
        val addButton: Button = findViewById(R.id.addButton)
        val deleteSelectedButton: Button = findViewById(R.id.deleteSelectedButton)

        adapter = ShoppingListAdapter(this, shoppingList)
        val shoppingListView: ListView = findViewById(R.id.shoppingListView)
        adapter = ShoppingListAdapter(this, shoppingList)
        shoppingListView.adapter = adapter

        // Добавление элемента в список
        addButton.setOnClickListener {
            val itemName = itemInput.text.toString()
            if (itemName.isNotBlank()) {
                shoppingList.add(ShoppingItem(itemName))
                adapter.notifyDataSetChanged()
                itemInput.text.clear()
            }
        }

        // Удаление отмеченных элементов
        deleteSelectedButton.setOnClickListener {
            shoppingList.removeAll { it.isChecked }
            adapter.notifyDataSetChanged()
        }
    }
}