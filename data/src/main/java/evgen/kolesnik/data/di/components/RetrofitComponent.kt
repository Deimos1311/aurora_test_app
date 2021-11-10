package evgen.kolesnik.data.di.components

import dagger.Component
import evgen.kolesnik.data.di.modules.RetrofitModule
import evgen.kolesnik.data.network.service.NewsApi
import javax.inject.Singleton

@Singleton
@Component(modules = [RetrofitModule::class])
interface RetrofitComponent {

    fun api(): NewsApi

}