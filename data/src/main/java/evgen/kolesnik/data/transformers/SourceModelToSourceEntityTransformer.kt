package evgen.kolesnik.data.transformers

import evgen.kolesnik.data.base.transformer.Transformer
import evgen.kolesnik.data.models.SourceModel
import evgen.kolesnik.data.room.entities.SourceEntity
import evgen.kolesnik.domain.STRING_NOT_AVAILABLE

class SourceModelToSourceEntityTransformer : Transformer<MutableList<SourceModel>, MutableList<SourceEntity>> {
    override var convert: (MutableList<SourceModel>) -> MutableList<SourceEntity> =
        { data ->
            data.map {
                SourceEntity(
                    id = it.id ?: STRING_NOT_AVAILABLE,
                    title = it.title ?: STRING_NOT_AVAILABLE,
                    description = it.description ?: STRING_NOT_AVAILABLE,
                    url = it.url ?: STRING_NOT_AVAILABLE,
                    category = it.category ?: STRING_NOT_AVAILABLE,
                    language = it.language ?: STRING_NOT_AVAILABLE,
                    country = it.country ?: STRING_NOT_AVAILABLE
                )
            }.toMutableList()
        }
}