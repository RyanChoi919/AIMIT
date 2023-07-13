package com.nodes.aimit.domain.dao

import androidx.room.Dao
import androidx.room.Query
import com.nodes.aimit.domain.entity.Habit

@Dao
interface HabitDao : BaseDao<Habit> {

    @Query("SELECT * FROM habits")
    override fun getAllEntities(): List<Habit>
}