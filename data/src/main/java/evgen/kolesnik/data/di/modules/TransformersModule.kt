package evgen.kolesnik.data.di.modules

import dagger.Module
import dagger.Provides
import evgen.kolesnik.data.transformers.SourceEntityToSourceDtoTransformer
import evgen.kolesnik.data.transformers.SourceModelToSourceDtoTransformer
import evgen.kolesnik.data.transformers.SourceModelToSourceEntityTransformer

@Module
class TransformersModule {

    @Provides
    fun provideModelToDtoTransformer(): SourceModelToSourceDtoTransformer {
        return SourceModelToSourceDtoTransformer()
    }

    @Provides
    fun provideModelToEntityTransformer(): SourceModelToSourceEntityTransformer {
        return SourceModelToSourceEntityTransformer()
    }

    @Provides
    fun provideEntityToDtoTransformer(): SourceEntityToSourceDtoTransformer {
        return SourceEntityToSourceDtoTransformer()
    }

}