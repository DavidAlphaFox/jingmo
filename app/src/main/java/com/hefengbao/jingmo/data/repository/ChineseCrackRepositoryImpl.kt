package com.hefengbao.jingmo.data.repository

import com.hefengbao.jingmo.data.database.dao.ChineseWisecrackDao
import com.hefengbao.jingmo.data.database.entity.ChineseWisecrackEntity
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class ChineseCrackRepositoryImpl @Inject constructor(
    private val chineseWisecrackDao: ChineseWisecrackDao
) : ChineseWisecrackRepository {
    override suspend fun getChineseCrack(id: Long): ChineseWisecrackEntity =
        chineseWisecrackDao.getChineseWisecrack(id)

    override suspend fun getNextId(id: Long): Long = chineseWisecrackDao.getNextId(id)
    override suspend fun getPrevId(id: Long): Long = chineseWisecrackDao.getPrevId(id)
    override fun searchWisecrackList(query: String): Flow<List<ChineseWisecrackEntity>> =
        chineseWisecrackDao.searchWisecrackList("%$query%")

    override suspend fun getSearchNextId(id: Long, query: String): Long =
        chineseWisecrackDao.getSearchNextId(id, "%$query%")

    override suspend fun getSearchPrevId(id: Long, query: String): Long =
        chineseWisecrackDao.getSearchPrevId(id, "%$query%")
}