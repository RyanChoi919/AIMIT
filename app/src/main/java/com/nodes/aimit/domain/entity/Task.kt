package com.nodes.aimit.domain.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "tasks")
data class Task(
    @PrimaryKey(autoGenerate = true)
    override val id : Long,
    override val name: String
) : AimitEntity(id, name)
