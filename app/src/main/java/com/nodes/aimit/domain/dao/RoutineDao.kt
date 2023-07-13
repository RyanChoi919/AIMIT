package com.nodes.aimit.domain.dao

import androidx.room.Dao
import androidx.room.Query
import com.nodes.aimit.domain.entity.Routine

@Dao
interface RoutineDao : BaseDao<Routine> {
    
    @Query("SELECT * FROM routines")
    override fun getAllEntities(): List<Routine>
}