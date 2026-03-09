package com.example.taskmanagerapp.presentation.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.taskmanagerapp.domain.model.Task
import com.example.taskmanagerapp.domain.usecase.AddTaskUseCase
import com.example.taskmanagerapp.domain.usecase.DeleteTaskUseCase
import com.example.taskmanagerapp.domain.usecase.GetTasksUseCase
import com.example.taskmanagerapp.domain.usecase.ToggleTaskCompletionUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class TaskViewModel @Inject constructor(
    private val getTasksUseCase: GetTasksUseCase,
    private val addTaskUseCase: AddTaskUseCase,
    private val toggleTaskCompletionUseCase: ToggleTaskCompletionUseCase,
    private val deleteTaskUseCase: DeleteTaskUseCase
) : ViewModel() {

    val tasks = getTasksUseCase().stateIn(viewModelScope, SharingStarted.Lazily, emptyList())

    fun addTask(title: String) {
        viewModelScope.launch {
            addTaskUseCase(Task(id = tasks.value.size + 1, title = title))
        }
    }

    fun toggleTask(taskId: Int) {
        viewModelScope.launch {
            toggleTaskCompletionUseCase(taskId)
        }
    }

    fun deleteTask(taskId: Int) {
        viewModelScope.launch {
            deleteTaskUseCase(taskId)
        }
    }
}