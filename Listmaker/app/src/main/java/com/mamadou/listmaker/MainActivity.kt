package com.mamadou.listmaker

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
//import androidx.navigation.findNavController
//import androidx.navigation.ui.AppBarConfiguration
//import androidx.navigation.ui.navigateUp
//import androidx.navigation.ui.setupActionBarWithNavController
import android.view.Menu
import android.view.MenuItem
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.mamadou.listmaker.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    // Note that lateinit keyword indicates that a RecyclerView is going to be created sometime in the future as opposed to when the activity is created.
    // Otherwise, we need to initialize the value right away, which a problem since our activity takes a little time to be generated.
    private lateinit var todoListRecyclerView: RecyclerView

//    private lateinit var appBarConfiguration: AppBarConfiguration
    private lateinit var binding: ActivityMainBinding

//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//
//        binding = ActivityMainBinding.inflate(layoutInflater)
//        setContentView(binding.root)
//
//        setSupportActionBar(binding.toolbar)
//
//        val navController = findNavController(R.id.nav_host_fragment_content_main)
//        appBarConfiguration = AppBarConfiguration(navController.graph)
//        setupActionBarWithNavController(navController, appBarConfiguration)
//
//        binding.fab.setOnClickListener { view ->
//            Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
//                .setAction("Action", null).show()
//        }
//    }

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
            val adapter = todoListRecyclerView.adapter as TodoListAdapter
            adapter.addNewItem()
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

//    override fun onSupportNavigateUp(): Boolean {
//        val navController = findNavController(R.id.nav_host_fragment_content_main)
//        return navController.navigateUp(appBarConfiguration)
//                || super.onSupportNavigateUp()
//    }
}