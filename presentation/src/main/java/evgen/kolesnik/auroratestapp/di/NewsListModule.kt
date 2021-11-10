package evgen.kolesnik.auroratestapp.di

import androidx.lifecycle.ViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap
import evgen.kolesnik.auroratestapp.fragments.news_list_fragment.NewsListViewModel
import evgen.kolesnik.data.di.ViewModelKey

@Module
abstract class NewsListModule {

    @Binds
    @IntoMap
    @ViewModelKey(NewsListViewModel::class)
    abstract fun newsListViewModel(viewModel: NewsListViewModel): ViewModel

}