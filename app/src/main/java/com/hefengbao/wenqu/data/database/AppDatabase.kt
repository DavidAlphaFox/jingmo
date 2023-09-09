package com.hefengbao.wenqu.data.database

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.hefengbao.wenqu.data.database.dao.ChineseWisecrackDao
import com.hefengbao.wenqu.data.database.dao.IdiomDao
import com.hefengbao.wenqu.data.database.dao.PoemDao
import com.hefengbao.wenqu.data.database.dao.PoemSentenceDao
import com.hefengbao.wenqu.data.database.dao.PoemTagDao
import com.hefengbao.wenqu.data.database.dao.TagDao
import com.hefengbao.wenqu.data.database.dao.WriterDao
import com.hefengbao.wenqu.data.database.entity.ChineseWisecrackEntity
import com.hefengbao.wenqu.data.database.entity.IdiomEntity
import com.hefengbao.wenqu.data.database.entity.PoemEntity
import com.hefengbao.wenqu.data.database.entity.PoemSentenceEntity
import com.hefengbao.wenqu.data.database.entity.PoemTagCrossRef
import com.hefengbao.wenqu.data.database.entity.TagEntity
import com.hefengbao.wenqu.data.database.entity.WriterEntity
import com.hefengbao.wenqu.data.database.util.DetailInfoListConverter

@Database(
    entities = [
        ChineseWisecrackEntity::class,
        IdiomEntity::class,
        PoemEntity::class,
        PoemSentenceEntity::class,
        PoemTagCrossRef::class,
        TagEntity::class,
        WriterEntity::class,
    ],
    version = 1,
    exportSchema = false
)
@TypeConverters(
    DetailInfoListConverter::class
)
abstract class AppDatabase : RoomDatabase() {
    abstract fun poemDao(): PoemDao
    abstract fun tagDao(): TagDao
    abstract fun poemTagDao(): PoemTagDao
    abstract fun writerDao(): WriterDao
    abstract fun poemSentenceDao(): PoemSentenceDao
    abstract fun chineseWisecrackDao(): ChineseWisecrackDao
    abstract fun idiomDao(): IdiomDao
}