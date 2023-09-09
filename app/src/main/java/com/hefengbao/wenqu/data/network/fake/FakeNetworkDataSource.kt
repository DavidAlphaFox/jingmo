package com.hefengbao.wenqu.data.network.fake

import com.hefengbao.wenqu.common.network.AppDispatchers
import com.hefengbao.wenqu.common.network.Dispatcher
import com.hefengbao.wenqu.data.model.ChineseWisecrack
import com.hefengbao.wenqu.data.model.Idiom
import com.hefengbao.wenqu.data.model.Poem
import com.hefengbao.wenqu.data.model.PoemSentence
import com.hefengbao.wenqu.data.model.PoemTag
import com.hefengbao.wenqu.data.model.Tag
import com.hefengbao.wenqu.data.model.Writer
import com.hefengbao.wenqu.data.network.JvmUnitTestFakeAssetManager
import com.hefengbao.wenqu.data.network.NetworkDataSource
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.withContext
import kotlinx.serialization.ExperimentalSerializationApi
import kotlinx.serialization.json.Json
import kotlinx.serialization.json.decodeFromStream
import javax.inject.Inject

/**
 * [NetworkDataSource] implementation that provides static news resources to aid development
 */
@OptIn(ExperimentalSerializationApi::class)
class FakeNetworkDataSource @Inject constructor(
    @Dispatcher(AppDispatchers.IO) private val ioDispatcher: CoroutineDispatcher,
    private val networkJson: Json,
    private val assets: FakeAssetManager = JvmUnitTestFakeAssetManager,
) : NetworkDataSource {

    override suspend fun getPoems(): List<Poem> =
        withContext(ioDispatcher) {
            assets.open(POEMS_ASSET).use(networkJson::decodeFromStream)
        }

    override suspend fun getWriters(): List<Writer> =
        withContext(ioDispatcher) {
            assets.open(WRITERS_ASSET).use(networkJson::decodeFromStream)
        }

    override suspend fun getTags(): List<Tag> =
        withContext(ioDispatcher) {
            assets.open(TAGS_ASSET).use(networkJson::decodeFromStream)
        }

    override suspend fun getPoemTagList(): List<PoemTag> =
        withContext(ioDispatcher) {
            assets.open(POEM_TAG_ASSET).use(networkJson::decodeFromStream)
        }

    override suspend fun getPoemSentences(): List<PoemSentence> =
        withContext(ioDispatcher) {
            assets.open(POEM_SENTENCE_ASSET).use(networkJson::decodeFromStream)
        }

    override suspend fun getChineseWisecracks(): List<ChineseWisecrack> =
        withContext(ioDispatcher) {
            assets.open(CHINESE_WISECRACK_ASSET).use(networkJson::decodeFromStream)
        }

    override suspend fun getIdioms(): List<Idiom> =
        withContext(ioDispatcher) {
            assets.open(IDIOM_ASSET).use(networkJson::decodeFromStream)
        }

    companion object {
        private const val POEMS_ASSET = "json/poems.json"
        private const val WRITERS_ASSET = "json/writers.json"
        private const val TAGS_ASSET = "json/tags.json"
        private const val POEM_TAG_ASSET = "json/poem_tag.json"
        private const val POEM_SENTENCE_ASSET = "json/poem_sentences.json"
        private const val CHINESE_WISECRACK_ASSET = "json/chinese_wisecracks.json"
        private const val IDIOM_ASSET = "json/idioms.json"
    }
}