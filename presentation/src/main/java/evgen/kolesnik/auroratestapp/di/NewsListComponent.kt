package evgen.kolesnik.auroratestapp.di

import dagger.BindsInstance
import dagger.Component
import evgen.kolesnik.auroratestapp.DI
import evgen.kolesnik.data.di.ViewModelFactory
import evgen.kolesnik.data.di.scope.NewsListScope
import evgen.kolesnik.data.network.service.NewsApi
import evgen.kolesnik.data.room.SourceDAO
import evgen.kolesnik.data.transformers.SourceEntityToSourceDtoTransformer
import evgen.kolesnik.data.transformers.SourceModelToSourceDtoTransformer
import evgen.kolesnik.data.transformers.SourceModelToSourceEntityTransformer
import evgen.kolesnik.data.util.ResourceProvider

@Component(modules = [NewsListModule::class])
@NewsListScope
interface NewsListComponent {

    fun viewModelFactory(): ViewModelFactory

    @Component.Builder
    interface Builder {
        @BindsInstance
        fun resources(resourceProvider: ResourceProvider): Builder

        @BindsInstance
        fun api(api: NewsApi): Builder

        @BindsInstance
        fun transformModelToDto(transformer: SourceModelToSourceDtoTransformer): Builder

        @BindsInstance
        fun transformModelToEntity(transformer: SourceModelToSourceEntityTransformer): Builder

        @BindsInstance
        fun transformEntityToDto(transformer: SourceEntityToSourceDtoTransformer): Builder

        @BindsInstance
        fun dao(dao: SourceDAO): Builder

        fun build(): NewsListComponent

    }

    companion object {
        fun create() = with(DI) {
            DaggerNewsListComponent.builder()
                .resources(appComponent.resources())
                .api(retrofitComponent.api())
                .transformModelToDto(transformerComponent.transformModelToDto())
                .transformModelToEntity(transformerComponent.transformModelToEntity())
                .transformEntityToDto(transformerComponent.transformEntityToDto())
                .dao(database.dao())
                .build()
        }
    }
}