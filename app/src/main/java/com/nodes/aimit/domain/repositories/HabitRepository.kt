package com.nodes.aimit.domain.repositories

import com.nodes.aimit.domain.entity.Habit
import com.nodes.aimit.domain.dao.HabitDao

class HabitRepository(habitDao: HabitDao) : AppRepository<Habit>(habitDao)