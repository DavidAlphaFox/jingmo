package com.hefengbao.jingmo.data.database.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Transaction
import com.hefengbao.jingmo.data.database.entity.PoemSentenceEntity
import com.hefengbao.jingmo.data.database.entity.SentenceWithPoem
import kotlinx.coroutines.flow.Flow

@Dao
interface PoemSentenceDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(entity: PoemSentenceEntity)

    @Transaction
    @Query("select * from poem_sentences where id = :id")
    suspend fun getSentenceWithPoem(id: Long): SentenceWithPoem

    @Query("select * from poem_sentences where id = :id")
    fun getSentence(id: Long): Flow<PoemSentenceEntity>

    @Query("select id from poem_sentences where id > :id order by id asc limit 1")
    suspend fun getNextId(id: Long): Long

    @Query("select id from poem_sentences where id < :id order by id desc limit 1")
    suspend fun getPrevId(id: Long): Long

    @Query("select * from poem_sentences where content like :query")
    fun searchSentencesList(query: String): Flow<List<PoemSentenceEntity>>

    @Query("select id from poem_sentences where id > :id and content like :query order by id asc limit 1")
    suspend fun getSearchNextId(id: Long, query: String): Long

    @Query("select id from poem_sentences where id < :id and content like :query order by id desc limit 1")
    suspend fun getSearchPrevId(id: Long, query: String): Long
}