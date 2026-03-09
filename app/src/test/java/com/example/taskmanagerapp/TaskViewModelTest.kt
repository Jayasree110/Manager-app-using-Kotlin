package com.example.taskmanagerapp

import com.example.taskmanagerapp.domain.usecase.AddTaskUseCase
import com.example.taskmanagerapp.domain.usecase.DeleteTaskUseCase
import com.example.taskmanagerapp.domain.usecase.GetTasksUseCase
import com.example.taskmanagerapp.domain.usecase.ToggleTaskCompletionUseCase
import com.example.taskmanagerapp.presentation.viewmodel.TaskViewModel
import io.mockk.*
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.flowOf
import kotlinx.coroutines.test.*
import org.junit.After
import org.junit.Before
import org.junit.Test

@OptIn(ExperimentalCoroutinesApi::class)
class TaskViewModelTest {

    private val testDispatcher = StandardTestDispatcher()
    private lateinit var getTasksUseCase: GetTasksUseCase
    private lateinit var addTaskUseCase: AddTaskUseCase
    private lateinit var toggleTaskCompletionUseCase: ToggleTaskCompletionUseCase
    private lateinit var deleteTaskUseCase: DeleteTaskUseCase
    private lateinit var viewModel: TaskViewModel

    @Before
    fun setup() {
        Dispatchers.setMain(testDispatcher)
        getTasksUseCase = mockk()
        addTaskUseCase = mockk(relaxed = true)
        toggleTaskCompletionUseCase = mockk(relaxed = true)
        deleteTaskUseCase = mockk(relaxed = true)

        every { getTasksUseCase() } returns flowOf(emptyList())

        viewModel = TaskViewModel(
            getTasksUseCase,
            addTaskUseCase,
            toggleTaskCompletionUseCase,
            deleteTaskUseCase
        )
    }

    @After
    fun tearDown() {
        Dispatchers.resetMain()
    }

    @Test
    fun `addTask calls AddTaskUseCase with correct Task`() = runTest {
        viewModel.addTask("New Task")
        advanceUntilIdle() // Ensure coroutine completes

        coVerify {
            addTaskUseCase(match {
                it.title == "New Task" && it.isCompleted == false
            })
        }
    }

    @Test
    fun `toggleTask calls ToggleTaskCompletionUseCase with correct ID`() = runTest {
        viewModel.toggleTask(1)
        advanceUntilIdle()

        coVerify { toggleTaskCompletionUseCase(1) }
    }

    @Test
    fun `deleteTask calls DeleteTaskUseCase with correct ID`() = runTest {
        viewModel.deleteTask(1)
        advanceUntilIdle()

        coVerify { deleteTaskUseCase(1) }
    }
}