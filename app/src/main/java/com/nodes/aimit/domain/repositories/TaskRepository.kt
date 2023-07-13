package com.nodes.aimit.domain.repositories

import com.nodes.aimit.domain.entity.Task
import com.nodes.aimit.domain.dao.TaskDao

class TaskRepository(taskDao: TaskDao) : AppRepository<Task>(taskDao)