package com.mamadou.listmaker

import android.os.Bundle
import android.text.InputType
import androidx.appcompat.app.AppCompatActivity
//import androidx.navigation.findNavController
//import androidx.navigation.ui.AppBarConfiguration
//import androidx.navigation.ui.navigateUp
//import androidx.navigation.ui.setupActionBarWithNavController
import android.view.Menu
import android.view.MenuItem
import android.widget.EditText
import androidx.appcompat.app.AlertDialog
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.mamadou.listmaker.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {
    // Note that lateinit keyword indicates that a RecyclerView is going to be created sometime in the future as opposed to when the activity is created.
    // Otherwise, we need to initialize the value right away, which a problem since our activity takes a little time to be generated.
    private lateinit var todoListRecyclerView: RecyclerView

//    private lateinit var appBarConfiguration: AppBarConfiguration
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(binding.toolbar)

        // Adding a reference to the RecyclerView by calling the function findViewById()
        todoListRecyclerView = findViewById(R.id.lists_recyclerview)
        // The RecyclerView needs to know which layout we are going to use for placing items. In our case, the Linear layout, which is a great way to place items.
        todoListRecyclerView.layoutManager = LinearLayoutManager(this)
        // Assign the Adapter (TodoListAdapter) to the RecyclerView by creating a new Adapter
        todoListRecyclerView.adapter = TodoListAdapter()



        binding.fab.setOnClickListener {
            showCreateTodoListDialog()
        }
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.menu_main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        return when (item.itemId) {
            R.id.action_settings -> true
            else -> super.onOptionsItemSelected(item)
        }
    }

    private fun showCreateTodoListDialog() {
        val dialogTitle = getString(R.string.name_of_list)
        val positiveButtonTitle = getString(R.string.create_list)
        val myDialog = AlertDialog.Builder(this)
        val todoTitleEditText = EditText(this)
        todoTitleEditText.inputType = InputType.TYPE_CLASS_TEXT or InputType.TYPE_TEXT_FLAG_CAP_WORDS

        myDialog.setTitle(dialogTitle)
        myDialog.setView(todoTitleEditText)

        myDialog.setPositiveButton(positiveButtonTitle) {
            dialog, _ ->
            dialog.dismiss()
        }
        myDialog.create().show()
    }
}