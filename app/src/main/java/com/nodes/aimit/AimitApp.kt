package com.nodes.aimit

import android.app.Application
import androidx.room.Room
import com.nodes.aimit.domain.AppDatabase
import com.nodes.aimit.domain.repositories.GoalRepository
import com.nodes.aimit.domain.repositories.HabitRepository
import com.nodes.aimit.domain.repositories.RoutineRepository
import com.nodes.aimit.domain.repositories.TaskRepository

class AimitApp : Application() {
    companion object {
        lateinit var database: AppDatabase
        lateinit var goalRepository: GoalRepository
            private set
        lateinit var habitRepository: HabitRepository
            private set
        lateinit var routineRepository: RoutineRepository
            private set
        lateinit var taskRepository: TaskRepository
            private set
    }

    override fun onCreate() {
        super.onCreate()
        database =
            Room.databaseBuilder(applicationContext, AppDatabase::class.java, "AIMITDatabase")
                .build()

        with(database) {
            goalRepository = GoalRepository(goalDao())
            habitRepository = HabitRepository(habitDao())
            routineRepository = RoutineRepository(routineDao())
            taskRepository = TaskRepository(taskDao())
        }

    }
}