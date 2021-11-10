package evgen.kolesnik.data.room

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import evgen.kolesnik.data.room.entities.SourceEntity
import io.reactivex.rxjava3.core.Flowable

@Dao
interface SourceDAO {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun addAllNewsToDB(newsList: MutableList<SourceEntity>)

    @Query("SELECT * FROM source_table")
    fun getAllNewsFromDB() : Flowable<MutableList<SourceEntity>>

}