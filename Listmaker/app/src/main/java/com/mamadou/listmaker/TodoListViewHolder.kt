package com.mamadou.listmaker

import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class TodoListViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    // Create 2 properties to change the actual text within the view
    var listPositionTextView = itemView.findViewById<TextView>(R.id.itemNumber)
    var listTitleTextView = itemView.findViewById<TextView>(R.id.itemNumber)
}