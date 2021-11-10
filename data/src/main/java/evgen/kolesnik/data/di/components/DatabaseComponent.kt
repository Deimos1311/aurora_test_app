package evgen.kolesnik.data.di.components

import dagger.Component
import evgen.kolesnik.data.di.modules.DatabaseModule
import evgen.kolesnik.data.room.SourceDAO
import javax.inject.Singleton

@Component(modules = [DatabaseModule::class])
@Singleton
interface DatabaseComponent {

    fun dao(): SourceDAO

}
