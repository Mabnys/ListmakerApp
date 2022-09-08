package com.mamadou.listmaker

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

class TodoListAdapter : RecyclerView.Adapter<TodoListViewHolder>() {
    // Add an instance variable
    private var todoLists = mutableListOf("Android Development", "House Work", "Errands", "Shopping")

    fun addNewItem(listName: String = "") {
        if (listName.isEmpty()) {
            todoLists.add("Todo List " + (todoLists.size + 1))
        }
        else {
            todoLists.add(listName)
        }
        notifyDataSetChanged() // Tells the RecycleView to reload all the data
    }
    // This function creates a new View Holder
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TodoListViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.todo_list_view_holder, parent, false)
        return TodoListViewHolder(view)
    }

// This function count the Total amount of rows in list
    override fun getItemCount(): Int {
        return todoLists.size // size of our instance variable. Number of elements in the array
    }

    // This function customize the view
    @SuppressLint("SetTextI18n")
    override fun onBindViewHolder(holder: TodoListViewHolder, position: Int) {

        holder.listPositionTextView.text = (position + 1).toString()
        holder.listPositionTextView.text = todoLists[position]
    }
}