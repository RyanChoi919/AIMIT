package com.nodes.aimit.domain.dao

import androidx.room.Dao
import androidx.room.Query
import com.nodes.aimit.domain.entity.Goal

@Dao
interface GoalDao : BaseDao<Goal> {

    @Query("SELECT * FROM goals")
    override fun getAllEntities(): List<Goal>
}