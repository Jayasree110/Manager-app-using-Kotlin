package com.example.taskmanagerapp.data.repository

import com.example.taskmanagerapp.domain.model.Task
import com.example.taskmanagerapp.domain.repository.TaskRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import javax.inject.Inject

class InMemoryTaskRepository @Inject constructor() : TaskRepository {
    private val tasks = MutableStateFlow<List<Task>>(emptyList())

    override fun getTasks(): Flow<List<Task>> = tasks

    override suspend fun addTask(task: Task) {
        tasks.value += task
    }

    override suspend fun toggleTaskCompletion(taskId: Int) {
        tasks.value = tasks.value.map {
            if (it.id == taskId) it.copy(isCompleted = !it.isCompleted) else it
        }
    }

    override suspend fun deleteTask(taskId: Int) {
        tasks.value = tasks.value.filterNot { it.id == taskId }
    }
}