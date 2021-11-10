package evgen.kolesnik.data.di.components

import android.content.Context
import dagger.BindsInstance
import dagger.Component
import evgen.kolesnik.data.di.modules.AppModule
import evgen.kolesnik.data.util.ResourceProvider
import javax.inject.Singleton

@Component(modules = [AppModule::class])
@Singleton
interface AppComponent {

    fun resources(): ResourceProvider

    @Component.Builder
    interface Builder {
        @BindsInstance
        fun appContext(context: Context): Builder

        fun build(): AppComponent
    }

}