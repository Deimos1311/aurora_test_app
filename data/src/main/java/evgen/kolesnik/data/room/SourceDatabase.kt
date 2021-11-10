package evgen.kolesnik.data.room

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import evgen.kolesnik.data.room.entities.SourceEntity

@Database(
    entities = [SourceEntity::class], version = 1
)
abstract class SourceDatabase : RoomDatabase() {

    abstract val sourceDAO: SourceDAO

    companion object {
        @Volatile
        private var INSTANCE: SourceDatabase? = null

        fun getInstance(context: Context): SourceDatabase {
            synchronized(this) {
                return INSTANCE ?: Room.databaseBuilder(
                    context.applicationContext,
                    SourceDatabase::class.java,
                    "news_database"
                ).build().also {
                    INSTANCE = it
                }
            }
        }
    }
}