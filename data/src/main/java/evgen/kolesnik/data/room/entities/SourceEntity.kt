package evgen.kolesnik.data.room.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import evgen.kolesnik.domain.STRING_NOT_AVAILABLE

@Entity(tableName = "source_table")
data class SourceEntity(

    @PrimaryKey
    @ColumnInfo(name = "id")
    var id: String = STRING_NOT_AVAILABLE,
    @ColumnInfo(name = "title")
    var title: String = STRING_NOT_AVAILABLE,
    @ColumnInfo(name = "description")
    var description: String = STRING_NOT_AVAILABLE,
    @ColumnInfo(name = "url")
    var url: String = STRING_NOT_AVAILABLE,
    @ColumnInfo(name = "category")
    var category: String = STRING_NOT_AVAILABLE,
    @ColumnInfo(name = "language")
    var language: String = STRING_NOT_AVAILABLE,
    @ColumnInfo(name = "country")
    var country: String = STRING_NOT_AVAILABLE

)
