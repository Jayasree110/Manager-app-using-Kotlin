package com.example.taskmanagerapp.domain.repository

import com.example.taskmanagerapp.domain.model.Task
import kotlinx.coroutines.flow.Flow

interface TaskRepository {
    fun getTasks(): Flow<List<Task>>
    suspend fun addTask(task: Task)
    suspend fun toggleTaskCompletion(taskId: Int)
    suspend fun deleteTask(taskId: Int)
}