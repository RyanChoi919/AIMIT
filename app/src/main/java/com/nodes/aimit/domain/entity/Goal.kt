package com.nodes.aimit.domain.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "goals")
data class Goal(
    @PrimaryKey
    override val id: Long,
    override val name: String
) : AimitEntity(id, name)
