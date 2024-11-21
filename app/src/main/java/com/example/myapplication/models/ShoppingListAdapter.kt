package com.example.myapplication.models

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.CheckBox
import android.widget.TextView
import com.example.myapplication.R
import com.example.myapplication.models.ShoppingItem

class ShoppingListAdapter(
    private val context: Context,
    private val items: MutableList<ShoppingItem>
) : BaseAdapter() {

    override fun getCount(): Int = items.size
    override fun getItem(position: Int): Any = items[position]
    override fun getItemId(position: Int): Long = position.toLong()

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        val view = convertView ?: LayoutInflater.from(context).inflate(R.layout.list_item, parent, false)

        val checkBox: CheckBox = view.findViewById(R.id.itemCheckBox)
        val textView: TextView = view.findViewById(R.id.itemName)

        val item = items[position]
        textView.text = item.name
        checkBox.isChecked = item.isChecked

        // Обновляем состояние при изменении чекбокса
        checkBox.setOnCheckedChangeListener { _, isChecked ->
            item.isChecked = isChecked
        }

        return view
    }

}
