package com.example.taskmanagerapp

import com.example.taskmanagerapp.domain.repository.TaskRepository
import com.example.taskmanagerapp.domain.usecase.GetTasksUseCase
import io.mockk.coEvery
import io.mockk.mockk
import junit.framework.TestCase.assertEquals
import kotlinx.coroutines.flow.flowOf
import kotlinx.coroutines.test.runTest
import org.junit.Before
import org.junit.Test

class GetTasksUseCaseTest {

    private lateinit var repository: TaskRepository
    private lateinit var getTasksUseCase: GetTasksUseCase

    @Before
    fun setUp() {
        repository = mockk()
        getTasksUseCase = GetTasksUseCase(repository)
    }

    @Test
    fun `invoke returns tasks flow from repository`() = runTest {
        val expected = listOf(
            com.example.taskmanagerapp.domain.model.Task(1, "Task 1", false),
            com.example.taskmanagerapp.domain.model.Task(2, "Task 2", true)
        )
        coEvery { repository.getTasks() } returns flowOf(expected)

        val result = getTasksUseCase()

        result.collect {
            assertEquals(expected, it)
        }
    }
}