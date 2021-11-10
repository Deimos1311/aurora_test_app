package evgen.kolesnik.auroratestapp.fragments.news_list_fragment

import androidx.lifecycle.MutableLiveData
import evgen.kolesnik.auroratestapp.base.mvvm.BaseViewModel
import evgen.kolesnik.auroratestapp.base.mvvm.executeJob
import evgen.kolesnik.data.models.SourceModel
import evgen.kolesnik.data.network.service.NewsApi
import evgen.kolesnik.data.room.SourceDAO
import evgen.kolesnik.data.transformers.SourceEntityToSourceDtoTransformer
import evgen.kolesnik.data.transformers.SourceModelToSourceDtoTransformer
import evgen.kolesnik.data.transformers.SourceModelToSourceEntityTransformer
import evgen.kolesnik.data.util.ResourceProvider
import evgen.kolesnik.domain.dto.SourceDTO
import evgen.kolesnik.domain.outcome.Outcome
import io.reactivex.rxjava3.core.Flowable
import io.reactivex.rxjava3.schedulers.Schedulers
import javax.inject.Inject

class NewsListViewModel @Inject constructor(
    private val resources: ResourceProvider,
    private val api: NewsApi,
    private val transformModelToDto: SourceModelToSourceDtoTransformer,
    private val transformModelToEntity: SourceModelToSourceEntityTransformer,
    private val transformEntityToDto: SourceEntityToSourceDtoTransformer,
    private val dao: SourceDAO
) : BaseViewModel() {

    var apiData = MutableLiveData<Outcome<MutableList<SourceDTO>>>()
    var dbData = MutableLiveData<Outcome<MutableList<SourceDTO>>>()

    fun getAllNews() {
        addToDisposable(
            executeJob(
                api.getAllNews()
                    .map { it.sources }
                    .doOnNext { addAllNewsToDB(it) }
                    .map { transformModelToDto.convert(it) }, apiData
            )
        )
    }

    private fun addAllNewsToDB(list: MutableList<SourceModel>) {
        addToDisposable(
            Flowable.just(list)
                .map {
                    transformModelToEntity.convert(it)
                }
                .map {
                    dao.addAllNewsToDB(it)
                }
                .subscribeOn(Schedulers.io())
                .observeOn(Schedulers.io())
                .subscribe {}
        )
    }

    fun getNewsFromDb() {
        addToDisposable(
            executeJob(
                dao.getAllNewsFromDB().map { transformEntityToDto.convert(it) }, dbData
            )
        )
    }
}