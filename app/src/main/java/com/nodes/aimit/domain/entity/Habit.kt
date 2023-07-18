package com.nodes.aimit.domain.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "habits")
data class Habit(
    @PrimaryKey(autoGenerate = true)
    override val id : Long,
    override val name: String
) : AimitEntity(id, name)
