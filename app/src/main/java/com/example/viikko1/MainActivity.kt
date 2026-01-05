package com.example.viikko1

import ads_mobile_sdk.h5
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.viikko1.domain.Task
import com.example.viikko1.domain.addTask
import com.example.viikko1.domain.mockTasks
import com.example.viikko1.ui.theme.Viikko1Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            HomeScreen()
        }
    }
}



@Composable
fun HomeScreen() {
    var taskList by remember { mutableStateOf(mockTasks) }

    Column(modifier = Modifier.padding(16.dp)) {
        Text(text = "Task List", style = MaterialTheme.typography.headlineSmall)
        Spacer(modifier = Modifier.height(8.dp))
        taskList.forEach { task ->
            Text(text = "${task.title} - Due: ${task.dueDate}")
        }


        Button(onClick = {
            val newTask = Task(
                id = taskList.size + 1,
                title = "New Task",
                description = "Added from button",
                priority = 1,
                dueDate = "2026-01-10",
                done = false
            )
            taskList = addTask(taskList, newTask) // Käytä aiemmin tehtyä funktiota
        }) {
            Text("Add Task")
        }

    }
}


