package com.nodes.aimit.domain.repositories

import com.nodes.aimit.domain.entity.Routine
import com.nodes.aimit.domain.dao.RoutineDao

class RoutineRepository(routineDao: RoutineDao) : AppRepository<Routine>(routineDao)