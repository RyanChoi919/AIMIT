package com.nodes.aimit.domain

import androidx.room.Database
import androidx.room.RoomDatabase
import com.nodes.aimit.domain.dao.GoalDao
import com.nodes.aimit.domain.dao.HabitDao
import com.nodes.aimit.domain.dao.RoutineDao
import com.nodes.aimit.domain.dao.TaskDao
import com.nodes.aimit.domain.entity.Goal
import com.nodes.aimit.domain.entity.Habit
import com.nodes.aimit.domain.entity.Routine
import com.nodes.aimit.domain.entity.Task

@Database(entities = [Goal::class, Habit::class, Routine::class, Task::class], version = 1)
abstract class AppDatabase : RoomDatabase() {
    abstract fun goalDao(): GoalDao
    abstract fun habitDao(): HabitDao
    abstract fun routineDao(): RoutineDao
    abstract fun taskDao(): TaskDao
}