package evgen.kolesnik.data.models

import com.google.gson.annotations.SerializedName

data class SourceModel(

    @SerializedName("id")
    var id: String?,
    @SerializedName("name")
    var title: String?,
    @SerializedName("description")
    var description: String?,
    @SerializedName("url")
    var url: String?,
    @SerializedName("category")
    var category: String?,
    @SerializedName("language")
    var language: String?,
    @SerializedName("country")
    var country: String?

)
