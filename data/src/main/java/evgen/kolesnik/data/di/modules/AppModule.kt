package evgen.kolesnik.data.di.modules

import dagger.Binds
import dagger.Module
import evgen.kolesnik.data.util.ResourceProvider
import evgen.kolesnik.data.util.ResourceProviderImpl
import javax.inject.Singleton

@Module
abstract class AppModule {

    @Binds
    @Singleton
    abstract fun bindResourceProvider(provider: ResourceProviderImpl): ResourceProvider

}