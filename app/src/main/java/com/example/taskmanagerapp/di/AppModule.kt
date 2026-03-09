package com.example.taskmanagerapp.di

import com.example.taskmanagerapp.data.repository.InMemoryTaskRepository
import com.example.taskmanagerapp.domain.repository.TaskRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideTaskRepository(): TaskRepository = InMemoryTaskRepository()
}