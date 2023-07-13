package com.nodes.aimit.domain.dao

import androidx.room.Dao
import androidx.room.Query
import com.nodes.aimit.domain.entity.Task

@Dao
interface TaskDao : BaseDao<Task> {

    @Query("SELECT * FROM tasks")
    override fun getAllEntities(): List<Task>
}