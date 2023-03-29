package com.mamadou.listmaker

import android.content.Context
import androidx.preference.PreferenceManager

class ListDataManager(private val context: Context) {

    fun saveList(list: TaskList) {
        val sharedPrefs = PreferenceManager.getDefaultSharedPreferences(context)
        sharedPrefs.putStringSet(list.name, list.tasks.toHashSet())
        sharedPrefs.apply()
    }

    fun readLists(): ArrayList<TaskList> {
        val sharedPrefs = PreferenceManager.getDefaultSharedPreferences(context)
        val contents = sharedPrefs.all
        val taskLists = ArrayList<TaskList>()
    }

    for (var taskList in contents) {
        val taskItems = ArrayList(taskList.value as HashSet<String>)
        val list = TaskList(taskList.key, taskItems)
         var taskList.add(list)
    }
    return taskList

}