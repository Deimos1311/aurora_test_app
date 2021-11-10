package evgen.kolesnik.data.network.service

import evgen.kolesnik.data.models.NewsModel
import evgen.kolesnik.data.network.NewsNetConstants
import io.reactivex.rxjava3.core.Flowable
import retrofit2.http.GET
import retrofit2.http.Headers

interface NewsApi {

    @Headers("X-Api-Key: 24cfb3468dae49a89f02a23a36de3202")
    @GET(NewsNetConstants.ALL_NEWS)
    fun getAllNews(): Flowable<NewsModel>

}