package evgen.kolesnik.data.models

import com.google.gson.annotations.SerializedName

data class NewsModel(

    @SerializedName("sources")
    var sources: MutableList<SourceModel>

)