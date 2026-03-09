package com.example.taskmanagerapp

import com.example.taskmanagerapp.domain.model.Task
import com.example.taskmanagerapp.domain.repository.TaskRepository
import com.example.taskmanagerapp.domain.usecase.AddTaskUseCase
import io.mockk.coVerify
import io.mockk.mockk
import kotlinx.coroutines.test.runTest
import org.junit.Before
import org.junit.Test

class AddTaskUseCaseTest {

    private lateinit var repository: TaskRepository
    private lateinit var addTaskUseCase: AddTaskUseCase

    @Before
    fun setUp() {
        repository = mockk(relaxed = true)
        addTaskUseCase = AddTaskUseCase(repository)
    }

    @Test
    fun `invoke calls repository addTask`() = runTest {
        val task = Task(id = 1, title = "MockK Test", isCompleted = false)

        addTaskUseCase(task)

        coVerify { repository.addTask(task) }
    }
}


