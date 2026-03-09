package com.example.taskmanagerapp.domain.usecase

import com.example.taskmanagerapp.domain.repository.TaskRepository
import javax.inject.Inject

class GetTasksUseCase @Inject constructor(private val repository: TaskRepository) {
    operator fun invoke() = repository.getTasks()
}