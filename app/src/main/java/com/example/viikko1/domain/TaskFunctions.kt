package com.example.viikko1.domain


fun addTask(list: List<Task>, task: Task): List<Task> {
    return list + task
}


/**
 * Vaihtaa tehtävän "done"-tilan annetun id:n perusteella.
 *
 * @param list Lista tehtävistä (Task)
 * @param id Tehtävän tunniste, jonka tilaa halutaan vaihtaa
 * @return Uusi lista, jossa valitun tehtävän done-arvo on käännetty (true -> false tai false -> true)
 */
fun toggleDone(list: List<Task>, id: Int): List<Task> {
    return list.map { task ->
        // Jos tehtävän id vastaa annettua id:tä, luodaan kopio ja vaihdetaan done-arvo
        if (task.id == id) {
            task.copy(done = !task.done)
        } else {
            // Muuten palautetaan tehtävä sellaisenaan
            task
        }
    }
}


fun filterByDone(list: List<Task>, done: Boolean): List<Task> {
    return list.filter { it.done == done }
}

fun sortByDueDate(list: List<Task>): List<Task> {
    return list.sortedBy { it.dueDate }
}
