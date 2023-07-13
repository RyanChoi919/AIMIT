package com.nodes.aimit.domain.repositories

import com.nodes.aimit.domain.dao.BaseDao
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

abstract class AppRepository<T>(private val dao: BaseDao<T>) {
    suspend fun getEntities(): List<T> {
        return withContext(Dispatchers.IO) {
            dao.getAllEntities()
        }
    }

    suspend fun insert(t: T) {
        withContext(Dispatchers.IO) {
            dao.insert(t)
        }
    }

    suspend fun update(t: T) {
        withContext(Dispatchers.IO) {
            dao.update(t)
        }
    }

    suspend fun delete(t: T) {
        withContext(Dispatchers.IO) {
            dao.delete(t)
        }
    }
}