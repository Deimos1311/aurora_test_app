package evgen.kolesnik.auroratestapp

import android.app.Application
import evgen.kolesnik.data.di.components.DaggerAppComponent
import evgen.kolesnik.data.di.components.DaggerDatabaseComponent
import evgen.kolesnik.data.di.components.DaggerRetrofitComponent
import evgen.kolesnik.data.di.components.DaggerTransformersComponent
import evgen.kolesnik.data.di.modules.DatabaseModule

class App : Application() {

    override fun onCreate() {
        super.onCreate()
        initDI()
    }

    private fun initDI() {
        DI.appComponent = DaggerAppComponent.builder()
            .appContext(this)
            .build()

        DI.retrofitComponent = DaggerRetrofitComponent.create()

        DI.transformerComponent = DaggerTransformersComponent.create()

        DI.database = DaggerDatabaseComponent.builder()
            .databaseModule(DatabaseModule(this))
            .build()
    }
}