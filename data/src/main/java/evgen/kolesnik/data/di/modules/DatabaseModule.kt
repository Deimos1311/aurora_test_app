package evgen.kolesnik.data.di.modules

import android.app.Application
import android.content.Context
import dagger.Module
import dagger.Provides
import evgen.kolesnik.data.room.SourceDAO
import evgen.kolesnik.data.room.SourceDatabase
import javax.inject.Singleton

@Module
class DatabaseModule(val application: Application) {

    @Singleton
    @Provides
    fun provideDao(database: SourceDatabase): SourceDAO = database.sourceDAO

    @Singleton
    @Provides
    fun providesDatabase(context: Context): SourceDatabase {
        return SourceDatabase.getInstance(context)
    }

    @Singleton
    @Provides
    fun provideApplicationContext(): Context = application.applicationContext
}
