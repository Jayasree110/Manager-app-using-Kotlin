package com.example.taskmanagerapp

import com.example.taskmanagerapp.domain.repository.TaskRepository
import com.example.taskmanagerapp.domain.usecase.ToggleTaskCompletionUseCase
import io.mockk.coVerify
import io.mockk.mockk
import kotlinx.coroutines.test.runTest
import org.junit.Before
import org.junit.Test

class ToggleTaskCompletionUseCaseTest {

    private lateinit var repository: TaskRepository
    private lateinit var toggleTaskCompletionUseCase: ToggleTaskCompletionUseCase

    @Before
    fun setUp() {
        repository = mockk(relaxed = true)
        toggleTaskCompletionUseCase = ToggleTaskCompletionUseCase(repository)
    }

    @Test
    fun `invoke calls repository toggleTaskCompletion with task id`() = runTest {
        val taskId = 1

        toggleTaskCompletionUseCase(taskId)

        coVerify { repository.toggleTaskCompletion(taskId) }
    }
}