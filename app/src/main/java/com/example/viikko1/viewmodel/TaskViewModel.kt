package com.example.viikko1.viewmodel


import androidx.lifecycle.ViewModel
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import com.example.viikko1.domain.Task

class TaskViewModel : ViewModel() {
    var tasks by mutableStateOf(listOf<Task>())
        private set

    init {
        tasks = listOf(
            Task(1, "Compose UI", "Build first screen", 1, "2026-01-20", false),
            Task(2, "ViewModel", "Add state management", 2, "2026-01-22", false),
            Task(3, "Demo video", "Record YouTube demo", 3, "2026-01-25", true)
        )
    }

    fun addTask(task: Task) {
        tasks = tasks + task
    }

    fun toggleDone(id: Int) {
        tasks = tasks.map { if (it.id == id) it.copy(done = !it.done) else it }
    }

    fun removeTask(id: Int) {
        tasks = tasks.filter { it.id != id }
    }

    fun filterByDone(done: Boolean) {
        tasks = tasks.filter { it.done == done }
    }

    fun sortByDueDate() {
        tasks = tasks.sortedBy { it.dueDate }
    }
}

