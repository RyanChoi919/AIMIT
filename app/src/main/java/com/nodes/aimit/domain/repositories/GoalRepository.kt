package com.nodes.aimit.domain.repositories

import com.nodes.aimit.domain.entity.Goal
import com.nodes.aimit.domain.dao.GoalDao

class GoalRepository(goalDao: GoalDao) : AppRepository<Goal>(goalDao)