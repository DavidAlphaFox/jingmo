package com.hefengbao.jingmo.data.repository

import com.hefengbao.jingmo.data.database.entity.PoemSentenceEntity
import com.hefengbao.jingmo.data.database.entity.SentenceWithPoem
import kotlinx.coroutines.flow.Flow

interface PoemSentenceRepository {
    suspend fun getSentenceWithPoem(id: Long): SentenceWithPoem
    suspend fun getNextId(id: Long): Long
    suspend fun getPrevId(id: Long): Long
    fun searchSentencesList(query: String): Flow<List<PoemSentenceEntity>>
    suspend fun getSentence(id: Long): Flow<PoemSentenceEntity>
    suspend fun getSearchNextId(id: Long, query: String): Long
    suspend fun getSearchPrevId(id: Long, query: String): Long
}