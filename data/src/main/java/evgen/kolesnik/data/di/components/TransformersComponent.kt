package evgen.kolesnik.data.di.components

import dagger.Component
import evgen.kolesnik.data.di.modules.TransformersModule
import evgen.kolesnik.data.transformers.SourceEntityToSourceDtoTransformer
import evgen.kolesnik.data.transformers.SourceModelToSourceDtoTransformer
import evgen.kolesnik.data.transformers.SourceModelToSourceEntityTransformer

@Component(modules = [TransformersModule::class])
interface TransformersComponent {

    fun transformModelToDto(): SourceModelToSourceDtoTransformer

    fun transformModelToEntity(): SourceModelToSourceEntityTransformer

    fun transformEntityToDto(): SourceEntityToSourceDtoTransformer

}