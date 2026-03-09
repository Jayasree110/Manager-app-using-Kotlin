package com.example.taskmanagerapp.domain.usecase

import com.example.taskmanagerapp.domain.repository.TaskRepository
import javax.inject.Inject

class ToggleTaskCompletionUseCase @Inject constructor(private val repository: TaskRepository) {
    suspend operator fun invoke(taskId: Int) = repository.toggleTaskCompletion(taskId)
}