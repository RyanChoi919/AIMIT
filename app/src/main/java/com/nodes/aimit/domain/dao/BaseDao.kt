package com.nodes.aimit.domain.dao

import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Update


interface BaseDao<T> {

    fun getAllEntities(): List<T>

    @Insert
    fun insert(t: T)

    @Update
    fun update(t: T)

    @Delete
    fun delete(t: T)
}