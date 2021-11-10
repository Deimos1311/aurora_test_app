package evgen.kolesnik.auroratestapp

import evgen.kolesnik.data.di.components.AppComponent
import evgen.kolesnik.data.di.components.DatabaseComponent
import evgen.kolesnik.data.di.components.RetrofitComponent
import evgen.kolesnik.data.di.components.TransformersComponent

object DI {
    lateinit var appComponent: AppComponent
        internal set

    lateinit var retrofitComponent: RetrofitComponent
        internal set

    lateinit var transformerComponent: TransformersComponent
        internal set

    lateinit var database: DatabaseComponent
        internal set
}