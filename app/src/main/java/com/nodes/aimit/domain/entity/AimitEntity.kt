package com.nodes.aimit.domain.entity

import androidx.room.PrimaryKey

sealed class AimitEntity(
    @PrimaryKey(autoGenerate = true)
    open val id: Long,
    open val name: String
)