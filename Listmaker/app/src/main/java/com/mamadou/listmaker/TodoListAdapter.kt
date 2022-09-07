package com.mamadou.listmaker

import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

class TodoListAdapter : RecyclerView.Adapter<TodoListViewHolder>() {
    // Add an instance variable
    private val todoLists = arrayOf("Android Development", "House Work", "Errands")
    // This function creates a new View Holder
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TodoListViewHolder {
        TODO("Not yet implemented")
    }
// This function customize the view
    override fun onBindViewHolder(holder: TodoListViewHolder, position: Int) {
        TODO("Not yet implemented")
    }
// This function count the Total amount of rows in list
    override fun getItemCount(): Int {
        return todoLists.size // size of our instance variable. Number of elements in the array
    }
}