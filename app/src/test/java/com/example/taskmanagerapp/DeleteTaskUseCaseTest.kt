package com.example.taskmanagerapp

import com.example.taskmanagerapp.domain.repository.TaskRepository
import com.example.taskmanagerapp.domain.usecase.DeleteTaskUseCase
import io.mockk.coVerify
import io.mockk.mockk
import kotlinx.coroutines.test.runTest
import org.junit.Before
import org.junit.Test

class DeleteTaskUseCaseTest {

    private lateinit var repository: TaskRepository
    private lateinit var deleteTaskUseCase: DeleteTaskUseCase

    @Before
    fun setUp() {
        repository = mockk(relaxed = true)
        deleteTaskUseCase = DeleteTaskUseCase(repository)
    }

    @Test
    fun `invoke calls repository deleteTask with task id`() = runTest {
        val taskId = 1

        deleteTaskUseCase(taskId)

        coVerify { repository.deleteTask(taskId) }
    }
}