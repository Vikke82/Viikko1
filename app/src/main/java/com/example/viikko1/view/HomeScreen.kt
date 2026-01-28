package com.example.viikko1.view

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.Checkbox
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.viikko1.viewmodel.TaskViewModel


@Composable
fun HomeScreen(viewModel: TaskViewModel = viewModel()) {
    val tasks by viewModel.tasks.collectAsState()
    val selectedTask by viewModel.selectedTask.collectAsState()



    Column(modifier = Modifier.padding(16.dp)) {
        Text("Task List", style = MaterialTheme.typography.headlineMedium)

        LazyColumn() {
            items(tasks) { task ->
                Card(modifier = Modifier
                    .padding(8.dp)
                    .clickable { viewModel.selectTask(task) }) {
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(8.dp),
                        horizontalArrangement = Arrangement.SpaceBetween
                    ) {
                        Column {
                            Text(task.title, style = MaterialTheme.typography.headlineSmall)
                            Text(task.description)
                        }
                        Checkbox(
                            checked = task.done,
                            onCheckedChange = { viewModel.toggleDone(task.id) }
                        )
                    }
                }
            }
        }
    }

    // Näytä dialog, jos selectedTask != null
    if (selectedTask != null) {
        DetailDialog(task = selectedTask!!, onClose = { viewModel.closeDialog() }, onUpdate = { viewModel.updateTask(it) })
    }
}
